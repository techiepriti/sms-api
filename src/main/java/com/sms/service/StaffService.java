package com.sms.service;

import com.sms.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffService extends MongoRepository<Staff, String> {

    public Staff findByEmail(String email);
}
