package com.app.addressmate.client;

public class ClientFactory {
	
	public static AddressmateClient getAddressmateClient(Class<?> c, boolean useSecuredURI){
		return new AddressmateClient(c, useSecuredURI);
	}
}
