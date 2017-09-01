package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminItemDisplayDAO;
import com.internousdev.freesia.dto.CategoryDTO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理者用商品一覧画面に必要な情報を取得するためのクラス
 * @since 2017/07/16
 * @author MISAKI AKIMOTO
 * @version 1.0
 */
public class AdminItemDisplayAction extends ActionSupport implements SessionAware {

    /**
    * セッション
    */
    private Map<String, Object> session;

    /**
    * シリアルID
    */
    private static final long serialVersionUID = -2457344252220177410L;

    /**
    * 商品リスト
    */
    private ArrayList<ItemDTO> adminItemList = new ArrayList<ItemDTO>();

    /**
    * カテゴリーリスト
    */
    private ArrayList<CategoryDTO> adminCategoryList = new ArrayList<CategoryDTO>();

    /**
    * リザルト
    */
    private String result;

    /**
    * 商品一覧情報を取得する実行メソッド
    * @return 成功ならSUCCESS それ以外はERROR
    * @author MISAKI AKIMOTO
    * @version 1.0
    */
    public String execute() throws Exception {
        result = ERROR;

        AdminItemDisplayDAO dao = new AdminItemDisplayDAO();
        adminItemList = dao.generateItemList();
        adminCategoryList = dao.generateCategoryList();

        for (int i = 0; i < adminCategoryList.size(); i++) {

        }

        if (adminItemList.size() > 0) {
            result = SUCCESS;
            session.put("adminItemLoad", true);
            session.put("adminItemList", adminItemList);
            session.put("adminCategoryList", adminCategoryList);
        }

        return result;
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

    /**
     * 商品リストを取得
     * @return adminItemList 商品リスト
     */
    public ArrayList<ItemDTO> getAdminItemList() {
        return adminItemList;
    }

    /**
     * 商品リストを設定
     * @param adminItemList 商品リスト
     */
    public void setAdminItemList(ArrayList<ItemDTO> adminItemList) {
        this.adminItemList = adminItemList;
    }

    /**
     * カテゴリーリストを取得
     * @return adminCategoryList カテゴリーリスト
     */
    public ArrayList<CategoryDTO> getAdminCategoryList() {
        return adminCategoryList;
    }

    /**
     * カテゴリーリストを設定
     * @param adminCategoryList カテゴリーリスト
     */
    public void setAdminCategoryList(ArrayList<CategoryDTO> adminCategoryList) {
        this.adminCategoryList = adminCategoryList;
    }
}
