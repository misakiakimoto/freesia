package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.freesia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
* ユーザーが購入した情報を閲覧するクラス
*@author MISAKI AKIMOTO
*@since 2017/08/15
*@version 1.0
*/

public class AdminItemEditDAO {

    /**
     * スイッチするメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/15
     * @version 1.0
     * @return dto DTOをactionに返す
     */

    private Connection con = new MySqlConnector("freesia").getConnection();
    private ItemDTO dto = new ItemDTO();

    public ItemDTO getItemData(int id) throws Exception {

        try {
            String sql1 = "SELECT * FROM items where item_id=?";
            String sql2 = "SELECT * FROM items_images WHERE item_id=?";
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                dto.setItemId(rs.getInt("item_id"));
                dto.setCategoryId(rs.getInt("category_id"));
                dto.setItemName(rs.getString("item_name"));
                dto.setPrice(rs.getFloat("price"));
                dto.setStocks(rs.getInt("stocks"));
                dto.setItemDetail(rs.getString("item_detail"));
                dto.setItemId(rs.getInt("item_id"));
                dto.setItemId(rs.getInt("item_id"));

                ps = con.prepareStatement(sql2);
                ps.setInt(1, dto.getItemId());
                rs = ps.executeQuery();
                int count = 1;
                if (rs.next()) {
                    while (rs.getString("img_path" + count) != null) {
                        dto.setImagePath(count - 1, rs.getString("img_path" + count));
                        count++;
                    }
                }

            }
            con.close();
        } catch (Exception e) {

        }
        return dto;
    }

}