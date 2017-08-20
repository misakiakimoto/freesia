package com.internousdev.sundia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.MyPageTestDAO;
import com.internousdev.sundia.dto.UsersDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ユーザーデータと購入履歴をmysqlから取ってきて表示するアクションクラス
 * @author MISAKI AKIMOTO
 * @since 2017/7/05
 */

public class MyPageTestAction extends ActionSupport implements SessionAware {

    /**
     * ユーザID
     */
    private int userId;

    /**
     * パスワード
     */

    private String password;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * ユーザー情報をいれるリスト
     */
    private ArrayList<UsersDTO> UserList = new ArrayList<UsersDTO>();

    /**
     *セッションからユーザーIDを取ってデータを取ってくるメソッド
     * @author MISAKI AKIMOTO
     *@return 取得できたらSUCCESS、取得できなければERROR
     */
    public String execute() throws Exception {

        if (session.get("userId") == null) {

            return ERROR;
        }
        userId = (int) session.get("userId");

        MyPageTestDAO dao = new MyPageTestDAO();
        UserList = dao.select(userId);

        if (UserList.size() == 0) {
            return ERROR;
        }
        return SUCCESS;

    }

    /**
     * ユーザリストを取得
     * @return UserList ユーザリスト
     */
    public ArrayList<UsersDTO> getUserList() {
        return UserList;
    }

    /**
     * ユーザリストを設定
     * @param UserList ユーザリスト
     */
    public void setUserList(ArrayList<UsersDTO> UserList) {
        this.UserList = UserList;
    }

    /**
     * ユーザIDを取得
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定
     * @param userId ユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * セッションを取得
     * @return session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを設定
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * パスワードを取得します。
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定します。
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;

    }
}
