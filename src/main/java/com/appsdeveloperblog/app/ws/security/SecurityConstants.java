package com.appsdeveloperblog.app.ws.security;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 8640000000L; // 10 days
	public static final String[] SING_UP_URL = {"/users"};
	public static final String HEADER_STRING = "Authoriszation";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";
}
