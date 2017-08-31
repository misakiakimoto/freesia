package com.internousdev.freesia.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AddToCartDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
* カートに商品を追加するアクションクラス
* @author MISAKI AKIMOTO
* @since 2017/08/07
* @version 1.0
*/

public class AddToCartAction extends ActionSupport implements SessionAware {
    /**
    * シリアルID
    */
    private static final long serialVersionUID = -616455276103431676L;
    /**
    * カートID
    */
    private int cartId;
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

    private int stocks;

    /**
    * 合計金額
    */
    private int amountAll;

    /**
    * カートへ商品追加処理をした件数
    */
    private int addCount;
    /**
    * カート情報
    */
    private ArrayList<CartDTO> cartList;
    /**
    * 商品情報
    */
    private ArrayList<ItemDTO> itemStatus;
    /**
    * セッション情報
    */
    private Map<String, Object> session;

    private String imagepath;

    /**
    * カートに商品を追加する実行メソッド
    * @author MISAKI AKIMOTO
    * @since 2017/08/07
    * @version 1.0
    */

    /**
    * 実行メソッド 処理内容と順番 1：セッション情報を持っているか判断 2：購入数が在庫数を超えていないか判断
    * 3：遷移元のitemId,itemName,price,quantity,imgPathとsession内のuserIdを使用し、
    * カートへ指定商品を登録 4：カートへ登録された情報を取得 5：カート内の情報を元に購入商品の合計金額金額を算出
    */
    public String execute() throws SQLException {

        String result = ERROR;

         if (session.containsKey("userId")) {
            userId = (int) session.get("userId");
            AddToCartDAO dao = new AddToCartDAO();
            itemStatus = dao.itemStatus(itemId);


            if(dao.addToCart(userId, itemId, quantities)){
                return result;
            }
            cartList = dao.selected(userId);
            if (cartList.size() > 0) {
                for (int i = 0; i < cartList.size(); i++) {
                    amountAll += (cartList.get(i).getPrice()) * (cartList.get(i).getQuantities());
                }
                result = SUCCESS;
            }
         }
        return result;
    }

    /**
    * カートID取得メソッド
    * @author MISAKI AKIMOTO
    * @return cartId カートID
    */
    public int getCartId() {
        return cartId;
    }

    /**
     * カートID格納メソッド
     * @author MISAKI AKIMOTO
     * @param cartId セットする cartID
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
    * ユーザーID取得メソッド
    *
    * @author MISAKI AKIMOTO
    * @return userId ユーザーID
    */
    public int getUserId() {
        return userId;
    }

    /**
    * ユーザーID格納メソッド
    *
    * @author MISAKI AKIMOTO
    * @param userId セットする userId
    *
    */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 商品ID取得メソッド
     *
     * @author MISAKI AKIMOTO
     * @return itemId 商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品ID格納メソッド
     *
     * @author MISAKI AKIMOTO
     * @param itemId セットする itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名取得メソッド
     *
     * @author MISAKI AKIMOTO
     * @return itemName 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名格納メソッド
     *
     * @author MISAKI AKIMOTO
     * @param itemName　セットする itemsName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 単価取得メソッド
     *
     * @author MISAKI AKIMOTO
     * @return price 価格
     */
    public float getPrice() {
        return price;
    }

    /**
     * 単価格納メソッド
     *
     * @author MISAKI AKIMOTO
     * @param price セットする price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 数量取得メソッド
     *
     * @author MISAKI AKIMOTO
     * @return quantities 購入数
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     * 数量格納メソッド
     *
     * @author MISAKI AKIMOTO
     * @param quantities
     *            購入数
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * 合計金額取得メソッド
     *
     * @author MISAKI AKIMOTO
     * @return amountAll 合計金額
     */
    public int getAmountAll() {
        return amountAll;
    }

    /**
     * 合計金額格納メソッド
     *
     * @author MISAKI AKIMOTO
     * @param amountAll セットする amountAll
     */
    public void setAmountAll(int amountAll) {
        this.amountAll = amountAll;
    }

    /**
     * カートへ商品追加処理をした件数を取得するメソッド
     * @author MISAKI AKIMOTO
     * @return addCount カートへ商品追加処理をした件数
     */
    public int getAddCount() {
        return addCount;
    }

    /**
     * カートへ商品追加処理をした件数を格納するメソッド
     *
     * @author MISAKI AKIMOTO
     * @param addCount セットする addCount
     */
    public void setAddcount(int addCount) {
        this.addCount = addCount;
    }

    /**
     * カート情報を取得するメソッド
     *
     * @author MISAKI AKIMOTO
     * @return cartList カート情報
     */
    public ArrayList<CartDTO> getCartList() {
        return cartList;
    }

    /**
     * カート情報を格納するメソッド
     *
     * @author MISAKI AKIMOTO
     * @param cartList セットする cartList
     */
    public void setCartList(ArrayList<CartDTO> cartList) {
        this.cartList = cartList;
    }

    /**
     * 商品情報を取得するメソッド
     * @author MISAKI AKIMOTO
     * @return itemStatus 商品情報
     */
    public ArrayList<ItemDTO> getItemStatus() {
        return itemStatus;
    }

    /**
     * 商品情報を格納するメソッド
     * @author MISAKI AKIMOTO
     * @param itemStatus セットする itemStatus
     */
    public void setItemStatus(ArrayList<ItemDTO> itemStatus) {
        this.itemStatus = itemStatus;
    }

    /**
     * セッション操作用情報を取得するメソッド
     * @author MISAKI AKIMOTO
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するメソッド
     *
     * @author MISAKI AKIMOTO
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * @return stocks
     */
    public int getStocks() {
        return stocks;
    }

    /**
     * @param stocks セットする stocks
     */
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    /**
     * @return imagepath
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * @param imagepath セットする imagepath
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
