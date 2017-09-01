package com.internousdev.freesia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminItemEditDAO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *管理者が商品編集画面に移動するためのクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/16
 * @version 1.0
 */
public class AdminItemEditAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private static final long serialVersionUID = -2457344252220177410L;

    /**
    *商品用DTO
    */
    private ItemDTO dto;

    /**
    * リザルト
    */
    private String result;

    /**
    * 商品ID
    */
    private int id;

    /**
     * *管理者が商品編集画面に移動するためのメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/16
     * @version 1.0
     * @return 成功ならSUUCCESS それ以外はERROR
     */
    public String execute() throws Exception {
        result = ERROR;

        AdminItemEditDAO dao = new AdminItemEditDAO();
        dto = dao.getItemData(id);

        session.put("adminEditItemId", id);
        session.put("adminEditItemData", dto);

        result = SUCCESS;

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
     * 商品用DTO
     * @return dto 商品用DTO
     */
    public ItemDTO getDto() {
        return dto;
    }

    /**
     * 商品用DTO
     * @param dto 商品用DTO
     */
    public void setDto(ItemDTO dto) {
        this.dto = dto;
    }
}
