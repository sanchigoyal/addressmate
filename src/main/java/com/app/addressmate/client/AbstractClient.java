package com.app.addressmate.client;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.addressmate.constants.ConnectivityConstants;

public abstract class AbstractClient {
	private WebTarget baseTarget;
	private WebTarget entityTarget;
	private WebTarget singleEntityTarget;
	
	public AbstractClient(Class<?> c, boolean useSecuredURI){
		Client client = ClientBuilder.newClient();
		baseTarget = client.target(getBaseURL(useSecuredURI));
		entityTarget = baseTarget.path(getEntityURI(c));
		singleEntityTarget = entityTarget.path("{entityId}");
		
	}
	
	/**
	 * Method to provide service base URL
	 * Implementation to be provided by child class
	 * @param useSecuredURI
	 * @return
	 */
	protected abstract String getBaseURL(boolean useSecuredURI);
	
	/**
	 * Method to provide entity URL
	 * Implementation to be provided by child class
	 * @param c
	 * @return
	 */
	protected abstract String getEntityURI(Class<?> c);
	
	/**
	 * Method to provide authorization header
	 * Implementation to be provided by child class
	 * @return
	 */
	protected abstract String getAuthorizationHeader();
	
	/**
	 * Method to get response from a service
	 * @param queryParams
	 * @param headerParams
	 * @return
	 */
	public final Response get(Map<String, String> queryParams, Map<String, String> headerParams){
		WebTarget target = entityTarget;
		
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
	
	/**
	 * Method to create a new resource
	 * @param headerParams
	 * @param entity
	 * @return
	 */
	public final Response post(Map<String, String> headerParams, Object entity) {
		WebTarget target = entityTarget;
		
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		
		// include header parameters
		if(headerParams != null){
			for(String key : headerParams.keySet()){
				builder = builder.header(key, headerParams.get(key));
			}
		}
		
		// include authorization header
		builder = builder.header(ConnectivityConstants.AUTHORIZATION_HEADER, getAuthorizationHeader());
		
		Response response = builder.post(Entity.json(entity));
		return response;
	}
	
	public final Response getSingleEntity(String entityId, Map<String, String> queryParams, Map<String, String> headerParams,
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
	
	public final Response put(Map<String, String> headerParams) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public final Response delete(Map<String, String> headerParams) {
		// TODO Auto-generated method stub
		return null;
	}
}
