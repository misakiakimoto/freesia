/**
 *
 */
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 決済に関するDAOクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/8/10
 * @version 1.0
 */
public class PurchaseCompleteDAO {

    /**
     * カートリストの商品に在庫切れのものがないかを確認するメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/8/10
     * @version 1.0
     * @param cartList アレイリストの値を返す
     * @return check 在庫があればOK、なければNGを返す
     */
    public String stockCheck(ArrayList<CartDTO> cartList) {
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = db.getConnection();
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        String sql = "select * from items where items_id=?";
        String check = "NG";
        for (int i = 0; i < cartList.size(); i++) {
            check = "NG";
            int add = 0;
            for (int a = 0; a < cartList.size(); a++) {
                if (cartList.get(i).getItemId() == cartList.get(a).getItemId()) {
                    add += cartList.get(a).getQuantities();
                }
            }
            ItemDTO dto = new ItemDTO();

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cartList.get(i).getItemId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    dto.setStocks(rs.getInt("stocks"));
                    dto.setItemName(rs.getString("items_name"));
                    itemList.add(dto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (dto.getStocks() < add) {
                check = dto.getItemName();
                break;

            }
            check = "OK";
        }
        return check;

    }

    /**
     * カートテーブルの情報を、購入情報(アウトライン)テーブルにインサートするメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/8/10
     * @version 1.0
     * @param userId ユーザーID
     * @return ret 成否を格納する変数
     */
    public int purchase1(int userId) {
        int ret = 0;
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = null;
        con = db.getConnection();
        CartDTO dto = new CartDTO();
        String select = "select * from carts where user_id = ?";
        String insert = "insert into purchases(user_id, total_price) values(?, ?)";
        try {
            PreparedStatement ps1 = con.prepareStatement(select);
            ps1.setInt(1, userId);
            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                dto.setUserId(rs.getInt("user_id"));
                dto.setSubtotal(rs.getFloat("total_price"));

                PreparedStatement ps2 = con.prepareStatement(insert);
                ps2.setInt(1, userId);
                ps2.setFloat(2, dto.getSubtotal());

                ret += ps2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * カートテーブルの情報を、購入情報テーブルにインサートするメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/8/10
     * @version 1.0
     * @param userId ユーザーID
     * @param totalPrice 合計金額
     * @param cartList アレイリストの値を返す
     * @return ret 成否を格納する変数
     */
    public int purchase(int userId, float totalPrice, ArrayList<CartDTO> cartList) {
        int ret = 0;
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = null;
        con = db.getConnection();
        String sql1 = "insert into purchases(user_id, total_price) values(?, ?)";
        String sql2 = "insert into purchases_details(purchase_id, user_id, items_id, quantities, multiplied_price) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql1, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setFloat(2, totalPrice);
            System.out.println(ps.toString());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int purchaseId = 0;
            if (rs.next()) {
                purchaseId = rs.getInt(1);
                System.out.println(purchaseId);
            }

            ps.close();
            rs.close();
            for (int i = 0; i < cartList.size(); i++) {
                ps = con.prepareStatement(sql2);
                ps.setInt(1, purchaseId);
                ps.setInt(2, userId);
                ps.setInt(3, cartList.get(i).getItemId());
                ps.setInt(4, cartList.get(i).getQuantities());
                ps.setFloat(5, cartList.get(i).getSubtotal());
                System.out.println(ps.toString());
                ps.executeUpdate();
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * カート情報を削除するメソッド
     * @param userId ユーザーID
     * @return ret 成否を格納する変数
     * @author  MISAKI AKIMOTO
     * @since 2017/8/10
     * @version 1.0
     */
    public int clean(int userId) {
        int ret = 0;
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = db.getConnection();
        String cleanCart = "delete from carts where user_id = ?";
        try {
            PreparedStatement ps1 = con.prepareStatement(cleanCart);
            ps1.setInt(1, userId);
            ret = ps1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 商品情報の在庫数を販売数だけ減らすメソッド
     * @param userId ユーザーID
     * @return ret 成否を格納する変数
     * @author  MISAKI AKIMOTO
     * @since 2017/8/10
     * @version 1.0
     */
    public int stockUpdate(int userId) {
        int ret = 0;
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = db.getConnection();
        String stockUpdate = "UPDATE items SET stocks = ? WHERE items_id = ?";
        ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        String sql = "select * from carts where user_id=?";
        String itemSql = "select * from items where items_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartDTO dto = new CartDTO();
                dto.setItemId(rs.getInt("items_id"));
                dto.setQuantities(rs.getInt("quantities"));
                cartList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < cartList.size(); i++) {
                ItemDTO dto = new ItemDTO();
                PreparedStatement ps = con.prepareStatement(itemSql);
                int itemId = cartList.get(i).getItemId();
                ps.setInt(1, itemId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dto.setStocks(rs.getInt("stocks"));
                    itemList.add(dto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            for (int i = 0; i < cartList.size(); i++) {
                PreparedStatement ps1 = con.prepareStatement(stockUpdate);
                int stocks = itemList.get(i).getStocks();

                int add = 0;
                for (int a = 0; a < cartList.size(); a++) {
                    if (cartList.get(i).getItemId() == cartList.get(a).getItemId()) {
                        add += cartList.get(a).getQuantities();
                    }
                }

                ps1.setInt(1, stocks - add);
                int itemId = cartList.get(i).getItemId();
                ps1.setInt(2, itemId);
                ret += ps1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 商品情報の売上数を販売数だけ増やすメソッド
     * @param userId ユーザーID
     * @return ret 成否を格納する変数
     * @author  misaki akimoto
     * @since 2017/8/10
     * @version 1.0
     */
    public int salesUpdate(int userId) {
        int ret = 0;
        MySqlConnector db = new MySqlConnector( "freesia");
        Connection con = db.getConnection();
        String stockUpdate = "UPDATE items SET sales = ? WHERE items_id = ?";
        ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        String sql = "select * from carts where user_id=?";
        String itemSql = "select * from items where items_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartDTO dto = new CartDTO();
                dto.setItemId(rs.getInt("items_id"));
                dto.setQuantities(rs.getInt("quantities"));
                cartList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < cartList.size(); i++) {
                ItemDTO dto = new ItemDTO();
                PreparedStatement ps = con.prepareStatement(itemSql);
                int itemId = cartList.get(i).getItemId();
                ps.setInt(1, itemId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dto.setSales(rs.getInt("sales"));
                    itemList.add(dto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            for (int i = 0; i < cartList.size(); i++) {
                PreparedStatement ps1 = con.prepareStatement(stockUpdate);
                int sales = itemList.get(i).getSales();

                int add = 0;
                for (int a = 0; a < cartList.size(); a++) {
                    if (cartList.get(i).getItemId() == cartList.get(a).getItemId()) {
                        add += cartList.get(a).getQuantities();
                    }
                }

                ps1.setInt(1, sales + add);
                int itemId = cartList.get(i).getItemId();
                ps1.setInt(2, itemId);
                ret += ps1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}