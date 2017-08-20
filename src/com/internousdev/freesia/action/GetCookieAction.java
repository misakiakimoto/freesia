package com.internousdev.sundia.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sundia.dao.UserLevelDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * cookieを取得するための Actionクラス
 * @author JUNYA TAKENO
 * @since 2017/08/16
 * @version 1.0
 */

public class GetCookieAction extends ActionSupport
implements SessionAware, ServletResponseAware, ServletRequestAware{


    private static final long serialVersionUID = 7571370796798435364L;

    /**
     * セッション情報(ユーザーID)
     */
    private Map<String,Object>session;

    /**
     * response情報を格納するための変数
     */
    private HttpServletResponse response;

    /**
     * request情報
     */
    private HttpServletRequest request;

    /**
     * URL情報
     */
    private String url;


    /**
     * CookieからSession情報を取得するメソッド
     * @author JUNYA TAKENO
     * @since 2017/08/16
     * @version 1.0
     */
    public String execute(){
     String result=ERROR;

    session.remove("userId");
    session.remove("loginFlg");
    session.remove("userLevel");

    if(session.get("userId")==null){
        String val1 = null;
        String val2 = null;
        Cookie cookies[]=request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("userId")){
                val1=cookies[i].getValue();
                session.put("userId",Integer.parseInt(val1));
            }else if(cookies[i].getName().equals("loginFlg")){
                val2=cookies[i].getValue();
                session.put("loginFlg",Boolean.valueOf(val2));
            }
        }if(val1 != null&& val2 != null){
            int id= Integer.parseInt(val1);
            UserLevelDAO levelDAO = new UserLevelDAO();
            session.put("userLevel",levelDAO.select(id));
        }
    }

    result=SUCCESS;

    session.put("getCookie",true);
    if(url.length()>0){
        session.put("prevurl",url);
    }else{
        session.put("prevurl","a");
    }
    return result;
}


    /**
    * セッション情報を取得するメソッド
    * @return session セッション情報
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
    * レスポンス情報を取得するメソッド
    * @return response　レスポンス情報
    */
    public HttpServletResponse getResponse() {
    return response;
    }

    /**
     * レスポンス情報を格納するメソッド
     * @param response レスポンス情報
     */
    public void setResponse(HttpServletResponse response) {
    this.response = response;
    }

    /**
    * リクエスト情報を取得するメソッド
    * @return request リクエスト情報
    */
    public HttpServletRequest getRequest() {
    return request;
    }

    /**
     * リクエスト情報を格納するメソッド
     * @param request リクエスト情報
     */
    public void setRequest(HttpServletRequest request) {
    this.request = request;
    }

    /**
    * URL情報を取得するメソッド
    * @return URL URL情報
    */
    public String getUrl() {
        return url;
    }

    /**
     * URL情報を格納するメソッド
     * @param url URL情報
     */
    public void setUrl(String url) {
        this.url = url;
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

