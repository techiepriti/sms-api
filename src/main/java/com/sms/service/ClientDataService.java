package com.sms.service;

import com.sms.model.ClientData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ClientDataService extends MongoRepository<ClientData, String> {

}

