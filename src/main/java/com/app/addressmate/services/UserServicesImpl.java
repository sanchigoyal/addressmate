package com.app.addressmate.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.app.addressmate.bean.ErrorMessage;
import com.app.addressmate.bean.UserProfile;
import com.app.addressmate.client.ClientFactory;
import com.app.addressmate.client.IClient;
import com.app.addressmate.constants.ConnectivityConstants;
import com.app.addressmate.exception.RequestFailureException;

public class UserServicesImpl implements UserServices{
	
	Logger LOGGER = Logger.getLogger(UserServicesImpl.class);
	
	public boolean addUser(UserProfile user) {
		return false;
	}
	
	/**
	 * Method to return a user
	 * In a way this is equivalent to validate user 
	 * as service already does validation before sending the info.
	 */
	public UserProfile getUser(UserProfile input) throws RequestFailureException{
		UserProfile user = null;
		ErrorMessage errorMessage = null;
		IClient client = ClientFactory.getAddressmateClient(UserProfile.class);
		Map<String, String> queryParams = new HashMap<String, String>();
		
		queryParams.put("email", input.getEmail());
		queryParams.put("password", input.getPassword());
		
		Response response = client.get(queryParams, null, true);
		
		if(response.getStatus() == Status.OK.getStatusCode()){
			user = response.readEntity(UserProfile.class);
		}else{
			errorMessage = response.readEntity(ErrorMessage.class);
			// throw exception if not 401
			if(response.getStatus() != Status.UNAUTHORIZED.getStatusCode()){
				throw new RequestFailureException(response.getStatus(), errorMessage.getMessage(), errorMessage.getCode());
			}
			
			// 401 can have two possibilities 
			// 1. User unauthorized
			// 2. Vendor unauthorized
			
			if(!ConnectivityConstants.USER_UNAUTHORIZED.equals(errorMessage.getCode())){
				throw new RequestFailureException(response.getStatus(), errorMessage.getMessage(), errorMessage.getCode());
			}
		}
		return user;
	}

}
