
package com.internousdev.freesia.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internousdev.freesia.dao.GoItemDetailDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ジャンル別に商品一覧を表示するクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/07/19
 * @version 1.0
 */
public class GoItemDetailAction extends ActionSupport {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 265702236011588767L;

    /**
     * 商品リスト
     */
    private List<ItemDTO> itemList;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 種類ID
     */
    private int categoryId;

    /**
     * 単価
     */

    private float price;

    /**
     * 商品画像01
     */
    private String itemImg01;

    /**
     * 商品画像02
     */
    private String itemImg02;

    /**
     * 商品詳細
     */
    private String itemDetail;

    /**
     * 商品一覧表示用リスト
     */
    private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

    /**
     * 在庫数をリストに格納
     */
    private ArrayList<Integer> stockList;

    /**
     * アイテムIDリスト
     */
    private List<CartDTO> itemIdList;

    /**
     * 注文個数
     */
    private int itemCount;
    /**

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * 顧客ID
     */
    private int userId;

    /**
     * メッセージ
     */
    private boolean msg;

    /**
     * 商品一覧表示用リストの生成
     * @author  MISAKI AKIMOTO
     * @since 2017/07/19
     *
     */
    public String execute() throws SQLException {
        String result = ERROR;
        GoItemDetailDAO dao = new GoItemDetailDAO();
        displayList = dao.selectbyItem(itemId);
        if (displayList.size() != 0) {
            result = SUCCESS;
        }
        return result;
    }

    /**
     * 実行メソッド
     * 商品詳細ページに遷移するメソッド
     * @author MISAKI AKIMOTO
     * @return result SUCCESS、ERROR
     * @throws SQLException エラー処理
     */
    public String execute2() throws SQLException {
        String result = ERROR;
        GoItemDetailDAO dao = new GoItemDetailDAO();
        stockList = new ArrayList<Integer>();
        itemList = dao.selectbyItem(itemId);
        if (session.containsKey("userId")) {
            setUserId((int) session.get("userId"));
        }
        for (int i = 1; i <= itemList.get(0).getStocks(); i++) {
            if (i >= 10) {
                break;
            }
            stockList.add(i);
        }

        for (CartDTO dto : itemIdList) {
            if (dto.getItemId() == itemId) {
                setMsg(true);
            }
        }
        return result;

    }

    /**
     * 商品IDを取得するメソッド
     * @return itemId　商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @param itemId セットする itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemsName　商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @param itemName セットする itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 種類IDを取得するメソッド
     * @return sortId 種類ID
     */
    public int getcategoryId() {
        return categoryId;
    }

    /**
     * 種類IDを格納するメソッド
     * @param categoryId セットする sortId
     */
    public void setSortId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 単価を取得するメソッド
     * @return price　単価
     */
    public float getPrice() {
        return price;
    }

    /**
     * 単価を格納するメソッド
     * @param price セットする price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 商品画像01を取得するメソッド
     * @return itemImg01　商品画像01
     */
    public String getItemImg01() {
        return itemImg01;
    }

    /**
     * 商品画像01を格納するメソッド
     * @param itemImg01 セットする itemImg01
     */
    public void setItemImg01(String itemImg01) {
        this.itemImg01 = itemImg01;
    }

    /**
     * 商品画像02を取得するメソッド
     * @return itemImg02　商品画像02
     */
    public String getItemImg02() {
        return itemImg02;
    }

    /**
     * 商品画像02を格納するメソッド
     * @param itemImg02 セットする itemImg02
     */
    public void setItemImg02(String itemImg02) {
        this.itemImg02 = itemImg02;
    }

    /**
     * 商品詳細を取得するメソッド
     * @return itemsDetail　商品詳細
     */
    public String getItemDetail() {
        return itemDetail;
    }

    /**
     * 商品詳細を格納するメソッド
     * @param itemDetail セットする itemDetail
     */
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    /**
     * 商品一覧表示用リストを取得するメソッド
     * @return displayList　商品一覧表示用リスト
     */
    public ArrayList<ItemDTO> getDisplayList() {
        return displayList;
    }

    /**
     * 商品一覧表示用リストを格納するメソッド
     * @param displayList セットする displayList
     */
    public void setDisplayList(ArrayList<ItemDTO> displayList) {
        this.displayList = displayList;
    }

    /**
     * @return stockList
     */
    public ArrayList<Integer> getStockList() {
        return stockList;
    }

    /**
     * @param stockList セットする stockList
     */
    public void setStockList(ArrayList<Integer> stockList) {
        this.stockList = stockList;
    }

    /**
     * @return itemCount
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * @param itemCount セットする itemCount
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * @return msg
     */
    public boolean isMsg() {
        return msg;
    }

    /**
     * @param msg セットする msg
     */
    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
