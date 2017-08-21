package com.internousdev.freesia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Definition;
import com.internousdev.util.oauth.twitter.TwitterOauth;
import com.internousdev.util.openconnect.Users;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Twitterでログインする為のクラス
 * @author MISAKI AKIMOTO
 * @since 2017/07/18
 * @version 1.0
 */
public class LoginTwitterAction extends ActionSupport
        implements ServletResponseAware, ServletRequestAware, SessionAware {

    /**
     * コンシューマーキー
     */
    private static final String API_KEY = "J5xzZUUfzT3Ac4QXc9mEGegY5";

    /**
     * コンシューマーシークレット
     */
    private static final String API_SECRET = "RKXuTHHrtPqg3NJM3sHOfB3ePlODRu4BbCZRLnRR9wJIoRD1r8";

    /**
     * ネットワークネーム
     */
    static final int NETWORK_NAME = Definition.NETWORK_NAME_TWITTER; //twitter

    /**
     * セッション情報
     */
    public Map<String, Object> session;

    /**
     * レスポンス
     */
    private HttpServletResponse response;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * エラーメッセージ
     */
    private String errorMsg;

    /**
     * Twitter認証の実行メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/18
     * @return SUCCESS or ERROR
     */
    public String execute() {
        String rtn = ERROR;
        TwitterOauth loginT = new TwitterOauth(API_KEY, API_SECRET);
        Users dto = loginT.loginTwitter(request, response);
        if (dto != null) {
            if (loginT.login(dto, session) == null) {
                rtn = SUCCESS;
            }
        }
        return rtn;
    }

    /**
     * レスポンス格納メソッド
     * @param response レスポンス
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

    /**
     * セッション情報格納メソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッション情報取得メソッド
     * @return Session
     */
    public Map<String, Object> getSession() {
        return session;
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