package com.internousdev.sundia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.internousdev.util.oauth.facebook.FacebookOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Facebookでログインする為のクラス
 * @author MISAKI AKIMOTO
 * @since 2017/8/10
 * @version 1.0
 */
public class GoFacebookAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

    /**
     * アプリID
     */
    private static final String APP_KEY = "1292801374175979";

    /**
     * appシークレット
     */
    private static final String APP_SECRET = "a6f426ca17f17fcf81f4f5b9cf1789c3";

    /**
     * コールバックパス
     */
    private static final String CALLBACK_PATH = "/LoginFacebookAction";

    /**
     * リクエスト
     * @author MISAKI AKIMOTO
     * @since 2017/7/18
     * @version 1.0
     */
    private HttpServletRequest request;

    /**
     * レスポンス
     * @author MISAKI AKIMOTO
     * @since 2017/7/18
     * @version 1.0
     */
    private HttpServletResponse response;

    /**
     * FaceBookからTokenを取得メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/18
     * @version 1.0
     */
    public String execute() {
        FacebookOauth oauth = new FacebookOauth(APP_KEY, APP_SECRET, CALLBACK_PATH);
        oauth.getRequestToken(request, response);
        return SUCCESS;
    }

    /**
     * リクエスト格納メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/18
     * @version 1.0
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * レスポンス格納メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/7/18
     * @version 1.0
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
