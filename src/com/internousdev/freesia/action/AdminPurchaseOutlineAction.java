package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminPurchaseOutlineDAO;
import com.internousdev.freesia.dto.PurchaseOutlineDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 販売履歴を一覧表示するためのアクション
 * @author RYO SASAKI
 * @since 2017/08/17
 * @version 1.0
 */
public class AdminPurchaseOutlineAction extends ActionSupport implements SessionAware{

    /**
     * シリアルID
     */
    private static final long serialVersionUID = -2214583604316856363L;

    /**
     * ユーザーID
     */
    private int userId;

    /**
     * ユーザー名
     */
    private String userName="";

    /**
     * アドレス
     */
    private String address="";

    /**
     * 完了情報
     */
    private String isComplete="";

    /**
     * 表示するリスト
     */
    private ArrayList<PurchaseOutlineDTO> adminPurchaseOutlineList = new ArrayList<PurchaseOutlineDTO>();

    /**
     * ページ表示時のリスト読み込みの有無
     */
    private boolean adminPurchaseOutlineLoad=false;

    /**
     * セッション情報
     */
    private Map<String,Object> session;

    /**
     * 実行メソッド
     * @author RYO SASAKI
     * @since 2017/08/17
     * 1: リストの表示に必要な情報を取得する
     * 2: 取得が完了したとき、trueをでjspに表示を許可
     * 3: 成功したらSUCCESS,失敗したらERRORを返す
     */
    public String execute(){
        String result=ERROR;

        AdminPurchaseOutlineDAO dao =new AdminPurchaseOutlineDAO();
        adminPurchaseOutlineList=dao.display(userId,userName,address,isComplete);
        adminPurchaseOutlineLoad=true;

        //session.put("adminPurchaseOutlineList", adminPurchaseOutlineList);
        result = SUCCESS;

        return result;
    }

    /**
     * ユーザーIDを取得するためのメソッド
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するためのメソッド
     * @param userId セットするユーザーID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * ユーザー名を取得するためのメソッド
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を格納するためのメソッド
     * @param userName セットする ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 完了情報を取得するためのメソッド
     * @return IsComplete 完了情報
     */
    public String getIsComplete() {
        return isComplete;
    }

    /**
     * 完了情報を格納するためのメソッド
     * @param isComplete 完了情報
     */
    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * セッション情報を取得するためのメソッド
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するためのメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * リストの情報を取得するためのメソッド
     * @return adminPurchaseOutlineList
     */
    public ArrayList<PurchaseOutlineDTO> getAdminPurchaseOutlineList() {
        return adminPurchaseOutlineList;
    }

    /**
     * リストの情報を格納するためのメソッド
     * @param adminPurchaseOutlineList セットする
     */
    public void setAdminPurchaseOutlineList(ArrayList<PurchaseOutlineDTO> adminPurchaseOutlineList) {
        this.adminPurchaseOutlineList = adminPurchaseOutlineList;
    }

    /**
     * ページ出力の可否を取得するメソッド
     * @return adminPurchaseOutlineLoad ページ出力の可否
     */
    public boolean getAdminPurchaseOutlineLoad() {
        return adminPurchaseOutlineLoad;
    }

    /**
     * ページ出力の可否を格納するメソッド
     * @param adminPurchaseOutlineLoad ページ出力の可否
     */
    public void setAdminPurchaseOutlineLoad(boolean adminPurchaseOutlineLoad) {
        this.adminPurchaseOutlineLoad = adminPurchaseOutlineLoad;
    }

}
