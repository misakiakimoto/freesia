package com.internousdev.sundia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.internousdev.util.oauth.twitter.TwitterOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Twitterでログインする為のクラス
 * @author  MISAKI AKIMOTO
 * @since 2017/07/11
 * @version 1.0
 */
public class GoTwitterAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {


    /**
     * コンシューマーキー
     */
    private static final String API_KEY = "J5xzZUUfzT3Ac4QXc9mEGegY5";

    /**
     * コンシューマーシークレット
     */
    private static final String API_SECRET = "RKXuTHHrtPqg3NJM3sHOfB3ePlODRu4BbCZRLnRR9wJIoRD1r8";


    /**
     * セッション情報
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
     * TwitterリクエストToken取得メソッド
     * @author  MISAKI AKIMOTO
     * @since 2017/07/11
     * @return  SUCCESS or ERROR
     */
    public String execute() {
        String result = ERROR;
        TwitterOauth twitterOauth = new TwitterOauth(API_KEY,API_SECRET);
        if (twitterOauth.getRequestToken(request, response)) {
            result = SUCCESS;
        }
        return result;
    }

    /**
     * セッション情報を格納するためのメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッション情報を取得するためのメソッド
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * レスポンスを格納するためのメソッド
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