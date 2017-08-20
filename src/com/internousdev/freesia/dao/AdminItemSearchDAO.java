package com.internousdev.sundia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.sundia.dto.ItemDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
* ユーザーが購入した情報を閲覧するクラス
*@author JUNYA TAKENO
*@since 2017/08/15
*@version 1.0
*/

public class AdminItemSearchDAO {


    /**
     * スイッチするメソッド
     * @author JUNYA TAKENO
     * @since 2017/08/15
     * @version 1.0
     * @param itemId 商品ID
     * @param categoryId カテゴリーID
     * @param itemName 商品名
     * @param price 価格
     * @param stocks 在庫数
     * @param sales
     * @param itemDetail 商品詳細
     * @param isDeleted 削除
     * @param createdAt 追加
     * @param updatedAt 更新
     */

    private ArrayList<ItemDTO> itemList= new ArrayList<ItemDTO>();
    private ItemDTO itemDTO = new ItemDTO();

    private String sql1,sql2;
    private PreparedStatement ps1,ps2;
    private ResultSet rs1,rs2;

    public ArrayList<ItemDTO> generateItemList(String chkisDeleted,int chkCategoryId,String chkItemName) throws Exception{
        try{
            final Connection con=new MySqlConnector("sundia").getConnection();

            sql1 ="SELECT * FROM items";
            sql2 ="SELECT * FROM items_images WHERE item_id=?";

            String searchCondition="",multiCondition="";
            if(!chkisDeleted.equals("noselect")){
                    searchCondition += multiCondition+" is_deleted="+chkisDeleted;
                    multiCondition=" AND";
            }
            if(chkCategoryId!=0){
                searchCondition += multiCondition+" category_id="+chkCategoryId;
                multiCondition=" AND";
            }
            if(!chkItemName.equals("")){
                searchCondition += multiCondition+" item_name like \'%"+chkItemName+"%\'";
                multiCondition=" AND";
            }

            if(searchCondition!=""){
                sql1 += " WHERE"+searchCondition;
            }

            ps1 = con.prepareStatement(sql1);
            rs1 = ps1.executeQuery();


            while(rs1.next()){
                itemDTO = new ItemDTO();
                itemDTO.setItemId(rs1.getInt("item_id"));
                itemDTO.setCategoryId(rs1.getInt("category_id"));
                itemDTO.setItemName(rs1.getString("item_name"));
                itemDTO.setPrice(rs1.getFloat("price"));
                itemDTO.setStocks(rs1.getInt("stocks"));
                itemDTO.setSales(rs1.getInt("sales"));
                itemDTO.setItemDetail(rs1.getString("item_detail").replace("\n","<br>"));
                itemDTO.setIsDeleted(rs1.getBoolean("is_deleted"));
                itemDTO.setCreatedAt(rs1.getTimestamp("created_at").toString());
                itemDTO.setUpdatedAt(rs1.getTimestamp("updated_at").toString());

                ps2 = con.prepareStatement(sql2);
                ps2.setInt(1,itemDTO.getItemId());
                rs2 = ps2.executeQuery();
                int count=1;
                if(rs2.next()){
                    while(rs2.getString("img_path"+count)!=null){
                        itemDTO.setImagePath(count-1,rs2.getString("img_path"+count));
                        count++;
                    }
                }

                itemList.add(itemDTO);


            }
        con.close();

        }catch(Exception e){

        }
        return itemList;
    }


}