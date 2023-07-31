package com.casestudy.service;

import java.util.List; 
import java.util.Map;

import org.springframework.stereotype.Service;

import com.casestudy.exception.ProfileAlreadyExistsException;
import com.casestudy.exception.ProfileNotFoundException;
import com.casestudy.model.UserProfile;

//interface for profile service implementation
@Service
public interface ProfileService {

	public UserProfile addNewCustomerProfile(UserProfile userProfile) throws ProfileAlreadyExistsException;

	public List<UserProfile> getAllProfiles();

	public UserProfile getByProfileId(int profileId)throws ProfileNotFoundException;

	public Map<String,Boolean>  deleteProfile(int profileId) throws ProfileNotFoundException;

	public void addNewAdminProfile(UserProfile userProfile);

	public void addNewManagerProfile(UserProfile userProfile);

	public UserProfile getByUserName(String fullName);

	public  UserProfile updateProfile( String fullName,UserProfile userProfile) throws ProfileNotFoundException;

}
