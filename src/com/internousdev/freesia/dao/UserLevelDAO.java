/**
 *
 */
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * usersテーブルから顧客情報を受け取るDAOクラス(管理画面)
 * @author JUNYA TAKENO
 * @since 2017/08/04
 * @version 1.0
 */

public class UserLevelDAO {

    /**
     * usersテーブルから取得した全ての顧客情報を格納するリスト
     * @author JUNYA TAKENO
     * @since 2017/08/04
     * @version 1.0
     * @param id ID
     * @return level レベル
     */

    public int select(int id) {
        Connection con = new MySqlConnector("openconnect").getConnection();
        String sql = "select  * from users where user_id=?";
        int level = 0;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                level = rs.getInt("user_flg");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }

}
