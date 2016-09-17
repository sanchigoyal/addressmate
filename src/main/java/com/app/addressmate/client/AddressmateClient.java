package com.app.addressmate.client;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

import com.app.addressmate.bean.UserProfile;
import com.app.addressmate.constants.ConnectivityConstants;


public class AddressmateClient implements IClient{
	
	private String baseURL;
	private WebTarget baseTarget;
	private WebTarget entityTarget;
	private WebTarget securedEntityTarget;
	private WebTarget singleEntityTarget;
	private WebTarget securedSingleEntityTarget;
	
	public AddressmateClient(Class<?> c){
		Client client = ClientBuilder.newClient();
		baseURL = ConnectivityConstants.ADDRESSMATE_SERVICE_BASE_URI;
		baseTarget = client.target(baseURL);
		entityTarget = baseTarget.path(getEntityURI(c));
		securedEntityTarget = baseTarget.path(ConnectivityConstants.SECURED_URI_PREFIX).path(getEntityURI(c));
		singleEntityTarget = entityTarget.path("{entityId}");
		securedSingleEntityTarget = securedEntityTarget.path("{entityId}");
	}
	
	private String getEntityURI(Class<?> c) {
		if(c == UserProfile.class){
			return ConnectivityConstants.USER_URI;
		}
		return null;
	}
	
	public Response getSingleEntity(String entityId, Map<String, String> queryParams, Map<String, String> headerParams,
			boolean useSecuredURI){
		WebTarget target = singleEntityTarget;
		
		// include query parameters
		for(String key : queryParams.keySet()){
			//It is important to know queryParam method won't update 
			//current WebTarget object, but return a new one. 
			target = target.queryParam(key, queryParams.get(key));
		}
		
		Response response = target.resolveTemplate("{entityId}", entityId)
								.request(MediaType.APPLICATION_JSON)
								.get(Response.class);
		return response;
	}
	
	public Response get(Map<String, String> queryParams, Map<String, String> headerParams, boolean useSecuredURI){
		WebTarget target = useSecuredURI ? securedEntityTarget : entityTarget;
		
		// include query parameters
		if(queryParams != null){
			for(String key : queryParams.keySet()){
				//It is important to know queryParam method won't update 
				//current WebTarget object, but return a new one. 
				target = target.queryParam(key, queryParams.get(key));
			}
		}
		
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		
		// include header parameters
		if(headerParams != null){
			for(String key : headerParams.keySet()){
				builder = builder.header(key, headerParams.get(key));
			}
		}
		
		// include authorization header
		builder = builder.header(ConnectivityConstants.AUTHORIZATION_HEADER, getAuthorizationHeader());
		
		Response response = builder.get(Response.class);
		
		return response;
	}

	private String getAuthorizationHeader() {
		// TODO: move this to a configuration file
		String accessID = "addressmate_app_123";
		String password = "addressmate_app_123";
		String authToken = accessID + ":" + password;
		String encodedAuthToken =  Base64.encodeAsString(authToken);
		return ConnectivityConstants.AUTHORIZATION_HEADER_PREFIX + encodedAuthToken;
	}

	public Response post(Map<String, String> headerParams, Object entity) {
		WebTarget target = entityTarget;
		
		Response response = target.request(MediaType.APPLICATION_JSON)
								  .post(Entity.json(entity));
		return response;
	}

	public Response put(Map<String, String> headerParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response delete(Map<String, String> headerParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
