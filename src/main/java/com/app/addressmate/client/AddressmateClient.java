package com.app.addressmate.client;

import org.glassfish.jersey.internal.util.Base64;

import com.app.addressmate.bean.UserProfile;
import com.app.addressmate.constants.ConnectivityConstants;


public class AddressmateClient extends AbstractClient{
	

	public AddressmateClient(Class<?> c, boolean useSecuredURI){
		super(c, useSecuredURI);
	}
	
	@Override
	protected String getEntityURI(Class<?> c) {
		if(c == UserProfile.class){
			return ConnectivityConstants.USER_URI;
		}
		return null;
	}
	
	@Override
	protected String getAuthorizationHeader() {
		// TODO: move this to a configuration file
		String accessID = "addressmate_app_123";
		String password = "addressmate_app_123";
		String authToken = accessID + ":" + password;
		String encodedAuthToken =  Base64.encodeAsString(authToken);
		return ConnectivityConstants.AUTHORIZATION_HEADER_PREFIX + encodedAuthToken;
	}
	
	@Override
	public String getBaseURL(boolean useSecuredURI) {
		if(useSecuredURI){
			return  ConnectivityConstants.ADDRESSMATE_SERVICE_BASE_URI+"/"+ConnectivityConstants.SECURED_URI_PREFIX;
		}else{
			return ConnectivityConstants.ADDRESSMATE_SERVICE_BASE_URI;
		}
	}
}
