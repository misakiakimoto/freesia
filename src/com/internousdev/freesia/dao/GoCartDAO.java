package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * カート遷移に関するDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/02
 * @version 1.0
 */
public class GoCartDAO {
    /**
     * カート内の商品情報を取得しリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/02
     * @version 1.0
     * @param userId ユーザーID
     * @return cartList カート内の商品情報を返す
     */
    public ArrayList<CartDTO> selectedItem(int userId) {

        MySqlConnector db = new MySqlConnector( "freesia");
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

                PreparedStatement ps2 = con.prepareStatement(select2);
                ps2.setInt(1, dto.getItemId());
                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {

                    dto.setItemName(rs2.getString("item_name"));
                    dto.setPrice(rs2.getFloat("price"));
                    dto.setSubtotal((int) (dto.getPrice() * dto.getQuantities()));
                }

                cartList.add(dto);
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
