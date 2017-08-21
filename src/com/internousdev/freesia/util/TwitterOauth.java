/**
 *
 */
package com.internousdev.freesia.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
/**
 * @author Misaki Akimoto
 *
 */
public class TwitterOauth {

	private boolean result = false;
	private final String CONSUMER_KEY = "J5xzZUUfzT3Ac4QXc9mEGegY5";
	private final String CONSUMER_SECRET="RKXuTHHrtPqg3NJM3sHOfB3ePlODRu4BbCZRLnRR9wJIoRD1r8";
	private static TwitterFactory twitterFactory = new TwitterFactory();
	//ユーザー情報を取得するためのメソッド
	public boolean getRequestToken(HttpServletRequest request, HttpServletResponse response){
	Twitter twitter = twitterFactory.getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
	try{
	RequestToken reqToken = twitter.getOAuthRequestToken();
	HttpSession session = request.getSession();
	session.setAttribute("RequestToken", reqToken);
	session.setAttribute("Twitter", twitter);
	String url = reqToken.getAuthorizationURL();
	response.sendRedirect(url);
	}catch(TwitterException | IOException e){
	e.printStackTrace();
	}
	return result;
	}

//トークンを取得するためのメソッド
public String[] getAccessToken(HttpServletRequest request, HttpServletResponse response){
HttpSession session = request.getSession();
Twitter twitter = (Twitter) session.getAttribute("Twitter");
String verifier = request.getParameter("oauth_verifier");
if(verifier == null){
try{
response.sendRedirect(request.getContextPath()+ "/login");
}catch(Exception e){
e.printStackTrace();
return null;
}
}
AccessToken accessToken = null;
try{
if(session.getAttribute("RequestToken") != null){
accessToken = twitter.getOAuthAccessToken( (RequestToken)
session.getAttribute("RequestToken"), verifier);
}else{
return null;
}
}catch(Exception e){
e.printStackTrace();
return null;
}
if(accessToken != null){
session.setAttribute("AccessToken", accessToken.getToken());
session.setAttribute("AccessTokenSecret", accessToken.getTokenSecret());
}

User user = null;
try{
user = twitter.verifyCredentials();
}catch(TwitterException e){
e.printStackTrace();
}
String[] userData = new String[2];
userData[0] = user.getScreenName();
userData[1] = user.getName();
return userData;
}
}
