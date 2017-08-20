package com.internousdev.sundia.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.GoCartDAO;
import com.internousdev.sundia.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カートの情報を取得するアクションクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/07/18
 * @version 1.0
 */

public class GoCartAction extends ActionSupport implements SessionAware {
    /**
     *シリアルID
     */
    private static final long serialVersionUID = 8015241731370150943L;
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
     *数量
     */
    private int quantities;
    /**
     *イメージパスファイル
     */
    private String imgPath;
    /**
     * 合計金額
     */
    private float amountAll;
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
     * @author  MISAKI AKIMOTO
     * @since 2017/07/18
     * @version 1.0
     */
    public String execute() throws SQLException {
        String result = ERROR;

        if (session.containsKey("userId")) {
            userId = (int) session.get("userId");

            GoCartDAO dao = new GoCartDAO();
            cartList = dao.selectedItem(userId);
            for (int i = 0; i < cartList.size(); i++) {
                amountAll += (cartList.get(i).getPrice()) * (cartList.get(i).getQuantities());
            }
            result = SUCCESS;
        }
        return result;
    }

    /**
     * ユーザーIDを取得するメソッド
     * @return userId ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 商品IDを取得するメソッド
     * @return itemId
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
     * @return itemName　商品名
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
     * 単価を格取得するメソッド
     * @return price　単価
     */
    public int getPrice() {
        return price;
    }

    /**
     * 単価を格納するメソッド
     * @param price セットする price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 数量を取得するメソッド
     * @return quantities　数量
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
     * イメージパスファイルを取得するメソッド
     * @return imgPath　イメージパスファイル
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * イメージパスファイルを格納するメソッド
     * @param imgPath セットする imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * 合計金額を取得するメソッド
     * @return amountAll　合計金額
     */
    public float getAmountAll() {
        return amountAll;
    }

    /**
     * 合計金額を格納するメソッド
     * @param amountAll セットする amountAll
     */
    public void setAmountAll(float amountAll) {
        this.amountAll = amountAll;
    }

    /**
     * カート内の商品情報を入れるリストを取得するメソッド
     * @return cartList　カート内の商品情報を入れるリスト
     */
    public ArrayList<CartDTO> getCartList() {
        return cartList;
    }

    /**
     * カート内の商品情報を入れるリストを格納するメソッド
     * @param cartList セットする cartList
     */
    public void setCartList(ArrayList<CartDTO> cartList) {
        this.cartList = cartList;
    }

    /**
     * セッション情報を取得するメソッド
     * @return session　セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}