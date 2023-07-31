package com.casestudy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.models.Ewallet;


@Repository
public interface EwalletRepository extends MongoRepository<Ewallet, String>{

	public Ewallet findByProfileId(int profileId);
}