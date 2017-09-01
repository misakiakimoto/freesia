package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.CollectionsDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 商品一覧画面遷移に関するメソッド
 * @author MISAKI AKIMOTO
 * @since 2017/07/13
 * @version 1.1
 */

public class GoCollectionsDAO {

    ArrayList<CollectionsDTO> collectionsList =new ArrayList<CollectionsDTO>();

    public ArrayList<CollectionsDTO> display(int userId){
        MySqlConnector db=new MySqlConnector("freesia");
        Connection con=db.getConnection();
        String sql = "select * from collections";

        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                CollectionsDTO dto= new CollectionsDTO();
                dto.setUserId(rs.getInt("user_id"));
                dto.setHerName(rs.getString("her_name"));
                dto.setTitle(rs.getString("title"));
                dto.setComment(rs.getString("comment"));
                dto.setImagepath1(rs.getString("img_path1"));
                collectionsList.add(dto);
                }

            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
            }
        return collectionsList;
        }

}