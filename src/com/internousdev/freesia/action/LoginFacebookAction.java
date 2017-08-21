package com.internousdev.freesia.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Definition;
import com.internousdev.util.oauth.facebook.FacebookOauth;
import com.internousdev.util.openconnect.Users;
import com.opensymphony.xwork2.ActionSupport;

/**
 * FACEBOOKでログインする為のクラス
 *
 * @author MISAKI AKIMOTO
 * @since 2017/07/05
 * @version 1.0
 */
public class LoginFacebookAction extends ActionSupport
implements SessionAware, ServletResponseAware, ServletRequestAware {



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
     * ネットワークネーム
     */
    static final int NETWORK_NAME = Definition.NETWORK_NAME_FACEBOOK;

    /**
     * レスポンス
     */
    private HttpServletRequest request;

    /**
     * リクエスト
     */
    private HttpServletResponse response;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * エラーメッセージ
     */
    private String errorMsg;

    /**
     * FACEBOOK認証の実行メソッド
     * @author MISAKI AKIMOTO
     * @since 2017/07/05
     * @return SUCCESS or ERROR
     */
    public String execute() {
        String rtn = ERROR;

        FacebookOauth facebook = new FacebookOauth(APP_KEY,APP_SECRET,CALLBACK_PATH);
        Users dto =facebook.loginFacebook(request,response);
        if(dto != null){

            if(facebook.login(dto, session)==null){
                rtn=SUCCESS;
            }
        }
        return rtn;
    }

    /**
     * リクエスト格納メソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * レスポンス格納メソッド
     * @param response　レスポンス
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * セッション取得メソッド
     * @return session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション格納メソッド
     * @param session　セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
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