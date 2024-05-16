package com.sms.controller;

import com.sms.model.Message;
import com.sms.model.Student;
import com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> result = this.studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student result = this.studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> findStudentById(@PathVariable String id){
        Optional<Student> result = this.studentService.findById(id);
        return getStudentById(id, result);
    }

    private static ResponseEntity<Object> getStudentById(String id, Optional<Student> result) {
        if(result.isEmpty()){
            Message error = new Message();
            error.setStatus("Not Found");
            error.setMessage("No Student record found using this " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(result.get());
        }
    }
}
