package com.internousdev.freesia.dao;
/**
 * アカウント詳細ページ(ユーザー)で使うユーザー情報を取得するためのDAO
 * @author  Ryota Shishikura
 * @since   2017/07/05
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.UsersDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

public class AccountDAO {
    /**
     * ログインしてるユーザーIDでユーザー情報を取ってくるメゾット
     * @author MISA OTSUKA
     * @since 2017/08/14
     * @version 1.0
     * @param userId ユーザー名
     * @return userList リストに代入 returnでactionに持ってく
     */

    public ArrayList<UsersDTO> select(int userId) {
        Connection con = new MySqlConnector("openconnect").getConnection();

        UsersDTO dto = new UsersDTO();

        String sql = "select * from users where user_id = ?";
        ArrayList<UsersDTO> userList = new ArrayList<UsersDTO>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dto.setUserId(rs.getInt("user_id"));
                dto.setPassword(rs.getString("password"));
                dto.setFamilyNameKanji(rs.getString("user_id"));
                dto.setFamilyNameKanji(rs.getString("family_name_kanji"));
                dto.setFamilyNameKana(rs.getString("family_name_kana"));
                dto.setGivenNameKanji(rs.getString("given_name_kanji"));
                dto.setGivenNameKana(rs.getString("given_name_kana"));
                dto.setPostal(rs.getString("postal"));
                dto.setAddress(rs.getString("address"));
                dto.setPhoneNumber(rs.getString("phone_number"));
                dto.setEmail(rs.getString("phone_email"));
                dto.setMobileNumber(rs.getString("mobile_number"));
                dto.setMobileEmail(rs.getString("mobile_email"));
                dto.setSex(rs.getString("sex"));
                dto.setBirthday(rs.getString("birthday"));
                userList.add(dto);
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}
