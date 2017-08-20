package com.internousdev.sundia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.util.oauth.google.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Googleでログインする為のクラス
 * @author MISAKI AKIMOTO
 * @since 2017/7/22
 * @version 1.0
 */
public class GoGoogleAction extends ActionSupport implements ServletResponseAware, ServletRequestAware, SessionAware {

    /**
     * クライアントID
     */
    private static final String API_KEY = "791228835778-g0i1lakt69jvrdarohv1f82gtde8odg2.apps.googleusercontent.com";

    /**
     * クライアントシークレット
     */
    private static final String API_SECRET = "1mMdW8YTZBZdrevan-6Zkuj_";

    /**
     * コールバックURL
     */
    private static final String CALLBACK_URL = "http://test.internousdev.com/sundia/LoginGoogleAction";

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1524555947613444860L;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * レスポンス
     */
    private HttpServletResponse response;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * GoogleからリクエストTokenを取得メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/22
     * @return token取得できたらSUCCESSできなかったらERROR
     */
    public String execute() {
        GoogleOauth googleOauth = new GoogleOauth(API_KEY, API_SECRET, CALLBACK_URL);
        if (!googleOauth.getRequestToken(request, response)) {
            return ERROR;
        }
        session.put("login_flg", true);
        return SUCCESS;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッションを取得するためのメソッド
     * @return sessionを取得
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * レスポンス格納メソッド
     * @param response レスポンス
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエストを格納するためのメソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}