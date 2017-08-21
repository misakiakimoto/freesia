package com.internousdev.freesia.dto;

/**
 *購入情報に関するDTO
 * @author JUNNYA TAKENO
 * @version 1.0
 */
public class PurchaseOutlineDTO {

    /**
     * 購入ID
     */
    private int purchaseId;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * 価格計
     */
    private float totalPrice;

    /**
     * 購入日時
     */
    private String purchasedAt;

    /**
     * 郵便番号
     */
    private String postal;

    /**
     * 住所
     */
    private String address;

    /**
     * 決済方法番号
     */
    private int paymentMethodNumber;

    /**
     * 決済方法表示
     */
    private String paymentMethodDisplay;

    /**
     * 完了
     */
    private boolean isComplete;

    /**
     * 購入IDを取得
     * @return ユーザーID
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * 購入IDを格納
     * @param purchaseId ユーザーID
     */
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
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
     * ユーザー名を取得
     * @return userName ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を格納
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 価格計を取得
     * @return totalPrice 価格計
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * 価格計を格納
     * @param totalPrice 価格計
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 購入日時を取得
     * @return purchasedAt 購入日時
     */
    public String getPurchasedAt() {
        return purchasedAt;
    }

    /**
     * 購入日時を格納
     * @param purchasedAt ユーザーID
     */
    public void setPurchasedAt(String purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    /**
     * 郵便番号を取得
     * @return postal 郵便番号
     */
    public String getPostal() {
        return postal;
    }

    /**
     * 郵便番号を格納
     * @param postal 郵便番号
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     * 住所を取得
     * @return address 住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住所を格納
     * @param address 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 決済方法番号を取得
     * @return paymentMethodNumber 決済方法番号
     */
    public int getPaymentMethodNumber() {
        return paymentMethodNumber;
    }

    /**
     * 決済方法番号を格納
     * @param paymentMethodNumber 決済方法表示
     */
    public void setPaymentMethodNumber(int paymentMethodNumber) {
        this.paymentMethodNumber = paymentMethodNumber;
    }

    /**
     * 決済方法表示を取得
     * @return paymentMethodDisplay 決済方法表示
     */
    public String getPaymentMethodDisplay() {
        return paymentMethodDisplay;
    }

    /**
     * 決済方法表示を格納
     * @param paymentMethodDisplay 決済方法表示
     */
    public void setPaymentMethodDisplay(String paymentMethodDisplay) {
        this.paymentMethodDisplay = paymentMethodDisplay;
    }

    /**
     * 完了を取得
     * @return isComplete 完了
     */
    public boolean GetIsComplete() {
        return isComplete;
    }

    /**
     * 完了を格納
     * @param isComplete 完了
     */
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
