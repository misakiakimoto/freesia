package com.internousdev.sundia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.AdminPurchaseDetailDAO;
import com.internousdev.sundia.dto.PurchaseDetailDTO;
import com.internousdev.sundia.dto.PurchaseOutlineDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
* 販売履歴の詳細を表示するためのクラス
* @author RYO SASAKI
* @since 2017/07/16
* @version 1.0
*/
public class AdminPurchaseDetailAction extends ActionSupport implements SessionAware {

    /**
    * シリアルID
    */
    private static final long serialVersionUID = 2457344252220177410L;

    /**
    * 購入ID
    */
    private int adminPurchaseId = 0;

    /**
    * 購入情報DTO
    */
    private PurchaseOutlineDTO adminPurchaseOutlineData = new PurchaseOutlineDTO();

    /**
    * 購入履歴リスト
    */
    private ArrayList<PurchaseDetailDTO> adminPurchaseDetailList = new ArrayList<PurchaseDetailDTO>();

    /**
    * データ取得の成否
    */
    private boolean adminPurchaseDetailLoad = false;

    /**
    * セッション情報
    */
    private Map<String, Object> session;

    /**
     * 販売履歴の詳細を表示するための実行メソッド
     * @author RYO SASAKI
     * @since 2017/07/16
     * @return 成功ならSUCCESS それ以外はERROR
     */
    public String execute() {
        String result = ERROR;

        AdminPurchaseDetailDAO dao = new AdminPurchaseDetailDAO();

        adminPurchaseOutlineData = dao.getOutline(adminPurchaseId);
        adminPurchaseDetailList = dao.display(adminPurchaseId);

        if (adminPurchaseId != 0 && adminPurchaseOutlineData.getPurchaseId() == adminPurchaseId
                && adminPurchaseDetailList.size() > 0) {
            adminPurchaseDetailLoad = true;
            result = SUCCESS;

        }
        return result;
    }

    /**
     * 購入IDを取得
     * @return adminPurchaseId 購入ID
     */
    public int getAdminPurchaseId() {
        return adminPurchaseId;
    }

    /**
     * 購入IDを設定
     * @param adminPurchaseId 購入ID
     */
    public void setAdminPurchaseId(int adminPurchaseId) {
        this.adminPurchaseId = adminPurchaseId;
    }

    /**
     * 購入情報DTOを取得
     * @return adminPurchaseOutlineData 購入情報DTO
     */
    public PurchaseOutlineDTO getAdminPurchaseOutlineData() {
        return adminPurchaseOutlineData;
    }

    /**
     * 購入情報DTOを設定
     * @param adminPurchaseOutlineData 購入情報DTO
     */
    public void setAdminPurchaseOutlineData(PurchaseOutlineDTO adminPurchaseOutlineData) {
        this.adminPurchaseOutlineData = adminPurchaseOutlineData;
    }

    /**
     * 購入履歴リストを取得
     * @return adminPurchaseDetailList 購入履歴リスト
     */
    public ArrayList<PurchaseDetailDTO> getAdminPurchaseDetailList() {
        return adminPurchaseDetailList;
    }

    /**
     * 購入履歴リストを設定
     * @param adminPurchaseDetailList 購入履歴リスト
     */
    public void setAdminPurchaseDetailList(ArrayList<PurchaseDetailDTO> adminPurchaseDetailList) {
        this.adminPurchaseDetailList = adminPurchaseDetailList;
    }

    /**
     * 「データ取得の成否」を取得
     * @return adminPurchaseDetailLoad データ取得の成否
     */
    public boolean isAdminPurchaseDetailLoad() {
        return adminPurchaseDetailLoad;
    }

    /**
     * 「データ取得の成否」を取得
     * @param adminPurchaseDetailLoad データ取得の成否
     */
    public void setAdminPurchaseDetailLoad(boolean adminPurchaseDetailLoad) {
        this.adminPurchaseDetailLoad = adminPurchaseDetailLoad;
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
