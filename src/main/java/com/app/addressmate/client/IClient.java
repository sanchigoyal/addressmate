package com.app.addressmate.client;

import java.util.Map;

import javax.ws.rs.core.Response;

public interface IClient {
	public Response get(Map<String, String> queryParams, Map<String, String> headerParams, boolean useSecuredURI);
	public Response post(Map<String, String> headerParams, Object entity);
	public Response put(Map<String, String> headerParams);
	public Response delete(Map<String, String> headerParams);
}
