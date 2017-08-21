package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

    public String update(int itemId, int categoryId, String itemName, float price, int stocks, String itemDetail,
            String[] imagePath) throws Exception {
        String result = "error";
        try {
            String sql = "UPDATE items SET " + "item_name=?, "
                    + "category_id=?, "
                    + "price=?, "
                    + "stocks=?, "
                    + "item_detail=?, "
                    + "updated_at=current_timestamp "
                    + "WHERE item_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, itemName);
            ps.setInt(2, categoryId);
            ps.setFloat(3, price);
            ps.setInt(4, stocks);
            ps.setString(5, itemDetail);
            ps.setInt(6, itemId);

            int rs = ps.executeUpdate();

            sql = "UPDATE items_images SET ";

            int i = 0;
            String text = "";
            String input;
            while (i < imagePath.length) {
                if (imagePath[i].length() > 0) {
                    input = "\'" + imagePath[i] + "\'";
                } else {
                    input = "null";
                }
                sql += text + "img_path" + (i + 1) + "=" + input;
                text = ", ";
                i++;
            }
            if (!text.equals("")) {
                sql += " WHERE item_id=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, itemId);
                rs = ps.executeUpdate();
                if(rs>0){
                    return result;
                }
            }

            con.close();
        } catch (Exception e) {

        }
        result = "success";
        return result;
    }

}