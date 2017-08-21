package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.PurchaseSecondDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カートの情報を取得するアクションクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/08/10
 * @version 1.0
 */

public class PurchaseSecondAction extends ActionSupport implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 6032973209189015046L;
    /**
     *ユーザーID
     */
    private int userId;
    /**
     *商品ID
     */
    private int itemId;
    /**
     *商品名
     */
    private String itemName;
    /**
     * 単価
     */
    private int price;

    /**
     * 合計金額
     */
    private int totalPrice;

    /**
     *数量
     */
    private int quantities;

    /**
     * 合計個数
     */
    private int numberPurchased;

    /**
     * 合計金額
     */
    private int amountAll;

    /**
     * cartテーブルからのselect（検索）の成否を示すフラグ
     */
    private boolean cartFlag;

    /**
     * クレジットカードのリストが空でないかどうかを示すフラグ
     */
    private boolean creditFlag;

    /**
     * カート内の商品情報を入れるリスト
     */
    private ArrayList<CartDTO> cartList = new ArrayList<>();
    /**
     *セッション情報
     */
    private Map<String, Object> session;

    /**
     * 実行メソッド
     * 処理内容と順番
     * 1：セッション情報を持っているか判断
     * 2：session内のuserIdを使用し、カートへ登録された情報を取得
     * 3：カート内の情報を元に合計金額を算出
     */
    public String execute() {
        String result = ERROR;

        int listSize = 0;
        int totalAmountFloat = 0;
        numberPurchased = 0;
        amountAll = 0;

        if (session.containsKey("userId")) {
            userId = (int) session.get("userId");

            PurchaseSecondDAO dao = new PurchaseSecondDAO();
            cartList = dao.selectCartRecord(userId);
            listSize = cartList.size();

            for (int i = 0; i < listSize; i++) {
                numberPurchased += cartList.get(i).getQuantities();
                totalAmountFloat += (cartList.get(i).getPrice()) * (int) (cartList.get(i).getQuantities());
                amountAll = (int) totalAmountFloat;

            }

        }

        return result;
    }

    /**
     * ユーザーIDを取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param userId ユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 商品IDを取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名を取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 単価を格取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 単価を格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param price 単価
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 注文数量を取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return quantities
     */
    public int getquantities() {
        return quantities;
    }

    /**
     * 注文数量を格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param quantities 注文数量
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * 合計金額を取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return amountAll
     */
    public int getAmountAll() {
        return amountAll;
    }

    /**
     * 合計金額を格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param amountAll 合計金額
     */
    public void setAmountAll(int amountAll) {
        this.amountAll = amountAll;
    }

    /**
     * カート内の商品情報を入れるリストを取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return cartList
     */
    public ArrayList<CartDTO> getCartList() {
        return cartList;
    }

    /**
     * カート内の商品情報を入れるリストを格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param cartList カート内の商品情報を入れる
     */
    public void setCartList(ArrayList<CartDTO> cartList) {
        this.cartList = cartList;
    }

    /**
     * セッション情報を取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param session セッション情報
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 合計金額取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * 合計金額格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param totalPrice 合計金額
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * cartテーブルからのselect（検索）の成否を示すフラグ
     * @author  MISAKI AKIMOTO
     * @return cartFlag
     */
    public boolean isCartFlag() {
        return cartFlag;
    }

    /**
     * cartテーブルからのselect（検索）の成否を示すフラグ
     * @author  MISAKI AKIMOTO
     * @param cartFlag カートフラグ
     */
    public void setCartFlag(boolean cartFlag) {
        this.cartFlag = cartFlag;
    }

    /**
     * クレジットカードのリストが空でないかどうかを示すフラグ
     * @author  MISAKI AKIMOTO
     * @return creditFlag
     */
    public boolean isCreditFlag() {
        return creditFlag;
    }

    /**
     * クレジットカードのリストが空でないかどうかを示すフラグ
     * @author  MISAKI AKIMOTO
     * @param creditFlag クレジットカードフラグ
     */
    public void setCreditFlag(boolean creditFlag) {
        this.creditFlag = creditFlag;
    }

    /**
     * 合計商品点数取得するメソッド
     * @author  MISAKI AKIMOTO
     * @return numberPurchased
     */
    public int getNumberPurchased() {
        return numberPurchased;
    }

    /**
     * 合計商品点数格納するメソッド
     * @author  MISAKI AKIMOTO
     * @param numberPurchased 合計商品点数
     */
    public void setNumberPurchased(int numberPurchased) {
        this.numberPurchased = numberPurchased;
    }

}