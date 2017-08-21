package com.internousdev.freesia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminItemSwitchDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
*管理者が商品の削除フラグを編集するためのクラス
* @author JUNYA TAKENO
* @since 2017/07/16
* @version 1.0
*/
public class AdminItemSwitchAction extends ActionSupport implements SessionAware {

    /**
     * セッション情報
     */
    private Map<String, Object> session;

    /**
     * シリアルID
     */
    private static final long serialVersionUID = -2457344252220177410L;

    /**
     * リザルト
     */
    private String result;

    /**
     * 商品ID
     */
    private int id;

    /**
     * 削除フラグ
     */
    private boolean flg;

    /**
     * 削除フラグを切り替える実行メソッド
     * author JUNYA TAKENO
     * @since 2017/07/16
     * @return 成功ならSUCCESS それ以外ならERROR
     */
    public String execute() throws Exception {
        result = ERROR;

        AdminItemSwitchDAO dao = new AdminItemSwitchDAO();


        result = dao.switchDeleted(id, flg);
        session.put("adminItemLoad", false);

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
     * 商品IDを取得
     * @return id 商品ID
     */
    public int getId() {
        return id;
    }

    /**
     * 商品IDを設定
     * @param id 商品ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 削除フラグを取得
     * @return flg 削除フラグ
     */
    public boolean isFlg() {
        return flg;
    }

    /**
     * 削除フラグを設定
     * @param flg 削除フラグ
     */
    public void setFlg(boolean flg) {
        this.flg = flg;
    }
}
