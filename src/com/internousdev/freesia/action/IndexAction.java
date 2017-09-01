package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.ItemDisplayDAO;
import com.internousdev.freesia.dao.UserLevelDAO;
import com.internousdev.freesia.dto.ItemDisplayDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 購入履歴画面に必要な情報を取ってくるための Actionクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/16
 * @version 1.0
 */

public class IndexAction extends ActionSupport
        implements SessionAware, ServletResponseAware, ServletRequestAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1524555947613444860L;

    /**
     * セッション情報(ユーザーID)
     */
    private Map<String, Object> session;

    /**
     * response情報を格納するための変数
     */
    private HttpServletResponse response;

    /**
     * request情報
     */
    private HttpServletRequest request;

    /**
     * 商品表示用リスト
     */
    ArrayList<ItemDisplayDTO> itemList = new ArrayList<ItemDisplayDTO>();

    /**
     * CookieからSession情報を取得するメソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/16
     */
    public String execute() {
        String result = ERROR, resultItem = ERROR, resultCookie = ERROR;

        ItemDisplayDAO dao = new ItemDisplayDAO();
        itemList = dao.generateItemList();
        if (itemList.size() > 0) {
            session.put("itemList", itemList);
            session.put("itemLoad", true);
            resultItem = SUCCESS;
        }

        session.remove("userId");
        session.remove("loginFlg");
        session.remove("userLevel");

        if (session.get("userId") == null) {
            String val1 = null;
            String val2 = null;
            Cookie cookies[] = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("userId")) {
                    val1 = cookies[i].getValue();
                    session.put("userId", Integer.parseInt(val1));
                } else if (cookies[i].getName().equals("loginFlg")) {
                    val2 = cookies[i].getValue();
                    session.put("loginFlg", Boolean.valueOf(val2));
                }
            }
            if (val1 != null && val2 != null) {
                int id = Integer.parseInt(val1);
                UserLevelDAO levelDAO = new UserLevelDAO();
                session.put("userLevel", levelDAO.select(id));
            }
        }
        resultCookie = SUCCESS;

        if (resultItem == SUCCESS && resultCookie == SUCCESS) {
            result = SUCCESS;
        }

        return result;
    }

    /**
     * セッション情報を取得するメソッド
     * @return session　セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * レスポンス情報を取得するメソッド
     * @return response　レスポンス情報
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * レスポンス情報を格納するメソッド
     * @param response セットする response
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエスト情報を取得するメソッド
     * @return request　リクエスト情報
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * リクエスト情報を格納するメソッド
     * @param request セットする request
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

}
