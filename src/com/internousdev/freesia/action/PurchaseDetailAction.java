package com.internousdev.sundia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.PurchaseDetailDAO;
import com.internousdev.sundia.dto.PurchaseDetailDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品一覧から商品の一覧を取得するクラス
 * @author MISAKI AKIMOTO
 * @since 2017/05/19
 * @version 1.0
 */
public class PurchaseDetailAction extends ActionSupport implements SessionAware {

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 単価
     */
    private float price;

    /**
     * 数量
     */
    private int quantities;

    /**
     * 合計金額
     */
    public float subtotal;

    /**
     * 登録日
     */
    private String createdAt;

    /**
     * セッション情報（ログインユーザーID）
     */
    private Map<String, Object> session;

    /**
     * ユーザーの購入履歴リスト
     */
    private ArrayList<PurchaseDetailDTO> UserPurchaseHistoryList = new ArrayList<PurchaseDetailDTO>();

    /**
     *ユーザーの購入履歴リストの生成メソッド
     */
    public String execute() {
        String result = SUCCESS;
        userId = 0;

        if (session.containsKey("userId")) {
            userId = (int) session.get("userId");
        }

        ArrayList<PurchaseDetailDTO> allList = new ArrayList<PurchaseDetailDTO>();
        PurchaseDetailDAO dao = new PurchaseDetailDAO();
        allList = dao.UserPurchaseHistoryList(userId, "");
        int all = allList.size();
        for (int i = 0; i < all; i++) {
            PurchaseDetailDTO dto = new PurchaseDetailDTO();
            dto = allList.get(i);
            String str = dto.getItemName();
            if (str.startsWith(itemName)) {
                UserPurchaseHistoryList.add(dto);
            }

        }

        if (UserPurchaseHistoryList.size() == 0) {
            result = ERROR;
        }
        return result;
    }

    /**
     * ユーザーIDを取得するメソッド
     * @return userId　ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 会員IDを格納するメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
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
     * 商品IDを格納するメソッド
     * @param itemName セットする itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
     * 数量を取得するメソッド
     * @return quantities 数量
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     * 数量を格納するメソッド
     * @param quantities セットする quantities
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * 合計金額を取得するメソッド
     * @return subtotal 合計金額
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * 合計金額を格納するメソッド
     * @param subtotal セットする subtotal
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * 登録日を取得するメソッド
     * @return createdAt 登録日
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 登録日を格納するメソッド
     * @param createdAt セットする createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * セッション情報を取得するメソッド
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * ユーザーの購入履歴リストを格納するメソッド
     * @return userPurchaseHistoryList ユーザーの購入履歴リスト
     */
    public ArrayList<PurchaseDetailDTO> getUserPurchaseHistoryList() {
        return UserPurchaseHistoryList;
    }

    /**
     * ユーザーの購入履歴リストを格納するメソッド
     * @param userPurchaseHistoryList セットする userPurchaseHistoryList
     */
    public void setUserPurchaseHistoryList(ArrayList<PurchaseDetailDTO> userPurchaseHistoryList) {
        UserPurchaseHistoryList = userPurchaseHistoryList;
    }
}