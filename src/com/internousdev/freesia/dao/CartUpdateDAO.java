package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * カートインサート＆アップデートに関するクラス
 *@author MISAKI AKIMOTO
 *@since 2017/08/15
 *@version 1.0
 */
public class CartUpdateDAO {

    /**
     *カート商品の数量を更新するメソッド
     *@author MISAKI AKIMOTO
     *@version 1.0
     *@since 2017/08/15
     *@param cartId カートID
     *@param userId ユーザーID
     *@param quantities 数量
     *@return int 成否を判断する変数
     *
     */
    public int updateCart(int cartId, int userId, int quantities) {
        int updateCount = 0;

        MySqlConnector db = new MySqlConnector( "freesia");
        Connection con = (Connection) db.getConnection();
        String sql = "update carts set quantities=? where user_id=? and cart_id=?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, quantities);
            ps.setInt(2, userId);
            ps.setInt(3, cartId);
            updateCount = ps.executeUpdate();
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
        return updateCount;
    }

}
