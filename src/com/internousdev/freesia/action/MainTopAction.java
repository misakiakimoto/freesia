/**
 *
 */
package com.internousdev.freesia.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TOP画面に遷移するクラス
 *
 * @author MISAKI AKIMOTO
 * @since 2017/08/19
 * @version 1.0
 */
public class MainTopAction extends ActionSupport implements SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	/**
	 * セッション情報(ユーザーID)
	 */
	private Map<String, Object> session;

	private HttpServletResponse response;

	private HttpServletRequest request;

	/**
	 * CookieからSession情報を取得するメソッド
	 */

	public String execute(){
	    String result=ERROR;

	    session.clear();{

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
	            result=SUCCESS;
	        }
	    }
	    }


	    return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

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
