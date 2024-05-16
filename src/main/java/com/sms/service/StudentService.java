package com.sms.service;

import com.sms.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends MongoRepository<Student, String> {
    public Student findByEmail(String email);
}
