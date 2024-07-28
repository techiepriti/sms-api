package com.sms.service;

import com.sms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserLogin extends MongoRepository<User, String> {
}
