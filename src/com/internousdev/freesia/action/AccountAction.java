package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AccountDAO;
import com.internousdev.freesia.dto.UsersDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
* ユーザーがアカウント詳細画面でアカウント情報を取得するためのクラス
*@author MISAKI AKIMOTO
*@version 1.0
*/

public class AccountAction extends ActionSupport implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 8531245739641223373L;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * セッション情報
     */
    private Map<String, Object> session;

    /**
     * ユーザーリスト
     */
    private ArrayList<UsersDTO> userList = new ArrayList<UsersDTO>();

    /**
     * アカウント情報を表示するための実行メソッド
     * @return 成功ならSUCCESS
     */
    public String execute() throws Exception {
        String result = ERROR;

        if (session.get("userId") != null) {
            userId = (int) session.get("userId");

            AccountDAO Acdao = new AccountDAO();
            userList = Acdao.select(userId);

            //UsersDTO dto = new UsersDTO();
            //String email = dto.getEmail();

            if (userList.size() > 0) {
                result = SUCCESS;
            }

        }
        return result;
    }

    /**
     * ユーザーリストを取得
     * @return userList ユーザーリスト
     */
    public ArrayList<UsersDTO> getUserList() {
        return userList;
    }

    /**
     * ユーザーリストを設定
     * @param userList ユーザーリスト
     */
    public void setUserList(ArrayList<UsersDTO> userList) {
        this.userList = userList;
    }

    /**
     * ユーザーIDを取得
     * @return userId ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを設定
     * @param userId ユーザーID
     */
    public void setUserID(int userId) {
        this.userId = userId;
    }

    /**
     * セッション情報を取得
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を設定
     * @param session セッション情報
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
