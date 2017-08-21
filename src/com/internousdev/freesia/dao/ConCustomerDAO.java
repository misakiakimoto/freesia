package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.ConCustomerDTO;
import com.internousdev.util.db.mysql.MySqlConnector;
import com.mysql.jdbc.PreparedStatement;

/**
 * 管理者画面で検索ワードを元にDBから顧客情報を検索するクラス
 * @author YUITO YAMAMOTO
 * @since 2017/08/15
 * @version 1.0
 */

public class ConCustomerDAO {

    /**
    * 顧客情報をDBから検索するメソッド
    * @auther JUNYA TAKENO
    * @version 1.0
    * @version 1.0
    * @since 2017/07/14
    * @param userId ユーザーID
    * @param userName 氏名
    * @param phoneEmail メールアドレス
    * @param phoneNumber 電話番号
    * @param address 住所
    * @return SearchListを返す
    */

    ArrayList<ConCustomerDTO> SearchList = new ArrayList<ConCustomerDTO>();

    public ArrayList<ConCustomerDTO> display(String searchUserName) {
        Connection con = new MySqlConnector("openconnect").getConnection();
        String sql = "select * from users";

        if (!searchUserName.equals("")) {
            sql = sql + " where user_name like \'%" + searchUserName + "%\'";
        }

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ConCustomerDTO dto = new ConCustomerDTO();
                dto.setUserId(rs.getInt("user_id"));
                dto.setUserName(rs.getString("user_name"));
                dto.setPhoneEmail(rs.getString("phone_email"));
                dto.setPhoneNumber(rs.getString("phone_number"));
                dto.setAddress(rs.getString("address"));
                SearchList.add(dto);

            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SearchList;
    }
}
