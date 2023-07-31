package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;

import com.casestudy.model.UserProfile;

@Repository
public interface ProfileRepository extends MongoRepository<UserProfile, Integer> {
	

	public UserProfile findByFullName(String fullName);
	
	

}
