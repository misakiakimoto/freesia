/**
 *
 */
package com.internousdev.freesia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.freesia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;
/**
 * 商品詳細表示に関するDAOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/10
 * @version 1.0
 */
public class GoItemDetailDAO {
    public ArrayList<ItemDTO> searchList=new ArrayList<ItemDTO>();


    /**
     *商品IDで商品詳細を取得しリストに格納するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/10
     * @version 1.0
     * @throws SQLException SQLのエラー
     * @param itemId 商品ID
     * @return itemList 商品情報を返す
     */
    public ArrayList<ItemDTO> selectbyItem(int itemId)throws SQLException {
        MySqlConnector db = new MySqlConnector("freesia");
        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ItemDTO dto = new ItemDTO();
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        String sql;
        sql = "select * from items where items_id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                dto.setItemId(rs.getInt("items_id"));
                dto.setItemName(rs.getString("items_name"));
                dto.setPrice(rs.getFloat("price"));
                dto.setStocks(rs.getInt("stocks"));
                dto.setItemDetail(rs.getString("items_detail").replace("\n","<br>"));
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