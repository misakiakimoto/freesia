package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sundia.dto.PurchaseOutlineDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
* ユーザーが購入した情報を閲覧するクラス
*@author RYO SASAKI
*@since 2017/08/15
*@version 1.0
*/

public class AdminPurchaseOutlineDAO {

    /**
    * 販売履歴を閲覧するメソッド
    * @author  RYO SASAKI
    * @since 2017/08/15
    * @version 1.0
    */

    ArrayList<PurchaseOutlineDTO> SearchList = new ArrayList<PurchaseOutlineDTO>();

    public ArrayList<PurchaseOutlineDTO> display(int userId, String userName, String address, String isComplete) {
        Connection con = new MySqlConnector("sundia").getConnection();
        String table1 = "purchases_outlines";
        String table2_1 = "openconnect.", table2_2 = "users", table2 = table2_1 + table2_2;
        String sql = "SELECT * FROM " + table1 + " INNER JOIN " + table2 + " ON " + table1 + ".user_id=" + table2
                + ".user_id";

        String text = " WHERE ";
        if (userId != 0) {
            sql += text + table1 + ".user_id=" + userId;
            text = ", ";
        }
        if (userName.length() > 0) {
            sql += text + table2 + ".user_name like \'%" + userName + "%\'";
            text = ", ";
        }
        if (address.length() > 0) {
            sql += text + table2 + ".address like \'%" + address + "%\'";
            text = ", ";
        }
        if (isComplete.equals("true") || isComplete.equals("false")) {
            sql += text + table1 + ".is_complete=" + isComplete;
            text = ", ";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            PurchaseOutlineDTO dto;
            while (rs.next()) {
                dto = new PurchaseOutlineDTO();

                dto.setPurchaseId(rs.getInt(table1 + ".purchase_id"));
                dto.setUserId(rs.getInt(table1 + ".user_id"));
                dto.setUserName(rs.getString(table2_2 + ".user_name"));
                dto.setTotalPrice(rs.getFloat(table1 + ".total_price"));
                dto.setPurchasedAt(rs.getTimestamp(table1 + ".purchased_at").toString());
                dto.setPostal(rs.getString(table2_2 + ".postal"));
                dto.setAddress(rs.getString(table2_2 + ".address"));
                dto.setPaymentMethodNumber(rs.getInt(table1 + ".payment_method"));
                dto.setIsComplete(rs.getBoolean(table1 + ".is_complete"));

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
