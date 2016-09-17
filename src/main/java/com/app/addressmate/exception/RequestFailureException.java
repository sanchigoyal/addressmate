package com.app.addressmate.exception;

import com.app.addressmate.constants.ConnectivityConstants;

public class RequestFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RequestFailureException(int responseCode, String serviceMessage, String serviceCode){
		super(String.format(ConnectivityConstants.REQUEST_FAILURE, 
				responseCode,
				serviceCode, 
				serviceMessage));
	}
}
