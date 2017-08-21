package com.internousdev.freesia.dto;

/**
 * 管理者ページでのお問合わせに関するDTOクラス
 *@author MIKIO KAN
 *@since 2017/07/03
 *@version 1.0
 */

public class ConInquiryDTO {

    /**
     * ユーザID
     */
    private int userId;

    /**
     * アルファベット姓
     */
    private String familyName;

    /**
     * アルファベット名
     */
    private String givenName;

    /**
     * 名前
     */
    private String userName;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * 電話番号
     */
    private String userTellNumber;

    /**
     * 件名
     */
    private String title;
    /**
     * お問い合わせ
     */
    private String comment;

    /**
      * ユーザIDを取得
      * @return userId
      */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 姓(アルファベッド)を取得
     * @return familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 姓(アルファベッド)を設定
     * @param familyName セットする familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * 名(アルファベッド)を取得
     * @return givenName
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 名(アルファベット)を設定
     * @param givenName セットする givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 名前を取得する
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定
     * @param userName セットする userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * e-mailを取得
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * e-mailを設定
     * @param email セットする email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 電話番号を取得
     * @return userTellNumber
     */
    public String getUserTellNumber() {
        return userTellNumber;
    }

    /**
     * 電話番号を設定
     * @param userTellNumber セットする userTellNumber
     */
    public void setUserTellNumber(String userTellNumber) {
        this.userTellNumber = userTellNumber;
    }

    /**
     * タイトルを取得
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定
     * @param title セットする title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * お問い合わせを取得
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * お問い合わせを設定
     * @param comment セットする comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}