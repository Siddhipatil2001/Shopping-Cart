package com.casestudy.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.models.Statement;

public interface StatementRepository extends MongoRepository<Statement, Integer>{
	
	List<Statement> findByStatementId(int profileId);

}