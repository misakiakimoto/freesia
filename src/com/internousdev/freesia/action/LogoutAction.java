package com.internousdev.sundia.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.util.login.LogoutDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウトするためのクラス
 * @author MISAKI AKIMOTO
 * @since 2017/08/17
 * @version 1.0
 */
public class LogoutAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 8755573724861558565L;
    /**
     * セッション情報（ユーザーID）
     */
    private Map<String, Object> session;
    /**
     * ログインフラグ
     */
    private boolean loginFlg;
    /**
     * ユーザーID
     */
    private int userId;
    /**
     * アクションフラグ
     */
    private String actionFlg;

    /**
     * response情報を格納するための変数
     */
    private HttpServletResponse response;

    /**
     * request情報
     */
    private HttpServletRequest request;

    /**
     * ログアウトするための実行メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/08/17
     * @return ログアウトできたならSUCCESS、できなければERROR
     */
    public String execute() {
        String result = ERROR;
        if (session.get("userId") != null) {
            LogoutDAO dao = new LogoutDAO();
            dao.update((int) session.get("userId"), false);
            session.clear();
            if (session.isEmpty()) {
                result = SUCCESS;
            }
        }

        //Cookieの削除
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("userId".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else if ("loginFlg".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else {
                cookie.setMaxAge(0);
            }
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
     * セッションを格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * ログインフラグを取得するメソッド
     * @return loginFlg　ログインフラグ
     */
    public boolean isLoginFlg() {
        return loginFlg;
    }

    /**
     * ログインフラグを格納するメソッド
     * @param loginFlg セットする loginFlg
     */
    public void setLoginFlg(boolean loginFlg) {
        this.loginFlg = loginFlg;
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

    /**
     * アクションフラグを取得するメソッド
     * @return actionFlg　アクションフラグ
     */
    public String getActionFlg() {
        return actionFlg;
    }

    /**
     * アクションフラグを格納するメソッド
     * @param actionFlg セットする actionFlg
     */
    public void setActionFlg(String actionFlg) {
        this.actionFlg = actionFlg;
    }

    /**
     * レスポンス情報を取得するためのメソッド
     * @return　response
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * レスポンス情報を格納するためのメソッド
     * @param response　レスポンス
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエスト情報を取得するためのメソッド
     * @return response レスポンス
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * リクエスト情報を格納するためのメソッド
     * @param request リクエストリスト
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    /**
     * レスポンス格納メソッド
     * @param response
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエスト格納メソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

}