/**
 *
 */
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.PurchaseDetailDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 購入履歴画面のために購入履歴を引っ張ってくるDAOクラス
 * @author 	RYOTA SHISHIKURA
 * @since 	2017/07/10
 * @version 1.0
 */
public class HistoryDAO {

    /**
     * 購入履歴を格納する
     * *商品IDで商品詳細を取得しリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/10
     * @version 1.0
     * @param userId ユーザーID
     * @return purList 商品情報を返す
     */

    public ArrayList<PurchaseDetailDTO> select(int userId) {

        MySqlConnector db = new MySqlConnector( "freesia");
        Connection con = db.getConnection();

        String sql = "SELECT * FROM purchases_details WHERE user_id = ?";
        String sql2 = "SELECT item_name FROM items WHERE item_id = ?";
        ArrayList<PurchaseDetailDTO> purList = new ArrayList<PurchaseDetailDTO>();
        int itemId = 0;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PurchaseDetailDTO dto = new PurchaseDetailDTO();
                dto.setUserId(rs.getInt("user_id"));
                dto.setCreatedAt(rs.getString("purchased_at"));
                dto.setItemId(rs.getInt("item_id"));
                dto.setQuantities(rs.getInt("quantities"));
                dto.setMultipliedPrice(rs.getFloat("multiplied_price"));

                itemId = rs.getInt("item_id");

                PreparedStatement ps2 = con.prepareStatement(sql2);

                ps2.setInt(1, itemId);

                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {
                    dto.setItemName(rs2.getString("item_name"));
                }
                purList.add(dto);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return purList;
    }
}
