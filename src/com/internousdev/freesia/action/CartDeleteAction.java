package com.internousdev.freesia.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.CartDeleteDAO;
import com.internousdev.freesia.dao.GoCartDAO;
import com.internousdev.freesia.dao.MyPageTestDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.dto.CreditDTO;
import com.internousdev.freesia.dto.UsersDTO;
import com.internousdev.freesia.util.CartAssist;

/**
 *  カートの中身を削除するクラス
 * @author MISAKI AKIMOTO
 * @version 1.0
 * @since 2017/8/10
 */

public class CartDeleteAction extends CartAssist implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = -1599187507724872727L;

    /**
     * 合計金額
     */
    private float amountAll;

    /**
     * 数量
     */
    private int quantities;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * カートID
     */
    private int cartId;

    /**
     * 削除処理をした件数
     */
    private int delCount;

    /**
     * 　セッション情報
     */
    private Map<String, Object> session;

    /**
     * 　検索したカート内の商品の情報を入れるリスト
     */
    private List<CartDTO> cartList = new ArrayList<>();
    /**
     *  ユーザー情報を入れるリスト（購入確認画面で必要）
     */
    public ArrayList<UsersDTO> usersList = new ArrayList<UsersDTO>();
    /**
     * クレジット情報を入れるリスト（購入確認画面で必要）
     */
    private ArrayList<CreditDTO> creditList = new ArrayList<CreditDTO>();

    /**
     * カートの中身の削除を実行するメソッド
     * @author MISAKI AKIMOTO
     * @version 1.0
     * @since 2017/8/10
     */
    public String execute() throws SQLException {
        String result = ERROR;

        /**
         *セッション情報切れになっていないかの確認
         */
        if (session.containsKey("userId")) {
            userId = (int) session.get("userId");

            CartDeleteDAO dao = new CartDeleteDAO();
            GoCartDAO dao2 = new GoCartDAO();

            delCount = dao.delete(userId, cartId);
            if (delCount > 0) {
                cartList = dao2.selectedItem(userId);
                if (cartList.size() > 0) {
                    for (int i = 0; i < cartList.size(); i++) {
                        amountAll += (cartList.get(i).getPrice()) * (cartList.get(i).getQuantities());
                    }
                    MyPageTestDAO dao3 = new MyPageTestDAO();
                    usersList = dao3.select(userId);
                    result = SUCCESS;
                }
            }

        } else {
            result = LOGIN;
        }
        return result;
    }

    /**
     * ユーザーIDを取得するためのメソッド
     * @return userId ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するためのメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * セッションを取得するためのメソッド
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * カート内の商品情報を取得するためのメソッド
     * @return cartList カート内の商品情報
     */
    public List<CartDTO> getCartList() {
        return cartList;
    }

    /**
     * カート内の商品情報を格納するためのメソッド
     * @param cartList セットする cartList
     */
    public void setCartList(List<CartDTO> cartList) {
        this.cartList = cartList;
    }

    /**
     * シリアルIDを取得するメソッド
     * @return serialversionuid シリアルID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * 合計金額を取得するメソッド
     * @return amountAll 合計金額
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
     * 数量を取得するメソッド
     * @return quantities 数量
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     * カート内の商品数を格納するメソッド
     * @param quantities セットする quantities
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * カートIDを取得するメソッド
     * @return cartId カートID
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * カート内商品IDを格納するメソッド
     * @param cartId セットする cartId
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * 削除処理をした件数を取得するメソッド
     * @return delCount 削除処理をした件数
     */
    public int getDelCount() {
        return delCount;
    }

    /**
     * 削除処理をした件数を格納するメソッド
     * @param delCount セットする delCount
     */
    public void setDelCount(int delCount) {
        this.delCount = delCount;
    }

    /**
     * ユーザー情報を入れるリスト（購入確認画面で必要）を取得するメソッド
     * @return usersList ユーザー情報を入れるリスト
     */
    public ArrayList<UsersDTO> getUsersList() {
        return usersList;
    }

    /**
     * ユーザー情報を入れるリスト（購入確認画面で必要）を格納するメソッド
     * @param usersList セットする usersList
     */
    public void setUsersList(ArrayList<UsersDTO> usersList) {
        this.usersList = usersList;
    }

    /**
     * クレジット情報を入れるリスト（購入確認画面で必要）を取得するメソッド
     * @return creditList クレジット情報を入れるリスト
     */
    public ArrayList<CreditDTO> getCreditList() {
       return creditList;
    }

    /**
     * クレジット情報を入れるリスト（購入確認画面で必要）を格納するメソッド
     * @param creditList セットする creditList
     */
    public void setCreditList(ArrayList<CreditDTO> creditList) {
        this.creditList = creditList;
    }

}
