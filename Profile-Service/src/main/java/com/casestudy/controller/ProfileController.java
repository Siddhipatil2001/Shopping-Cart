package com.casestudy.controller;

import java.util.List;    
import java.util.Map;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.exception.ProfileAlreadyExistsException;
import com.casestudy.exception.ProfileNotFoundException;
import com.casestudy.model.UserProfile;
import com.casestudy.service.ProfileService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*", maxAge = 3600)   //allows http requests from single orgin
public class ProfileController {

	@Autowired
	private ProfileService profileServiceImpl;
	
	@Autowired
	final RestTemplate restTemplate;

	
	Logger logger= LoggerFactory.getLogger(ProfileController.class);

	public ProfileController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
		
	}
	
	
	//adding new user profile
	@PostMapping("/adduser")
	public ResponseEntity<UserProfile> addNewCustomerProfile ( @RequestBody  UserProfile userProfile) throws ProfileAlreadyExistsException{
				
			logger.info("add new Customer");
				UserProfile savedUser= profileServiceImpl.addNewCustomerProfile(userProfile);
				return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
				
	}
	

	//get all profiles 
	@GetMapping("/getallusers")
	public List<UserProfile> getAllProfiles() {
		
		return profileServiceImpl.getAllProfiles();

	}
	
	//get profile by user profileId
	@GetMapping("/user/{profileId}")
	public ResponseEntity<UserProfile> getByProfileId(@PathVariable int profileId) throws ProfileNotFoundException{
		return new ResponseEntity<>( profileServiceImpl.getByProfileId(profileId),HttpStatus.OK);
	}
	
	// update user profile using user fullName
	@PutMapping("/user/update/{fullName}")
	public ResponseEntity<UserProfile> updateProfile(@PathVariable String fullName, @RequestBody UserProfile userProfile) throws ProfileNotFoundException {

		UserProfile updatedProfile= profileServiceImpl.updateProfile(fullName,userProfile);
		return ResponseEntity.ok(updatedProfile);
	}
	
	//delete user profile by user profileId
	@DeleteMapping("/user/delete/{profileId}")
	public Map<String,Boolean>  deleteProfile(@PathVariable int profileId) throws ProfileNotFoundException{
		logger.warn("delete method");
		return profileServiceImpl.deleteProfile(profileId);
		
	}
	
	//get user by user fullName
	@GetMapping("/userByName/{fullName}")
	public UserProfile getByUserName(@PathVariable String fullName) {
		logger.info("get by fullname");
		
		return profileServiceImpl.getByUserName(fullName);
	}
	
	
	
}
