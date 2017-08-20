package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sundia.dto.CartDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * カート遷移に関するDAOクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/07/28
 * @version 1.0
 */
public class PurchaseSecondDAO {

    /**
     * カート内の商品情報を取得しリストに格納するメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/07/28
     * @version 1.0
     * @param userId ユーザーID
     * @return cartList カート内の商品情報
     */
    public ArrayList<CartDTO> selectCartRecord(int userId) {

        MySqlConnector db = new MySqlConnector("sundia");
        Connection con = db.getConnection();
        ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

        String sql = "select * from carts where user_id=?";
        String sql2 = "select * from items where item_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartDTO dto = new CartDTO();
                dto.setUserId(rs.getInt("user_id"));
                dto.setItemId(rs.getInt("item_id"));
                dto.setQuantities(rs.getInt("quantities"));
                cartList.add(dto);

                PreparedStatement ps2 = con.prepareStatement(sql2);
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