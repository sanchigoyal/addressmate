package com.app.addressmate.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User Profile POJO
 * 
 * @author Sanchi
 *
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
	
	/** unique id of user */
	private int userID;
	
	/** email address of user */
	private String email;
	
	/** encrypted password */
	private String password;
	
	/** password decryption key */
	private String salt;
	
	/** user first name */
	private String firstName;
	
	/** user last name */
	private String lastName;
	
	/** user date of registration */
	private Date dateOfRegistration;
	
	/** user UUID for URL */
	private String userUUID;
	
	
	public UserProfile(int userId, String email, String password, 
			String salt, String firstName,String lastName, Date dateOfRegistration, String userUUID){
		this.userID = userId;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfRegistration = dateOfRegistration;
		this.userUUID = userUUID;
		
	}
	
	public UserProfile(){
		
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getUserUUID() {
		return userUUID;
	}
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	
	@Override
	public String toString(){
		return "USER_ID - "+userID+"\n"
				+"EMAIL - "+email; 
	}
	
}
