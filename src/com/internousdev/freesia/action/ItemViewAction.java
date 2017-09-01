package com.internousdev.freesia.action;


import java.util.ArrayList;
import java.util.Map;

import com.internousdev.freesia.dao.ItemViewDAO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品一覧を表示するアクション
 * @author MISAKI AKIMOTO
 * @since 2017/07/13
 * @version 1.1
 */

public class ItemViewAction extends ActionSupport {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 8119766214351162676L;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 商品カテゴリー

    private String itemCategory;
    */
    private Map<String, Object> session;

    /**
     * 価格
     */
    private int price;

    /**
     * 画像パス
     */
    private String imagepath;

    /**
     * サーチリスト
     */
    public ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();


    /**
     * 実行メソッド
     * @return success or error
     */
    public String execute(){
        String result=ERROR;

        ItemViewDAO dao =new ItemViewDAO();

        itemList=dao.display(itemId);

        if(itemList.size()>0){
            result=SUCCESS;
            }
        return result;
        }


    /**
     * 商品IDを取得するメソッド
     * @return itemId 商品ID
     */
    public int getItemId() {
        return itemId;
        }

    /**
     * 商品IDを格納するメソッド
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
        }

    /**
     * 商品名を取得するメソッド
     * @return itemName 商品名
     */
    public String getItemName() {
        return itemName;
        }

    /**
     * 商品名を格納するメソッド
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
        }

    /**
     * 商品カテゴリーを取得するメソッド
     * @return itemCategory 商品カテゴリー

    public String getItemCategory() {
        return itemCategory;
        }

    /**
     * 商品カテゴリーを格納するメソッド
     * @param itemCategory 商品カテゴリー

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
        }

*/

    /**
     * 価格を取得するメソッド
     * @return price 価格
     */
    public int getPrice() {
        return price;
        }

    /**
     * 価格を格納するメソッド
     * @param price 価格
     */
    public void setPrice(int price) {
        this.price = price;
        }

    /**
     * 画像パスを取得するメソッド
     * @return imgAddress001 画像パス
     */
    public String getImagepath() {
        return imagepath;
        }

    /**
     * 画像パスを格納するメソッド
     * @param imgAddress001 画像パス
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
        }

    /**
     * サーチリストを取得するメソッド
     * @return searchList サーチリスト
     */
    public ArrayList<ItemDTO> getItemList() {
        return itemList;
        }

    /**
     * サーチリストを格納するメソッド
     * @param searchList サーチリスト
     */
    public void setItemList(ArrayList<ItemDTO> itemList) {
        this.itemList = itemList;
        }


    /**
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }


    /**
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}