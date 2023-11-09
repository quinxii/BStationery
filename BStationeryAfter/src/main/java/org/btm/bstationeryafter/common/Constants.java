package org.btm.bstationeryafter.common;

public class Constants {
//	  GOOGLE
	  public static String GOOGLE_CLIENT_ID = "816363409708-mtt8vhcvnaav1fj49o1obfe72l9ec0h8.apps.googleusercontent.com";
	  public static String GOOGLE_CLIENT_SECRET = "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";
	  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/BStationeryAfter/login-google";
	  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	  public static String GOOGLE_GRANT_TYPE = "authorization_code";
	  
//	  FACEBOOK
	  public static String FACEBOOK_APP_ID = "321853500423324";
	  public static String FACEBOOK_APP_SECRET = "e9c74a10519c591d490e0db8f86efa24";
	  public static String FACEBOOK_REDIRECT_URL = "https://localhost:8080/BStationery/login-facebook";
	  public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
