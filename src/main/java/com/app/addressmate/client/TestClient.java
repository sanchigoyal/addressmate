package com.app.addressmate.client;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.app.addressmate.bean.UserProfile;

public class TestClient {
	public static void main(String args[]){
		IClient client = ClientFactory.getAddressmateClient(UserProfile.class);
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("username", "Michael Goerge");
		queryParams.put("password", "abc");
		Response response = client.get(queryParams, null, false);
		UserProfile user = response.readEntity(UserProfile.class);
		System.out.println(user.toString());
	}
}
