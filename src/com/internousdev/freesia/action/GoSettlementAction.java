/**
 *
 */
package com.internousdev.freesia.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.GoCartDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.util.CartAssist;

/**決済入力画面に遷移するためのクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/08/02
 * @version 1.0
 */
public class GoSettlementAction extends CartAssist implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = -7319753971378037381L;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * カート内の価格合計
     */
    private int totalPrice;

    /**
     * 商品ごとの注文数
     */
    private int quantities;

    /**
     * エラーメッセージ
     */
    private String errorMessage;

    /**
     * cart情報を格納するリスト
     */
    private List<CartDTO> cartList;


    /**
     * セッション情報
     */
    private Map<String,Object> session;

    /**
     * 決済画面の遷移を実行するメソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/08/02
     * @version 1.0
     */
    public String execute() throws SQLException{
        String result=ERROR;

        if (session.containsKey("userId")) {
            userId = (int)session.get("userId");

            GoCartDAO dao = new GoCartDAO();
            cartList = dao.selectedItem(userId);
            if(cartList.size() > 0){
                result = SUCCESS;
            }
        }else{
            result = LOGIN;
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
     * ユーザーIDを格納するメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 合計金額を取得するメソッド
     * @return totalPrice　合計金額
     */
    public  int getTotalPrice(){
        return totalPrice;
    }

    /**
     * 合計金額を格納するメソッド
     * @param totalPrice セットする payment
     */
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }

    /**
     * エラーメッセージを取得するメソッド
     * @return errorMessage　エラーメッセージ
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * エラーメッセージを格納するメソッド
     * @param errorMessage セットする errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * カートの情報リストを取得するメソッド
     * @return cartList　カート内情報リスト
     */
    public List<CartDTO> getCartList() {
        return cartList;
    }

    /**
     * カート内情報リストを格納するメソッド
     * @param cartList セットする cartList
     */
    public void setCartList(List<CartDTO> cartList) {
        this.cartList = cartList;
    }

    /**
     * セッションを取得するメソッド
     * @return session
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

    /**
     * シリアルIDを取得するメソッド
     * @return serialVersionUID　シリアルID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * カート内に入ってる合計商品数を取得するメソッド
     * @return quantities　カート内に入ってる合計商品数
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     * カート内に入ってる合計商品数を格納するメソッド
     * @param quantities セットする order
     */
    public void setQuantities(int quantities) {
        this. quantities= quantities;
    }



}
