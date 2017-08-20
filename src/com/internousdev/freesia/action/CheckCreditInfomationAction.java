package com.internousdev.sundia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.util.creditcard.manager.CreditUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * クレジットカードの種類を判別し情報が正しいかチェックするクラス
 * @author MISAKI AKIMOTO
 * @since 2017/8/8
 * @version 1.0
 */

public class CheckCreditInfomationAction extends ActionSupport implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1160348426724511849L;

    /**
     * クレジット種類
     */
    private int creditId;

    /**
     * クレジット番号
     */
    private String creditNumber;

    /**
     * クレジット名義
     */
    private String nameE;

    /**
     * セキュリティコード
     */
    private String securityCode;

    /**
     * 有効期限（月）
     */
    private int expirationMonth;

    /**
     * 有効期限（年）
     */
    private int expirationYear;

    /**
     * セッション情報
     */
    private Map<String, Object> session;

    /**
     * エラーメッセージ
     */
    private String errmsg2;

    /**
     * クレジットブランド
     */
    private String creditBrand;

    /**
     * 実行メソッド クレジットの種類を判別
     * @author MISAKI AKIMOTO
     * @since 2017/08/08
     * @version 1.0
     * @return ERROR SUCCESS
     */
    public String execute() {
        if (creditNumber.startsWith("4")) {
            creditId = 1;

        } else if (creditNumber.startsWith("5")) {
            creditId = 2;

        } else if (creditNumber.startsWith("3")) {
            creditId = 3;

        } else {
            errmsg2 = "*入力された情報に間違いがあります。";

            return ERROR;
        }

        if (creditId == 1) {
            creditBrand = "Visa";

        } else if (creditId == 2) {
            creditBrand = "MasterCard";

        } else if (creditId == 3) {
            creditBrand = "AmericanExpress";
        }

        CreditUtil util = new CreditUtil(creditId, creditNumber);

        if (util.brandCheck()) {
            if (util.creditCheck(securityCode, expirationYear, expirationMonth, nameE)) {
                return SUCCESS;

            } else {
                errmsg2 = "*入力された情報に間違いがあります。";

                return ERROR;
            }

        } else {
            errmsg2 = "*入力された情報に間違いがあります。";

            return ERROR;
        }
    }

    /**
     * エラーメッセージ取得メソッド
     * @return mrrmsg2 エラーメッセージ
     */
    public String getErrmsg2() {
        return errmsg2;
    }

    /**
     * エラーメッセージ格納メソッド
     * @param errmsg2 セット errmsg2
     */
    public void setErrmsg2(String errmsg2) {
        this.errmsg2 = errmsg2;
    }

    /**
     * クレジット種類取得メソッド
     * @return creditId クレジット種類
     */
    public int getCreditId() {
        return creditId;
    }

    /**
     * クレジット種類格納メソッド
     * @param creditId セット creditId
     */
    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    /**
     * クレジット番号取得メソッド
     * @return creditNumber クレジット番号
     */
    public String getCreditNumber() {
        return creditNumber;
    }

    /**
     * クレジット番号格納メソッド
     * @param creditNumber セット creditNumber
     */
    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    /**
     * クレジット名義取得メソッド
     * @return nameE クレジット名義
     */
    public String getNameE() {
        return nameE;
    }

    /**
     * クレジット名義格納メソッド
     * @param nameE セット nameE
     */
    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    /**
     * セキュリティコード取得メソッド
     * @return securityCode セキュリティコード
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * セキュリティコード格納メソッド
     * @param securityCode セット securityCode
     */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * 有効期限（月）取得メソッド
     * @return expirationMonth 有効期限（月）
     */
    public int getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * 有効期限（月）格納メソッド
     * @param expirationMonth セット expirationMonth
     */
    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * 有効期限（年）取得メソッド
     * @return expirationYear 有効期限（年）
     */
    public int getExpirationYear() {
        return expirationYear;
    }

    /**
     * 有効期限（年）格納メソッド
     * @param expirationYear セット expirationYear
     */
    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * セッション情報取得メソッド
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報格納メソッド
     * @param session セット session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * クレジットブランド取得メソッド
     * @return creditBrand クレジットブランド
     */
    public String getCreditBrand() {
        return creditBrand;
    }

    /**
     * クレジットブランド格納
     * @param creditBrand セット creditBrand
     */
    public void setCreditBrand(String creditBrand) {
        this.creditBrand = creditBrand;
    }

}