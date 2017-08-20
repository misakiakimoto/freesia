package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.sundia.dto.UsersDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * Oauthでログインに必要な情報を取得する為のDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/12
 * @version 1.0
 */

public class LoginOauthDAO {

    /**
     * 取得した情報を格納する為のDTO
     */

    private UsersDTO dto = new UsersDTO();

    /**
     * 取得したユニークIDを照合するためのメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/12
     * @version 1.0
     * @param userUniqueId OAuthのサービス先のユニークID
     * @param oauthName OAuthのサービス名
     * @return result 結果を返す
     */

    public boolean select(String userUniqueId, int oauthName) {
        MySqlConnector db = new MySqlConnector( "openconnect");
        ;
        Connection con = null;
        boolean result = false;
        con = db.getConnection();
        try {
            String sql = "SELECT * FROM users WHERE oauth_id = ? AND oauth_name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userUniqueId);
            stmt.setInt(2, oauthName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dto.setUserId(rs.getInt("user_id"));
                dto.setLoginFlg(rs.getBoolean("login_flg"));
                dto.setOauthId(rs.getString("oauth_id"));
                dto.setOauthAccount(rs.getString("oauth_account"));
                result = true;
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
        return result;
    }

    /**
     * ユニークIDを作成するためのメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/12
     * @version 1.0
     * @param uniqueId ユニークID
     * @param userName ユーザー名
     * @param oauthName OAuthのサービス名
     * @return result 結果を返す
     */

    public boolean insert(String uniqueId, String userName, int oauthName) {
        MySqlConnector db = new MySqlConnector( "openconnect");
        ;
        Connection con = null;
        boolean result = false;
        con = db.getConnection();
        String sql = "INSERT INTO users"
                + "(oauth_account, oauth_id, oauth_name, family_name, given_name, family_name_kanji,"
                + "family_name_kana,given_name_kanji, given_name_kana, sex)" + " values" + " (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, uniqueId);
            ps.setInt(3, oauthName);
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7, "");
            ps.setString(8, "");
            ps.setString(9, "");
            ps.setString(10, "");
            int insertCount = ps.executeUpdate();
            if (insertCount > 0) {
                result = true;
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
        return result;
    }

    /**
     * ログインフラグをTrueにするメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/12
     * @version 1.0
     * @param uniqueId ユニークID
     * @return count カウント
     */
    public int update(String uniqueId) {
        int count = 0;
        MySqlConnector db = new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "openconnect", "root",
                "mysql");
        ;
        Connection con = db.getConnection();
        String sql = "UPDATE users SET login_flg = true WHERE oauth_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, uniqueId);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * ユーザー情報のDTOを取得
     * @return dto ユーザー情報のDTO
     */
    public UsersDTO getUsersDTO() {
        return dto;
    }

    /**
     * ユーザー情報のDTOを格納
     * @param dto ユーザー情報のDTO
     */
    public void setLoginOauthDTO(UsersDTO dto) {
        this.dto = dto;
    }

}
