package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminItemSearchDAO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理者画面で商品を検索するためのアクションクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/16
 * @version 1.0
 */
public class AdminItemSearchAction extends ActionSupport implements SessionAware {

    /**
    * セッション情報
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
    * リザルト
    */
    private String result;

    /**
    * 削除フラグ確認
    */
    private String chk_isDeleted;

    /**
    * カテゴリーID確認
    */
    private int chk_categoryId;

    /**
    * 商品名確認
    */
    private String chk_itemName;

    /**
    * 特定条件で商品を検索し表示する実行メソッド
    * @author MISAKI AKIMOTO
    * @since 2017/07/16
    * @version 1.0
    * @return 成功ならSUCCESS それ以外はERROR
    */
    public String execute() throws Exception {
        result = ERROR;



        AdminItemSearchDAO dao = new AdminItemSearchDAO();
        adminItemList = dao.generateItemList(chk_isDeleted, chk_categoryId, chk_itemName);

        result = SUCCESS;
        session.put("adminItemList", adminItemList);

        return result;
    }

    /**
     *セッション情報を取得
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
     *削除フラグ確認を取得
     * @return chk_isDeleted 削除フラグ確認
     */
    public String getChk_isDeleted() {
        return chk_isDeleted;
    }

    /**
     * 削除フラグ確認を設定
     * @param chk_isDeleted 削除フラグ確認
     */
    public void setChk_isDeleted(String chk_isDeleted) {
        this.chk_isDeleted = chk_isDeleted;
    }

    /**
     *カテゴリーID確認を取得
     * @return chk_categoryId カテゴリーID確認
     */
    public int getChk_categoryId() {
        return chk_categoryId;
    }

    /**
     * カテゴリーID確認を設定
     * @param chk_categoryId カテゴリーID確認
     */
    public void setChk_categoryId(int chk_categoryId) {
        this.chk_categoryId = chk_categoryId;
    }

    /**
     * 商品名確認を取得
     * @return chk_itemName 商品名確認
     */
    public String getChk_itemName() {
        return chk_itemName;
    }

    /**
     * 商品名確認を設定
     * @param chk_itemName 商品名確認
     */
    public void setChk_itemName(String chk_itemName) {
        this.chk_itemName = chk_itemName;
    }
}
