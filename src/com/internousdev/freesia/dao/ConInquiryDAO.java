package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sundia.dto.ConInquiryDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/*

 */
/**
 * 管理者画面でから問い合わせ情報を表示するクラス
 * @author KAN MIKIO
 * @since 2017/07/14
 */

public class ConInquiryDAO {

    ArrayList<ConInquiryDTO> SearchList = new ArrayList<ConInquiryDTO>();

    /**
     * 問い合わせ情報のうち、指定された文字列がユーザー名に含まれるものを返す(指定が無い場合は全一覧を返す)
     * @param userName ユーザー名
     * @return SearchList 問い合わせ情報のリスト
     */
    public ArrayList<ConInquiryDTO> display(String userName) {
        Connection con = new MySqlConnector("sundia").getConnection();
        String sql = "select * from inquiry_histories";
        if (!userName.equals("")) {
            sql = sql + " where user_name like \'%" + userName + "%\'";
        }

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ConInquiryDTO dto = new ConInquiryDTO();
                dto.setUserName(rs.getString("user_name"));
                dto.setEmail(rs.getString("user_address"));
                dto.setUserTellNumber(rs.getString("user_tellnumber"));
                dto.setTitle(rs.getString("title"));
                dto.setComment(rs.getString("comment"));
                SearchList.add(dto);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SearchList;
    }
}
