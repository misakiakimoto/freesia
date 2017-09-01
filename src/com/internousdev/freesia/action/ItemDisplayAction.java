package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.ItemDisplayDAO;
import com.internousdev.freesia.dto.ItemDisplayDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TOP画面の商品一覧を表示するためのクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/16
 * @version 1.0
 */

public class ItemDisplayAction extends ActionSupport implements SessionAware {

    /**
     * セッション情報
     */
    Map<String, Object> session;

    /**
     * 商品名と画像パスのリスト
     * @author MISAKI AKIMOTO
     * @since 2017/08/16
     */
    ArrayList<ItemDisplayDTO> itemList = new ArrayList<ItemDisplayDTO>();

    public String execute() {
        String ret = ERROR;
        ItemDisplayDAO dao = new ItemDisplayDAO();
        itemList = dao.generateItemList();
        if (itemList.size() > 0) {
            session.put("itemList", itemList);
            session.put("itemLoad", true);
            ret = SUCCESS;
        }
        return ret;
    }

    /**
     * セッションを取得するメソッド
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するメソッド
     * @param session　セットする　セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 商品名と画像パスのリストを取得するメソッド
     * @return itemList
     */
    public ArrayList<ItemDisplayDTO> getItemList() {
        return itemList;
    }

    /**
     * 商品名と画像パスのリストを格納するメソッド
     * @param itemList　セットする　アイテムリスト
     */
    public void setItemList(ArrayList<ItemDisplayDTO> itemList) {
        this.itemList = itemList;
    }

}
