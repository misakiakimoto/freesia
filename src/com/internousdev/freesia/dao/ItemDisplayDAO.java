
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.ItemDisplayDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 商品一覧画面遷移に関するDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/03
 * @version 1.0
 */

public class ItemDisplayDAO {

    /**
     * 商品情報を取得しリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/03
     * @version 1.0
     * @param Id ID
     * @param CategoryName カテゴリー名
     * @param itemName 商品名
     * @param imgPath 画像パス
     */

    private ArrayList<ItemDisplayDTO> itemList = new ArrayList<ItemDisplayDTO>();
    private Connection con = new MySqlConnector("freesia").getConnection();
    private ItemDisplayDTO dto = new ItemDisplayDTO();
    private PreparedStatement ps;
    private ResultSet rs1, rs2, rs3;

    private String sql1 = "select * from categories";
    private String sql2 = "select * from items where is_deleted=false and category_id=?";
    private String sql3 = "select * from items_images where item_id=?";

    public ArrayList<ItemDisplayDTO> generateItemList() {
        try {
            ps = con.prepareStatement(sql1);
            rs1 = ps.executeQuery();
            while (rs1.next()) {
                dto = new ItemDisplayDTO();
                dto.setId(rs1.getInt("category_id"));
                dto.setCategoryName(rs1.getString("category_name"));
                itemList.add(dto);

                ps = con.prepareStatement(sql2);
                ps.setInt(1, dto.getId());
                rs2 = ps.executeQuery();
                while (rs2.next()) {
                    dto = new ItemDisplayDTO();
                    dto.setId(rs2.getInt("item_id"));
                    dto.setItemName(rs2.getString("item_name"));

                    ps = con.prepareStatement(sql3);
                    ps.setInt(1, dto.getId());
                    rs3 = ps.executeQuery();
                    if (rs3.next()) {
                        dto.setImgpath(rs3.getString("img_path1"));
                    }
                    itemList.add(dto);

                }

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;

    }
}
