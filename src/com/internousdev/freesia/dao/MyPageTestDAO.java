package com.internousdev.sundia.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sundia.dto.UsersDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * ユーザー情報をとってくるDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/7/05
 * @version 1.0
 */


public class MyPageTestDAO {

    /**
     * ログインしてるユーザーIDでユーザー情報を取ってくるメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/05
     * @version 1.0
     * @param userId ユーザーID
     * @return userList リストに代入 returnでactionに持ってく
     */
    public ArrayList<UsersDTO> select(int userId){

       MySqlConnector db = new MySqlConnector("sundia");
        Connection con = db.getConnection();

        UsersDTO dto = new UsersDTO();

        String sql = "select * from  users where user_id=?";
        ArrayList<UsersDTO> userList = new ArrayList<UsersDTO>();

        try{
            PreparedStatement ps =con.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                dto.setPassword(rs.getString("password"));
                dto.setEmail(rs.getString("phone_email"));
                dto.setAddress(rs.getString("address"));
                dto.setGivenNameKanji(rs.getString("given_name_kanji"));
                dto.setFamilyNameKanji( rs.getString("family_name_kanji"));
                dto.setUserId(rs.getInt("user_id"));

                userList.add(dto);
                return userList;
            }

        }
        catch (SQLException e) {e.printStackTrace();}

        finally{
            try{con.close();}
            catch(Exception e){e.printStackTrace();}

        }

        return userList;

    }

}