package com.internousdev.freesia.dto;

/**
 * カート情報に関するDTOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/07
 * @version 1.0
 */
public class CartDTO {

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

    /**
     * イメージパス
     */
    private String imgPath;

    /**
     * 小計
     */
    private float subtotal;

    /**
     * カート内商品IDを取得するメソッド
     * @return cartId カート内商品ID
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
     * @return itemId 商品ID
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
     * @return itemsName 商品名
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
     * 単価を取得するメソッド
     * @return price 単価
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
     * イメージファイルパスを取得するメソッド
     * @return imgPath イメージファイルパス
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * イメージファイルパスを格納するメソッド
     * @param imgPath セットする imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * 小計を取得するメソッド
     * @return subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * 小計を格納するメソッド
     * @param subtotal セットする subtotal
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

}