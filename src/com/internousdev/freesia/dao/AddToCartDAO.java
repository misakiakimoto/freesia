package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sundia.dto.CartDTO;
import com.internousdev.sundia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * カートテーブル情報追加に関するクラス
 * @author  MISAKI AKIMOTO
 * @since  2017/07/24
 * @version 1.0
 */

public class AddToCartDAO {

    /**
     * カートテーブルに追加する商品の情報を取得するメソッド
     * @author  MISAKI AKIMOTO
     * @since  2017/07/24
     * @version 1.0
     * @param itemId 商品ID
     * @return itemStatus 成否を格納する変数
     */

    public ArrayList<ItemDTO> itemStatus(int itemId) {

        MySqlConnector db = new MySqlConnector("sundia");
        Connection con = db.getConnection();
        ArrayList<ItemDTO> itemStatus = new ArrayList<ItemDTO>();

        String sql = "select * from items where item_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItemDTO dto = new ItemDTO();
                dto.setItemName(rs.getString("item_name"));
                dto.setPrice(rs.getFloat("price"));
                dto.setStocks(rs.getInt("stocks"));
                dto.setItemDetail(rs.getString("item_detail"));

                itemStatus.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return itemStatus;
    }

    /**
     * カートテーブルへ情報をインサートするメソッド
     * @author  MISAKI AKIMOTO
     * @since  2017/07/24
     * @version 1.0
     * @param userId ユーザーID
     * @param itemId 商品ID
     * @return addCount 成否を格納する変数
     */

    public int addToCart(int userId, int itemId) {
        int addCount = 0;

        Connection con = new MySqlConnector("sundia").getConnection();
        System.out.println(userId + "," + itemId);
        String sql = "insert into carts (user_id,item_id) values(?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, itemId);
            addCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return addCount;
    }

    /**
     * カート内の商品情報を取得しリストに格納するメソッド
     * @author  MISAKI AKIMOTO
     * @since  2017/07/24
     * @version 1.0
     * @param userId ユーザーID
     * @return cartList カート情報
     */
    public ArrayList<CartDTO> selected(int userId) {


        MySqlConnector db = new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "sundia", "root",
                "mysql");
        Connection con = db.getConnection();
        ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
        String sql = "select * from carts where user_id=?";
        String select2 = "SELECT * FROM items WHERE item_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartDTO dto = new CartDTO();
                dto.setUserId(rs.getInt("user_id"));
                dto.setCartId(rs.getInt("cart_id"));
                dto.setItemId(rs.getInt("item_id"));
                dto.setQuantities(rs.getInt("quantities"));
                cartList.add(dto);

                PreparedStatement ps2 = con.prepareStatement(select2);
                ps2.setInt(1, dto.getItemId());
                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {

                    dto.setItemName(rs2.getString("item_name"));
                    dto.setPrice(rs2.getFloat("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }
}