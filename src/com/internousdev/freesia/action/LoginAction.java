package com.internousdev.freesia.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.UserLevelDAO;
import com.internousdev.util.login.LoginConnector;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログインボタンからログインするクラス
 * @author MISAKI AKIMOTO
 * @since 2017/7/11
 * @version 1.0
 */

public class LoginAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware {

    /**
     * メールアドレス
     */
    private String email;
    /**
     * パスワード
     */
    private String password;
    /**
     * セッション情報（ユーザーID）
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
     * userIdのCookie
     */
    private Cookie cookieUserId;

    /**
     * loginFlgのCookie
     */
    private Cookie cookieLoginFlg;

    /**
     * ログインするための実行メソッド
     * @return 成功 =SUCCESS、失敗 =ERROR、管理人 =LOGIN
     * @author MISAKI AKIMOTO
     * @since 2017/7/11
     */
    public String execute() {
        LoginConnector login = new LoginConnector(email, password);
        String result = null;
        result = login.login(session);

        if (result == "login") {
            int id = (int) session.get("userId");
            session.put("userLevel", new UserLevelDAO().select(id));
        }

        String cUserId = String.valueOf(session.get("userId"));
        String cLoginFlg = String.valueOf(session.get("loginFlg"));


        cookieUserId = new Cookie("userId", cUserId);
        cookieLoginFlg = new Cookie("loginFlg", cLoginFlg);

        cookieUserId.setMaxAge(60 * 60 * 24);
        cookieLoginFlg.setMaxAge(60 * 60 * 24);

        cookieUserId.setPath("/");
        cookieLoginFlg.setPath("/");

        response.addCookie(cookieUserId);
        response.addCookie(cookieLoginFlg);

        return result;
    }

    /**
     * メールアドレスを取得するメソッド
     * @return Emailメールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**メールアドレスを格納するメソッド
     * @param email セットする eEmail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * パスワードを取得するメソッド
     * @return password パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを格納するメソッド
     * @param password セットする
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * セッション情報を取得するメソッド
     * @return sessionセッション情報
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

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * レスポンス情報を取得するメソッド
     * @return response　response
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
     * @return request　request
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

    /**
     * クッキー内のユーザーIDを取得するメソッド
     * @return cookieUserId　cookieUserId
     */
    public Cookie getCookieUserId() {
        return cookieUserId;
    }

    /**
     * クッキー内のユーザーIDを格納するメソッド
     * @param cookieUserId セットする cookieUserId
     */
    public void setCookieUserId(Cookie cookieUserId) {
        this.cookieUserId = cookieUserId;
    }

    /**
     * クッキー内のログイン情報を取得するメソッド
     * @return cookieLoginFlg　cookieLoginFlg
     */

    public Cookie getCookieLoginFlg() {
        return cookieLoginFlg;
    }

    /**
     * クッキー内のログイン情報を格納するメソッド
     * @param cookieLoginFlg セットする cookieLoginFlg
     */
    public void setCookieLoginFlg(Cookie cookieLoginFlg) {
        this.cookieLoginFlg = cookieLoginFlg;
    }

}