package com.app.addressmate.constants;

public class ConnectivityConstants {
	public static final int HTTP_SUCCESS = 200;
	public static final String REQUEST_FAILURE = "Request to Addressmate service failed :: response-code - %s, "
													+ "service-code - %s, service-message - %s";
	
	// TODO: move these to configuration file
	public static final String ADDRESSMATE_SERVICE_BASE_URI = "http://localhost:8080/addressmate-services/webapi";
	public static final String USER_URI ="users";
	public static final String SECURED_URI_PREFIX ="secured";
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	
	public static final String USER_UNAUTHORIZED = "1004";
}
