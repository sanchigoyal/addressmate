package com.app.addressmate.services;

import com.app.addressmate.bean.UserProfile;
import com.app.addressmate.exception.RequestFailureException;

public interface UserServices {

	public boolean addUser(UserProfile user);

	public UserProfile getUser(UserProfile user) throws RequestFailureException;
	
}
