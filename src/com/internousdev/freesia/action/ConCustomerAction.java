package com.internousdev.sundia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.ConCustomerDAO;
import com.internousdev.sundia.dto.ConCustomerDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理者用商品一覧画面に必要な情報を取得するためのクラス
 * @since 2017/07/16
 * @author YUITO YAMAMOTO
 * @version 1.0
 */

public class ConCustomerAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = -2457344252220177410L;

    /**
     * ユーザID
     */
    private int userId;

    /**
     * ユーザ名
     */
    private String userName = "";

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
     * セッション
     */
    private Map<String, Object> session;

    /**
     * ディスプレイリスト
     */
    public ArrayList<ConCustomerDTO> displayList = new ArrayList<ConCustomerDTO>();

    /**
     * 検索リスト
     */
    public ArrayList<ConCustomerDTO> searchList = new ArrayList<ConCustomerDTO>();


    /**
     * リスト生成
     * @author YUITO YAMAMOTO
     * @since 2017/07/11
     * @version 1.1
     */
    public String execute() {
        String result = SUCCESS;

        ArrayList<ConCustomerDTO> allList = new ArrayList<ConCustomerDTO>();
        ConCustomerDAO dao = new ConCustomerDAO();

        allList = dao.display(userName);

        session.put("userList", allList);

        return result;
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
     * @param userId セット ユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


    /**
     * ユーザー名を取得するメソッド
     * @return userName ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を格納するメソッド
     * @param userName セット ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * メールアドレスを取得するメソッド
     * @return  phoneEmail メールアドレス
     */
    public String getPhoneEmail() {
        return phoneEmail;
    }

    /**
     * メールアドレスを格納するメソッド
     * @param phoneEmail セット メールアドレス
     */
    public void setPhoneEmail(String phoneEmail) {
        this.phoneEmail = phoneEmail;
    }

    /**
     * 電話番号を取得するメソッド
     * @return phoneNumber 電話番号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 電話番号を格納するメソッド
     * @param phoneNumber セット 電話番号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 住所を取得するメソッド
     * @return address 住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住所を格納するメソッド
     * @param address セット 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * セッション情報を取得するメソッド。
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するメソッド。
     * @param session　セットする　セッションID
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
