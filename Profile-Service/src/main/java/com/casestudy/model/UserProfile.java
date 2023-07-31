
package com.casestudy.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*getters, setters, all arguments and no argument constructors by annotations*/
@Data
@Document(collection = "UserProfile")
public class UserProfile {
	
	 /*This helps ignoring the field by not mapping it to the database*/
	@Transient
	public  static final String SEQUENCE_NAME="ProfileSequence";
	
	@Id
	private int profileId;
	
	@NotEmpty(message="Name is empty")
	private String fullName;
	
	
	@Email(message = "Email is not valid")
	@NotEmpty(message = "Email cannot be empty")
	@Indexed(unique=true)
	private String emailId;
	
	@NotNull
	private String username;
	
	
	@NotEmpty
	private  String role;
	
	

	@NotBlank
	@Size(min=5,message="length must be greater than 5")
	private String password;

	
	
	
	public UserProfile(int profileId, @NotEmpty(message = "Name is empty") String fullName,
			@Email(message = "Email is not valid") @NotEmpty(message = "Email cannot be empty") String emailId,
			@NotNull String username, @NotEmpty String role,
			@NotBlank @Size(min = 5, message = "length must be greater than 5") String password) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.username = username;
		this.role = role;
		this.password = password;
	}


	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setRole(String role) {
		this.role = role;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	public int getProfileId() {
		return profileId;
	}


	public String getFullName() {
		return fullName;
	}

	

	public String getRole() {
		return role;
	}


	public String getPassword() {
		return password;
	}


	

	

	
	
}
