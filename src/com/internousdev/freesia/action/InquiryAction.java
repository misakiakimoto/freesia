/**
 *
 */
package com.internousdev.sundia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.InquiryDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 問い合わせフォームの情報をDAOに送るクラス
 * @author SHUSAKU YONEYAMA
 * @since 2017/08/16
 * @version 1.0
 */

public class InquiryAction extends ActionSupport implements SessionAware {

    /**
     * シリアルキー
     */
    private static final long serialVersionUID = 1L;

    /**
     * 問い合わせ者名
     */
    private String userName;

    /**
     * アドレス
     */
    private String userAddress;

    /**
     * 電話番号
     */
    private String userTellNumber;

    /**
     * 件名
     */
    private String title;

    /**
     * 本文
     */
    private String comment;

    /**
     * ログイン情報
     */
    private boolean login;

    /**
     * セッション情報
     */
    private Map<String, Object> session;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * 実行メソッド
     * 処理順
     * 1: セッションIDを持っているかどうかの判断
     * 2: セッションIDの有無によってDAOに送る情報を変える
     * 3: countに格納しその数によってEORRERかSUCCESSか判断
     * @author SHUSAKU YONEYAMA
     * @return InquiryDAO
     */

    public String execute() {

        String result = ERROR;
        InquiryDAO dao = new InquiryDAO();
        int count = 0;

        if (session.get("userId") != null) {
            userId = (int) session.get("userId");
        }

        if (userAddress.equals("")) {
            count = dao.insertDAO(userName, userTellNumber, title, comment, login, userId);
        } else {
            count = dao.insertDAO(userName, userAddress, userTellNumber, title, comment, login);
        }
        if (count > 0) {
            result = SUCCESS;
        }
        return result;
    }

    /**
     * ユーザ名を取得するメソッド
     * @return　userName　ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を格納するメソッド
     * @param　userName　セットする　userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * アドレスを取得するメソッド
     * @return　userAddress　アドレス
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * アドレスを格納するメソッド
     * @param　userAddress　セットする　アドレス
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 電話番号を取得するメソッド
     * @return　　userTellNumber 電話番号
     */
    public String getUserTellNumber() {
        return userTellNumber;
    }

    /**
     * 電話番号を格納するメソッド
     * @param userTellNumber　セットする　電話番号
     */
    public void setUserTellNumber(String userTellNumber) {
        this.userTellNumber = userTellNumber;
    }

    /**
     * 件名を取得するメソッド
     * @return　　title 件名
     */
    public String getTitle() {
        return title;
    }

    /**
     * 件名を格納するメソッド
     * @param title　セットする　件名
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 本文を取得するメソッド
     * @return　comment　本文
     */
    public String getComment() {
        return comment;
    }

    /**
     * 本文を格納するメソッド
     * @param comment　セットする　本文
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * ログインフラグを取得するメソッド
     * @return　login ログインフラグ
     */
    public boolean getLogin() {
        return login;
    }

    /**
     * ログインフラグを格納するメソッド
     * @param login　セットする　ログインフラグ
     */
    public void setLogin(boolean login) {
        this.login = login;
    }

    /**
     * セッションIDを取得するメソッド
     * @return　session セッションID
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションIDを格納するメソッド
     * @param　session セットする　セッションID
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
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
     * @param userId　セットする　ユーザーID
     */
    public void setUser_int(int userId) {
        this.userId = userId;
    }

}