package com.internousdev.freesia.dto;

/**
 * 購入履歴に関するDTO
 * @author MISAKI AKIMOTO
 * @version 1.0
 */

public class PurchaseDetailDTO {

    /**
     * 購入ID
     */
    private int purchaseId;

    /**
     * 購入番号
     */
    private int purchaseNo;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     *商品 ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * イメージパス
     */
    private String imagePath;

    /**
     * 金額
     */
    private float price;

    /**
     * 数量
     */
    private int quantities;

    /**
     * 価格計
     */
    private float multipliedPrice;

    /**
     * 購入日
     */
    private String purchasedAt;

    /**
     * 作成日
     */
    private String createdAt;

    /**
     * 更新日
     */
    private String updatedAt;

    /**
     * 購入IDを取得
     * @return purchaseId 購入ID
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * 購入IDを格納
     * @param purchaseId セットする purchaseId
     */
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * 購入NOを取得
     * @return purchaseNo 購入NO
     */
    public int getPurchaseNo() {
        return purchaseNo;
    }

    /**
     * 購入NOを格納
     * @param purchaseNo 購入NO
     */
    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    /**
     * ユーザーIDを取得
     * @return ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納
     * @param userId ユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 商品IDを取得
     * @return 商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 数量を取得
     * @return  数量
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     *  数量を格納
     * @param quantities  数量
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * 価格計を取得
     * @return multipliedPrice 価格計
     */
    public float getMultipliedPrice() {
        return multipliedPrice;
    }

    /**
     * 価格計を格納
     * @param multipliedPrice 価格計
     */
    public void setMultipliedPrice(float multipliedPrice) {
        this.multipliedPrice = multipliedPrice;
    }

    /**
     * 購入日を取得
     * @return purchasedAt 購入日
     */
    public String getPurchasedAt() {
        return purchasedAt;
    }

    /**
     * 購入日を格納
     * @param purchasedAt 購入日
     */
    public void setPurchasedAt(String purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    /**
     * 作成日を取得
     * @return 作成日
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 作成日を格納
     * @param createdAt 作成日
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 更新日を取得
     * @return 更新日
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 更新日を格納
     * @param updatedAt 更新日
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 商品名を取得
     * @return 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * イメージパスを取得
     * @return イメージパス
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * イメージパスを格納
     * @param imagePath イメージパス
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 金額を取得
     * @return 金額
     */
    public float getPrice() {
        return price;
    }

    /**
     * 金額を格納
     * @param price 金額
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
