package com.internousdev.freesia.action;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internousdev.freesia.dao.GoCollectionsDAO;
import com.internousdev.freesia.dto.CollectionsDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品一覧を表示するアクション
 * @author MISAKI AKIMOTO
 * @since 2017/07/13
 * @version 1.1
 */

public class GoCollectionsAction extends ActionSupport {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 8119766214351162676L;

    /**
     * 商品ID
     */
    private int userId;

    private String herName;

    private String title;

    private String comment;

    /**
     * イメージパス
     */
    private String imagepath1;

    /**
     * セッション情報
     */
    private Map<String,Object> session;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * レスポンス
     */
    private HttpServletResponse response;



    /**
     * サーチリスト
     */
    public ArrayList<CollectionsDTO> collectionsList=new ArrayList<CollectionsDTO>();


    /**
     * 実行メソッド
     * @return success or error
     */
    public String execute(){
        String result=ERROR;

        GoCollectionsDAO dao =new  GoCollectionsDAO();

        collectionsList=dao.display(userId);

        if(collectionsList.size()>0){
            result=SUCCESS;
            }
        return result;
        }


    /**
     * 商品IDを取得するメソッド
     * @return itemId 商品ID
     */
    public int getUserId() {
        return userId;
        }

    /**
     * 商品IDを格納するメソッド
     * @param itemId 商品ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
        }

    /**
     * 商品名を取得するメソッド
     * @return itemName 商品名
     */
    public String getHerName() {
        return herName;
        }

    /**
     * 商品名を格納するメソッド
     * @param itemName 商品名
     */
    public void setHerName(String herName) {
        this.herName = herName;
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
    public String getTitle() {
        return title;
        }

    /**
     * 価格を格納するメソッド
     * @param price 価格
     */
    public void setTitle(String title) {
        this.title = title;
        }

    public String getComment() {
        return comment;
        }

    /**
     * 価格を格納するメソッド
     * @param price 価格
     */
    public void setComment(String comment) {
        this.comment = comment;
        }

    /**
     * 画像パスを取得するメソッド
     * @return imgAddress001 画像パス
     */
    public String getImagepath1() {
        return imagepath1;
        }

    /**
     * 画像パスを格納するメソッド
     * @param imgAddress001 画像パス
     */
    public void setImagepath1(String imagepath1) {
        this.imagepath1 = imagepath1;
        }

    /**
     * サーチリストを取得するメソッド
     * @return searchList サーチリスト
     */
    public ArrayList<CollectionsDTO> getCollectionsList() {
        return collectionsList;
        }

    /**
     * サーチリストを格納するメソッド
     * @param searchList サーチリスト
     */
    public void setCollectionsList(ArrayList<CollectionsDTO> collectionsList) {
        this.collectionsList = collectionsList;
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



    /**
     * リクエストを取得
     * @return request リクエスト
     */
    public HttpServletRequest getServletRequest() {
        return this.request;
    }

    /**
     * リクエストを設定
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }

    /**
     * レスポンスを取得
     * @return response レスポンス
     */
    public HttpServletResponse getServletResponse() {
        return this.response;
    }
}