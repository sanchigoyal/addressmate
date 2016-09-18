package com.app.addressmate.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.app.addressmate.bean.ErrorMessage;
import com.app.addressmate.bean.UserProfile;
import com.app.addressmate.client.AbstractClient;
import com.app.addressmate.client.ClientFactory;
import com.app.addressmate.constants.ConnectivityConstants;
import com.app.addressmate.exception.RequestFailureException;

public class UserServicesImpl implements UserServices{
	
	Logger LOGGER = Logger.getLogger(UserServicesImpl.class);
	
	/**
	 * Method to add a user
	 * 
	 */
	public UserProfile addUser(UserProfile input) {
		ErrorMessage errorMessage = null;
		AbstractClient client = ClientFactory.getAddressmateClient(UserProfile.class, true);
		Response response = client.post(null, input);
		
		if(response.getStatus() != Status.CREATED.getStatusCode()){
			System.out.println("------------------------->"+response);
			errorMessage = response.readEntity(ErrorMessage.class);
			throw new RequestFailureException(response.getStatus(), errorMessage.getMessage(), errorMessage.getCode());
		}
		
		return response.readEntity(UserProfile.class);
	}
	
	/**
	 * Method to return a user
	 * In a way this is equivalent to validate user 
	 * as service already does validation before sending the info.
	 */
	public UserProfile getUser(UserProfile input) throws RequestFailureException{
		UserProfile user = null;
		ErrorMessage errorMessage = null;
		AbstractClient client = ClientFactory.getAddressmateClient(UserProfile.class, true);
		Map<String, String> queryParams = new HashMap<String, String>();
		
		queryParams.put("email", input.getEmail());
		queryParams.put("password", input.getPassword());
		
		Response response = client.get(queryParams, null);
		
		if(response.getStatus() == Status.OK.getStatusCode()){
			user = response.readEntity(UserProfile.class);
		}else{
			errorMessage = response.readEntity(ErrorMessage.class);
			
			// throw exception if anything apart from 401 and 200
			if(response.getStatus() != Status.UNAUTHORIZED.getStatusCode()){
				throw new RequestFailureException(response.getStatus(), errorMessage.getMessage(), errorMessage.getCode());
			}
			
			/* 
			 * 401 can have two possibilities 
			 * 1. User unauthorized
			 * 2. Vendor unauthorized - throw exception in this case
			 * 
			 */
			if(!ConnectivityConstants.USER_UNAUTHORIZED.equals(errorMessage.getCode())){
				throw new RequestFailureException(response.getStatus(), errorMessage.getMessage(), errorMessage.getCode());
			}
		}
		return user;
	}

}
