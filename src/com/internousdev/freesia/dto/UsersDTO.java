package com.internousdev.freesia.dto;

/**
 * 顧客情報を格納するためのDTOクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/05
 * @version 1.0
 */
public class UsersDTO {

    /**
    * ユーザーID
    */
    private int userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * 姓(アルファベット)
     */
    private String familyName;

    /**
     * 名(アルファベット)
     */
    private String givenName;

    /**
     * 姓(漢字)
     */
    private String familyNameKanji;

    /**
     * 姓(ふりがな)
     */
    private String familyNameKana;

    /**
     * 名(漢字)
     */
    private String givenNameKanji;

    /**
     * 名(ふりがな)
     */
    private String givenNameKana;

    /**
     * 郵便番号
     */
    private String postal;

    /**
     * 住所
     */
    private String address;

    /**
     * 電話番号
     */
    private String phoneNumber;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * 携帯電話番号
     */
    private String mobileNumber;

    /**
     * 携帯メールアドレス
     */
    private String mobileEmail;

    /**
     * 性別
     */
    private String sex;

    /**
     * 生年月日
     */
    private String birthday;

    /**
     * 退会フラグ
     */
    private boolean userdelFlg;

    /**
     * ログインフラグ
     */
    private boolean loginFlg;

    /**
     * ユーザーフラグ
     */
    private int userFlg;

    /**
     * 受講年
     */
    private String year;

    /**
     * 受講月
     */
    private String month;

    /**
     * OauthID
     */
    private String oauthId;

    /**
     * Oauth名
     */
    private int oauthName;

    /**
     * Oauthアカウント
     */
    private String oauthAccount;

    /**
     * 登録日
     */
    private String registerDay;

    /**
     * 更新日
     */
    private String updateDay;

    /**
     * 購入日
     */
    private String purchasedAt;

    /**
     * 購入ID
     */
    private String purchaseId;

    /**
     * 合計金額
     */
    private String totalPrice;

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
     * パスワードを取得
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを格納
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 姓(アルファベット)を取得
     * @return 姓(アルファベット)
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 姓(アルファベット)を格納
     * @param familyName 姓(アルファベット)
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * 名(アルファベット)を取得
     * @return 名(アルファベット)
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 名(アルファベット)を格納
     * @param givenName 名(アルファベット)
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 姓(漢字)を取得
     * @return 姓(漢字)
     */
    public String getFamilyNameKanji() {
        return familyNameKanji;
    }

    /**
     * 姓(漢字)を格納
     * @param familyNameKanji 姓(漢字)
     */
    public void setFamilyNameKanji(String familyNameKanji) {
        this.familyNameKanji = familyNameKanji;
    }

    /**
     * 姓(ふりがな)を取得
     * @return 姓(ふりがな)
     */
    public String getFamilyNameKana() {
        return familyNameKana;
    }

    /**
     * 姓(ふりがな)を格納
     * @param familyNameKana 姓(ふりがな)
     */
    public void setFamilyNameKana(String familyNameKana) {
        this.familyNameKana = familyNameKana;
    }

    /**
     * 名(漢字)を取得
     * @return 名(漢字)
     */
    public String getGivenNameKanji() {
        return givenNameKanji;
    }

    /**
     * 名(漢字)を格納
     * @param givenNameKanji 名(漢字)
     */
    public void setGivenNameKanji(String givenNameKanji) {
        this.givenNameKanji = givenNameKanji;
    }

    /**
     * 名(ふりがな)を取得
     * @return 名(ふりがな)
     */
    public String getGivenNameKana() {
        return givenNameKana;
    }

    /**
     * 名(ふりがな)を格納
     * @param givenNameKana 名(ふりがな)
     */
    public void setGivenNameKana(String givenNameKana) {
        this.givenNameKana = givenNameKana;
    }

