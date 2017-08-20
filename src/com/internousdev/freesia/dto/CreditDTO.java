package com.internousdev.sundia.dto;

/**
 * CreditDTO クレジット情報を格納する為のクラス
 * @author TAKUMI MISAWA
 * @version 1.0
 */

public class CreditDTO {
    /**
     * ユーザーID
     */
    private int userId;

    /**
     * ログインID
     */
    private String loginId;

    /**
     * クレジットID
     */
    private int creditId;

    /**
     * カード番号
     */
    private String creditNumber;

    /**
     * カード名義
     */
    private String nameE;

    /**
     * セキュリティーコード
     */
    private int securityCode;

    /**
     * 有効期限(月）
     */
    private int expirationMonth;

    /**
     * 有効期限(年）
     */
    private int expirationYear;

    /**
     * クレジットタイプ
     */
    private String creditType;

    /**
     * 姓
     */
    private String lastName;

    /**
     * 名
     */
    private String firstName;

    /**
     * クレジット番号下4ケタ
     */
    private String creditNumber4;

    /**
     * 登録日
     */
    private String createdAt;

    /**
    * 更新日
     */
    private String updatedAt;

    //getter,setter

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId セットする loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return creditId
     */
    public int getCreditId() {
        return creditId;
    }

    /**
     * @param creditId セットする creditId
     */
    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    /**
     * @return creditNumber
     */
    public String getCreditNumber() {
        return creditNumber;
    }

    /**
     * @param creditNumber セットする creditNumber
     */
    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    /**
     * @return nameE
     */
    public String getNameE() {
        return nameE;
    }

    /**
     * @param nameE セットする nameE
     */
    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    /**
     * @return securityCode
     */
    public int getSecurityCode() {
        return securityCode;
    }

    /**
     * @param securityCode セットする securityCode
     */
    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * @return expirationMonth
     */
    public int getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * @param expirationMonth セットする expirationMonth
     */
    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * @return expirationYear
     */
    public int getExpirationYear() {
        return expirationYear;
    }

    /**
     * @param expirationYear セットする expirationYear
     */
    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * @return creditType
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * @param creditType セットする creditType
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName セットする lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName セットする firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return creditNumber4
     */
    public String getCreditNumber4() {
        return creditNumber4;
    }

    /**
     * @param creditNumber4 セットする creditNumber4
     */
    public void setCreditNumber4(String creditNumber4) {
        this.creditNumber4 = creditNumber4;
    }

    /**
     * @return createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt セットする createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt セットする updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
