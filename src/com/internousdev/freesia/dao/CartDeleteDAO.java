package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * カートテーブル内情報の削除に関するクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/15
 * @version 1.0
 */
public class CartDeleteDAO {

    /**
     * カート内の商品を削除するメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/05/24
     * @version 1.0
     * @param userId ユーザーID
     * @param cartId カートID
     * @return delCount 削除する件数
     */

    public int delete(int userId, int cartId) {
        int delCount = 0;
        MySqlConnector db = new MySqlConnector("sundia");
        Connection con = db.getConnection();
        String sql = "delete from carts where user_id=? and cart_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, cartId);
            delCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return delCount;
    }

}