package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 商品一覧画面遷移に関するメソッド
 * @author YUUKI KISHIGUCHI
 * @since 2017/07/13
 * @version 1.1
 */

public class ItemViewDAO {

    ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();

    public ArrayList<ItemDTO> display(int itemId){
        MySqlConnector db=new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "freesia", "root","mysql");
        Connection con=db.getConnection();
        String sql = "select * from items";

        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                ItemDTO dto= new ItemDTO();
                dto.setItemId(rs.getInt("items_id"));
                dto.setItemName(rs.getString("items_name"));
                dto.setPrice(rs.getInt("price"));
                dto.setImagepath(rs.getString("img_path"));
                itemList.add(dto);
                }

            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
            }
        return itemList;
        }

}