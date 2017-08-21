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
        sql = "select * from items where item_id=?";
        String sql2 = "select * from items_images where item_id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                dto.setItemId(rs.getInt("item_id"));
                dto.setItemName(rs.getString("item_name"));
                dto.setPrice(rs.getFloat("price"));
                dto.setStocks(rs.getInt("stocks"));
                dto.setItemDetail(rs.getString("item_detail").replace("\n","<br>"));
                itemList.add(dto);

                ps.close();
                ps = con.prepareStatement(sql2);
                ps.setInt(1, itemId);
                rs = ps.executeQuery();

                int count=1;
                if(rs.next()){
                    while(rs.getString("img_path"+count)!=null){
                        dto.setImagePath(count-1,rs.getString("img_path"+count));
                        count++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        }
        return itemList;
    }
}
