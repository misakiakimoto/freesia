package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 管理者画面で商品情報を更新するクラス
 *@author JUNYA TAKENO
 *@since 2017/08/15
 *@version 1.0
 */

public class AdminItemUpdateDAO {

    /**
     * 商品情報を更新するメソッド
     * @author JUNYA TAKENO
     * @since 2017/08/15
     * @version 1.0
     * @param itemName 商品名
     * @param categoryId カテゴリーID
     * @param price 値段
     * @param stocks 在庫数
     * @param itemDetail 商品詳細
     * @param itemId 商品ID
     */

    private Connection con = new MySqlConnector("freesia").getConnection();

    public String insert(int userId, String herName, String comment, String title,  String imagepath1) throws Exception {

        String result = "error";

        String sql = "INSERT INTO collections(user_id,her_name,title,comment,img_path1)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, herName);
            ps.setString(3, title);
            ps.setString(4, comment);
            ps.setString(5, imagepath1);

            int rs = ps.executeUpdate();

            sql = "UPDATE img_path1 SET ";

            int i = 0;
            String text = "";
            String input;
            while (i < imagepath1.length()) {

                    input = "\'" + imagepath1+ "\'";

                sql += text + "img_path1" + (i + 1) + "=" + input;
                text = ", ";
                i++;
            }
            if (!text.equals("")) {
                sql += " WHERE user_id=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeUpdate();
                if(rs>0){
                    return result;
                }
            }

            con.close();

        } catch (SQLException e) {

        }
        result = "success";
        return result;

    }

}