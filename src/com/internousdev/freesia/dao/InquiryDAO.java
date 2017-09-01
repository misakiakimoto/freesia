package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.freesia.dto.UsersDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 問い合わせフォームで入力された情報を、データベースに送るクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/10
 * @version 1.0
 */
public class InquiryDAO {

    /**
     * ログインしていない状態で問い合わせフォームに入力されたときに実行されるメソッド
     * @param userName 問い合わせ者名
     * @param userAddress 問い合わせ者の住所
     * @param userTellNumber 問い合わせ者の電話番号
     * @param title 件名
     * @param comment 本文
     * @param login ログイン情報
     * @return countをactionに返す
     */
    public int insertDAO(String userName, String userAddress, String userTellNumber, String title, String comment,
            boolean login) {
        int count = 0;

        Connection con = new MySqlConnector("freesia").getConnection();
        String sql = "INSERT INTO inquiry_histories(user_name,user_address,user_tellnumber,title,comment,login)VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, userAddress);
            ps.setString(3, userTellNumber);
            ps.setString(4, title);
            ps.setString(5, comment);
            ps.setBoolean(6, login);

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
     * ログインしている状態で問い合わせフォームから送信された時に実行するメソッド
     * @param userName 問い合わせ者の名前
     * @param userTellNumber 問い合わせ者の電話番号
     * @param title  件名
     * @param comment 本文
     * @param login ログイン情報
     * @param usersId  ユーザーID
     * @return countをactionに返す
     */
    public int insertDAO(String userName, String userTellNumber, String title, String comment, boolean login,
            int usersId) {
        int count = 0;

        Connection con = new MySqlConnector("freesia").getConnection();
        String sql = "INSERT INTO inquiry_histories(user_name,user_address,user_tellnumber,title,comment,login)VALUES(?,?,?,?,?,?)";
        Connection con2 = new MySqlConnector("openconnect").getConnection();
        String sql2 = "SELECT phone_email FROM users where user_id=?";
        UsersDTO dto = new UsersDTO();

        try {
            PreparedStatement ps2 = con2.prepareStatement(sql2);
            ps2.setInt(1, usersId);
            ResultSet rs = ps2.executeQuery();

            if (rs.next()) {
                dto.setEmail(rs.getString("phone_email"));
            }

            String userAddress = dto.getEmail();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, userAddress);
            ps.setString(3, userTellNumber);
            ps.setString(4, title);
            ps.setString(5, comment);
            ps.setBoolean(6, login);
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                con2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}