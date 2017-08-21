package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.PurchaseDetailDTO;
import com.internousdev.freesia.dto.PurchaseOutlineDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
* ユーザーが購入した情報を閲覧するクラス
*@author RYO SASAKI
*@since 2017/08/15
*@version 1.0
*/

public class AdminPurchaseDetailDAO {

    /**
     * 販売履歴を閲覧するメソッド
     * @author  RYO SASAKI
     * @since 2017/08/15
     * @version 1.0
     * @param purchaseId 購入ID
     * @return dto DTOをactionに返す
     */

    public PurchaseOutlineDTO getOutline(int purchaseId) {
        PurchaseOutlineDTO dto = new PurchaseOutlineDTO();
        Connection con = new MySqlConnector("freesia").getConnection();
        String table1 = "purchases_outlines";
        String table2 = "openconnect.users";
        String sql = "SELECT * FROM " + table1 + " INNER JOIN " + table2 + " ON " + table1 + ".user_id=" + table2
                + ".user_id WHERE purchase_id=" + purchaseId;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto.setPurchaseId(rs.getInt(table1 + ".purchase_id"));
                dto.setUserId(rs.getInt(table1 + ".user_id"));
                dto.setUserName(rs.getString(table2 + ".user_name"));
                dto.setTotalPrice(rs.getFloat(table1 + ".total_price"));
                dto.setPurchasedAt(rs.getTimestamp(table1 + ".purchased_at").toString());
                dto.setPostal(rs.getString(table2 + ".postal"));
                dto.setAddress(rs.getString(table2 + ".address"));
                dto.setPaymentMethodNumber(rs.getInt(table1 + ".payment_method"));
                dto.setIsComplete(rs.getBoolean(table1 + ".is_complete"));

            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    /**
     * テーブル結合するメソッド
     * @author  RYO SASAKI
     * @since 2017/08/15
     * @version 1.0
     * @param purchaseId 購入ID
     * @return dto DTOをactionに返す
     */

    public ArrayList<PurchaseDetailDTO> display(int purchaseId) {
        ArrayList<PurchaseDetailDTO> SearchList = new ArrayList<PurchaseDetailDTO>();
        Connection con = new MySqlConnector("freesia").getConnection();

        String table1 = "purchases_details";
        String table2 = "items";
        String table3 = "items_images";

        String sql = "SELECT * FROM " + table1;
        sql += " INNER JOIN " + table2 + " ON " + table1 + ".item_id=" + table2 + ".item_id";
        sql += " INNER JOIN " + table3 + " ON " + table1 + ".item_id=" + table3 + ".item_id";
        sql += " WHERE " + table1 + ".purchase_id=" + purchaseId;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            PurchaseDetailDTO dto;
            while (rs.next()) {
                dto = new PurchaseDetailDTO();

                dto.setItemId(rs.getInt(table1 + ".item_id"));
                dto.setItemName(rs.getString(table2 + ".item_name"));
                dto.setImagePath(rs.getString(table3 + ".img_path1"));
                dto.setPrice(rs.getFloat(table2 + ".price"));
                dto.setQuantities(rs.getInt(table1 + ".quantities"));
                dto.setMultipliedPrice(rs.getFloat(table1 + ".multiplied_price"));
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
