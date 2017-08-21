package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.HistoryDAO;
import com.internousdev.freesia.dto.PurchaseDetailDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入履歴画面に必要な情報を取ってくるための Actionクラス
 * @author RYOTA SHISHIKURA
 * @since 2017/08/16
 * @version 1.0
 */

public class HistoryAction extends ActionSupport implements SessionAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1524555947613444860L;
    /**
     * ユーザーID
     */
    private int userId;
    /**
     * セッション情報
     */
    private Map<String, Object> session;
    /**
     * 購入履歴リスト
     */
    private ArrayList<PurchaseDetailDTO> purList = new ArrayList<PurchaseDetailDTO>();

    public String execute() throws Exception {
        String result = ERROR;

        if (session.get("userId") != null) {
            userId = (int) session.get("userId");

            HistoryDAO Hisdao = new HistoryDAO();
            purList = Hisdao.select(userId);

            if (purList.size() > 0) {
                result = SUCCESS;
            }
        }
        return result;
    }

    /**
     * セッションを取得するメソッド
     * @return session　セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 購入履歴リストを取得するメソッド
     * @return purList　購入履歴リスト
     */
    public ArrayList<PurchaseDetailDTO> getPurList() {
        return purList;
    }

    /**
     * 購入履歴リストを格納するメソッド
     * @param purList セットする purList
     */
    public void setPurList(ArrayList<PurchaseDetailDTO> purList) {
        this.purList = purList;
    }

    /**
     * ユーザーIDを取得するメソッド
     * @return userId　ユーザーID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するメソッド
     * @param userId セットする userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
