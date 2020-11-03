package com.ecom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.model.User;

public interface UserRepository extends MongoRepository<User, String>
{

}