    /**
     * 郵便番号を取得
     * @return 郵便番号
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
     * @return 住所
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
     * 電話番号を取得
     * @return 電話番号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 電話番号を格納
     * @param phoneNumber 電話番号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * メールアドレスを取得
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを格納
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 携帯電話番号を取得
     * @return 携帯電話番号
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * 携帯電話番号を格納
     * @param mobileNumber 携帯電話番号
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * 携帯メールアドレスを取得
     * @return 携帯メールアドレス
     */
    public String getMobileEmail() {
        return mobileEmail;
    }

    /**
     * 携帯メールアドレスを格納
     * @param mobileEmail 携帯メールアドレス
     */
    public void setMobileEmail(String mobileEmail) {
        this.mobileEmail = mobileEmail;
    }

    /**
     * 性別を取得
     * @return 性別
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性別を格納
     * @param sex 性別
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 生年月日を取得
     * @return 生年月日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生年月日を格納
     * @param birthday 生年月日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 退会フラグを取得
     * @return 退会フラグ
     */
    public boolean isUserdelFlg() {
        return userdelFlg;
    }

    /**
     * 退会フラグを格納
     * @param userdelFlg 退会フラグ
     */
    public void setUserdelFlg(boolean userdelFlg) {
        this.userdelFlg = userdelFlg;
    }

    /**
     * ログインフラグを取得
     * @return ログインフラグ
     */
    public boolean isLoginFlg() {
        return loginFlg;
    }

    /**
     * ログインフラグを格納
     * @param loginFlg ログインフラグ
     */
    public void setLoginFlg(boolean loginFlg) {
        this.loginFlg = loginFlg;
    }

    /**
     * ユーザーフラグを取得
     * @return ユーザーフラグ
     */
    public int getUserFlg() {
        return userFlg;
    }

    /**
     * ユーザーフラグを格納
     * @param userFlg ユーザーフラグ
     */
    public void setUserFlg(int userFlg) {
        this.userFlg = userFlg;
    }

    /**
     * 受講年を取得
     * @return 受講年
     */
    public String getYear() {
        return year;
    }

    /**
     * 受講年を格納
     * @param year 受講年
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 受講月を取得
     * @return 受講月
     */
    public String getMonth() {
        return month;
    }

    /**
     * 受講月を格納
     * @param month 受講月
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * OauthIDを取得
     * @return OauthID
     */
    public String getOauthId() {
        return oauthId;
    }

    /**
     * OauthIDを格納
     * @param oauthId OauthID
     */
    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    /**
     * Oauth名を取得
     * @return Oauth名
     */
    public int getOauthName() {
        return oauthName;
    }

    /**
     * Oauth名を格納
     * @param oauthName Oauth名
     */
    public void setOauthName(int oauthName) {
        this.oauthName = oauthName;
    }

    /**
     * Oauthアカウントを取得
     * @return Oauthアカウント
     */
    public String getOauthAccount() {
        return oauthAccount;
    }

    /**
     * Oauthアカウントを格納
     * @param oauthAccount Oauthアカウント
     */
    public void setOauthAccount(String oauthAccount) {
        this.oauthAccount = oauthAccount;
    }

    /**
     * 登録日を取得
     * @return 登録日
     */
    public String getRegisterDay() {
        return registerDay;
    }

    /**
     * 登録日を格納
     * @param registerDay 登録日
     */
    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
    }

    /**
     * 更新日を取得
     * @return 更新日
     */
    public String getUpdateDay() {
        return updateDay;
    }

    /**
     * 更新日を格納
     * @param updateDay 更新日
     */
    public void setUpdateDay(String updateDay) {
        this.updateDay = updateDay;
    }

    /**
     * 購入日を取得
     * @return 購入日
     */
    public String getPurchasedAt() {
        return purchasedAt;
    }

    /**
     * 購入日を格納
     * @param purchasedAt 購入日
     */
    public void setPurchased_at(String purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    /**
     * 購入IDを取得
     * @return 商品ID
     */
    public String getPurchaseId() {
        return purchaseId;
    }

    /**
     * 購入IDを格納
     * @param purchaseId 購入ID
     */
    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * 合計金額を取得
     * @return 合計金額
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     *合計金額を格納
     * @param totalPrice 合計金額
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UsersDTO selectUserInfo(int creditBrand, String cardNumber) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
