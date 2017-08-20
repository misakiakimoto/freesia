
package com.internousdev.sundia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.GoCartDAO;
import com.internousdev.sundia.dao.PurchaseCompleteDAO;
import com.internousdev.sundia.dto.CartDTO;
import com.internousdev.sundia.dto.CreditDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 決済をするクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/08/14
 * @version 1.0
 */
public class PurchaseCompleteAction extends ActionSupport implements SessionAware {

    /**
     * シリアルID
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private static final long serialVersionUID = 3692422332609482760L;

    /**
     * ユーザー（お客様）ID
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private int userId;
    /**
     * セッション情報
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private Map<String, Object> session;
    /**
     * カード番号
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private String creditNumber;
    /**
     * カード会社
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private int creditId;
    /**
     * 合計金額
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private float amountAll;
    /**
     * 商品名
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private String itemName;

    /**
     * カート、クレジットのリスト
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
    private ArrayList<CreditDTO> creditList = new ArrayList<CreditDTO>();

    /**
     * 決済をするための実行メソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/08/14
     * @version 1.0
     */
    public String execute() {

        String result = LOGIN;

        userId=0;
        if (session.containsKey("userId")) {
            userId = (int)session.get("userId");


            PurchaseCompleteDAO dao = new PurchaseCompleteDAO();
            GoCartDAO dao3 = new GoCartDAO();

            cartList = dao3.selectedItem(userId);

            float totalPrice=0;
            for(int i=0;i<cartList.size();i++){
                totalPrice += cartList.get(i).getSubtotal();
            }


            if (dao.stockCheck(cartList)=="OK") {
                dao.purchase(userId,totalPrice,cartList);
                dao.stockUpdate(userId);
                dao.salesUpdate(userId);
                dao.clean(userId);
                for (int i = 0; i < cartList.size(); i++) {
                    amountAll += (cartList.get(i).getPrice()) * (cartList.get(i).getQuantities());
                }
                result = SUCCESS;
            }else if(dao.stockCheck(cartList)=="NG"){
            }else{
                itemName = dao.stockCheck(cartList);
                result = ERROR;
            }
        }
        return result;
    }


    /**
     * ユーザー（お客様）IDを取得するメソッド
     * @return userId　ユーザー（お客様）ID
     */
    public int getUserId() {
        return userId;
    }


    /**
     * ユーザー（お客様）IDを格納するメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


    /**
     * セッション情報を取得するメソッド
     * @return session　セッション情報
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
     * カード番号を取得するメソッド
     * @return creditNumber　クレジット番号
     */
    public String getCreditNumber() {
        return creditNumber;
    }


    /**
     * カード番号を格納するメソッド
     * @param creditNumber セットする creditNumber
     */
    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }


    /**
     * カード会社を取得するメソッド
     * @return creditId　カード会社
     */
    public int getCreditId() {
        return creditId;
    }


    /**
     * カード会社を格納するメソッド
     * @param creditId セットする creditId
     */
    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }


    /**
     * カートリストを取得するメソッド
     * @return cartList　カートリスト
     */
    public ArrayList<CartDTO> getCartList() {
        return cartList;
    }


    /**
     * カートリストを格納するメソッド
     * @param cartList セットする cartList
     */
    public void setCartList(ArrayList<CartDTO> cartList) {
        this.cartList = cartList;
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
     * クレジットリストを取得するメソッド
     * @return creditList　クレジットリスト
     */
    public ArrayList<CreditDTO> getCreditList() {
        return creditList;
    }


    /**
     * クレジットリストを格納するメソッド
     * @param creditList セットする creditList
     */
    public void setCreditList(ArrayList<CreditDTO> creditList) {
        this.creditList = creditList;
    }

}