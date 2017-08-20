package com.internousdev.sundia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Definition;
import com.internousdev.util.oauth.google.GoogleOauth;
import com.internousdev.util.openconnect.Users;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Googleでログインする為のクラス
 * @author MISAKI AKIMOTO
 * @since 2017/05/18
 * @version 1.0
 */
public class LoginGoogleAction extends ActionSupport implements
        ServletRequestAware, SessionAware {

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
     * ネットワークネーム
     */
    static final int NETWORK_NAME = Definition.NETWORK_NAME_GOOGLE;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * エラーメッセージ
     */
    private String errorMsg;

    /**
     * Google認証の実行メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/05/18
     * @return SUCCESS
     */
    public String execute() {
        String rtn = ERROR;
        GoogleOauth loginG = new GoogleOauth(API_KEY, API_SECRET, CALLBACK_URL);
        Users dto = loginG.loginGoogle(request);
        if (dto != null) {
            if (loginG.login(dto, session) == null) {
                rtn = SUCCESS;
            }
        }
        return rtn;
    }

    /**
     *  セッションを格納するためのメソッド
     *  @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッションを取得するためのメソッド
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * リクエストを取得するためのメソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * エラーメッセージ取得メソッド
     * @return errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * エラーメッセージ格納メソッド
     * @param errorMsg セットする errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}