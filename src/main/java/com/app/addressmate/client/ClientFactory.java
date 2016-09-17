package com.app.addressmate.client;

public class ClientFactory {
	
	public static AddressmateClient getAddressmateClient(Class<?> c){
		return new AddressmateClient(c);
	}
}
