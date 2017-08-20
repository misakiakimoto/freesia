package com.internousdev.sundia.dto;

/**
 * アイテム表示に関するDTOクラス
 * @author JUNYA TAKENO
 * @since 2017/08/01
 * @version 1.0
 */

public class ItemDisplayDTO {

    /**
     * 表示用ID
     */
    private int id=0;

    /**
     * カテゴリー名
     */
    private String categoryName="";

    /**
     * 商品名
     */
    private String itemName="";

    /**
     * イメージパス
     */
    private String imgpath="";


    /**
     * 表示用IDを取得するメソッド
     * @return id 表示用ID
     */
    public int getId(){
        return id;
    }

    /**
     * 表示用IDを格納するメソッド
     * @param id セットする 表示用ID
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * カテゴリー名を取得するメソッド
     * @return categoryName カテゴリー名
     */
    public String getCategoryName(){
        return categoryName;
    }

    /**
     * カテゴリー名を格納するメソッド
     * @param categoryName セットする カテゴリー名
     */
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemName 商品名
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @param itemName セットする 商品名
     */
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /**
     * イメージパスを取得するメソッド
     * @return imgpath イメージパス
     */
    public String getImgpath(){
        return imgpath;
    }

    /**
     * イメージパスを格納するメソッド
     * @param imgpath セットする イメージパス
     */
    public void setImgpath(String imgpath){
        this.imgpath = imgpath;
    }

}
