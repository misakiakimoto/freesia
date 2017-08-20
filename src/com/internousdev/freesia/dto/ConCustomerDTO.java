package com.internousdev.sundia.dto;

/**
 * 管理者画面でお客様情報表示に関するDTOクラス
 * @author YUITO YAMAMOTO
 * @since 2017/08/01
 * @version 1.0
 */

public class ConCustomerDTO{

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * メールアドレス
     */
    private String phoneEmail;

    /**
     * 電話番号
     */
    private String phoneNumber;

    /**
     * 住所
     */
    private String address;


    /**
     * ユーザーIDを取得するメソッド
     * @return userId ユーザーID
     */
    public int getUserId(){
        return userId;
    }

    /**
     * ユーザーIDを格納するメソッド
     * @param userId セットする ユーザーID
     */
    public void setUserId(int userId){
        this.userId=userId;
    }

    /**
     * ユーザー名を取得するメソッド
     * @return userName ユーザー名
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ユーザー名を格納するメソッド
     * @param userName セットする ユーザー名
     */
    public void setUserName(String userName){
        this.userName=userName;
    }

    /**
     * メールアドレスを取得するメソッド
     * @return phoneEmail メールアドレス
     */
    public String getPhoneEmail(){
        return phoneEmail;
    }

    /**
     * メールアドレスを格納するメソッド
     * @param phoneEmail セットする メールアドレス
     */
    public void setPhoneEmail(String phoneEmail){
        this.phoneEmail = phoneEmail;
    }

    /**
     * 電話番号を取得するメソッド
     * @return phoneNumber 電話番号
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 電話番号を格納するメソッド
     * @param phoneNumber セットする 電話番号
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * 住所を取得するメソッド
     * @return address 住所
     */
    public String getAddress(){
        return address;
    }

    /**
     * 住所を格納するメソッド
     * @param  address セットする 住所
     */
    public void setAddress(String address){
        this.address = address;
    }
}