/**
 *
 */
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.freesia.dto.UsersDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 *  入力された情報に従いlogin処理を行うDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/10
 * @version 1.0
 */

public class LoginDAO {
    /**
     * ユーザー情報を取得するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/10
     * @version 1.0
     * @param email メールアドレス
     * @param password パスワード
     * @return dto ユーザー情報を返す
     */
    public UsersDTO select(String email, String password) {
        MySqlConnector db = new MySqlConnector("openconnect");
        Connection con = db.getConnection();
        UsersDTO dto = new UsersDTO();
        String sql = "select  * from users where phone_email=? and password=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dto.setEmail(rs.getString("email"));
                dto.setPassword(rs.getString("password"));
                dto.setUserId(rs.getInt("user_id"));
                dto.setLoginFlg(rs.getBoolean("login_flg"));
                dto.setUserFlg(rs.getInt("user_flg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    /**
     * ログインフラグをアップデートするメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/10
     * @version 1.0
     * @param email メールアドレス
     * @param password パスワード
     * @return count 更新回数を返す
     */
    public int flgupdate(String email, String password) {
        int count = 0;
        MySqlConnector db = new MySqlConnector( "openconnect");
        Connection con = db.getConnection();
        String sql = "update users set login_flg =true where phone_email=? and password=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    /**
     *  ログインフラグを立てたままセッションを切ってしまった人むけの処理
     * @author MISAKI AKIMOTO
     * @since 2017/07/10
     * @version 1.0
     * @param name 名前
     * @param password パスワード
     * @return count 更新回数を返す
     */
    public int loginflg(String name, String password) {
        int count = 0;
        MySqlConnector db = new MySqlConnector("openconnect");
        Connection con = (Connection) db.getConnection();

        String sql = "update users set login_flg=false where family_name=? and password=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, password);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
