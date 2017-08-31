package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.PurchaseDetailDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 購入履歴をとってくるDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/7/05
 * @version 1.0
 */

public class PurchaseDetailDAO {

    /**
     * 購入履歴を取得してリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/05
     * @version 1.0
     * @return リストに代入 returnでactionに持ってく
     */

    /**
     * 購入履歴をリスト化
     */
    public ArrayList<PurchaseDetailDTO> UserPurchaseHistoryList = new ArrayList<PurchaseDetailDTO>();

    /**
    /**
     * 購入履歴を取得してリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/05
     * @version 1.0
     * @param userId ユーザーID
     * @param itemsName 商品名
     * @return UserPurchaseHistoryList アレイリストの値を返す
     */
    public ArrayList<PurchaseDetailDTO> UserPurchaseHistoryList(int userId, String itemsName) {

        MySqlConnector db = new MySqlConnector( "freesia");
        Connection con = db.getConnection();
        ArrayList<PurchaseDetailDTO> UserPurchaseHistoryList = new ArrayList<PurchaseDetailDTO>();
        int k = 1;

        String sql = "select * from purchases left join items on purchases.item_id = items.item_id where user_id=? and items_name=?";

        if (itemsName.equals("")) {

            sql = "select * from purchases left join items on purchases.item_id = items.item_id where user_id=?";
            k = 2;
        }
        if (userId == 0) {
            k = 0;
            sql = "";
        }

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            if (k == 1) {
                ps.setInt(1, userId);
                ps.setString(2, itemsName);
            }
            if (k == 2) {
                ps.setInt(1, userId);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                PurchaseDetailDTO dto = new PurchaseDetailDTO();

                dto.setUserId(rs.getInt("user_id"));
                dto.setItemId(rs.getInt("item_id"));
                dto.setCreatedAt(rs.getString("created_at"));
                dto.setQuantities(rs.getInt("quantities"));
                UserPurchaseHistoryList.add(dto);

                dto.setItemName(rs.getString("items_name"));
                dto.setPrice(rs.getFloat("multiplied_price"));
                dto.setMultipliedPrice(dto.getPrice() * dto.getQuantities());
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
        return UserPurchaseHistoryList;

    }

}
