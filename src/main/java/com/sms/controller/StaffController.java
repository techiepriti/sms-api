package com.sms.controller;

import com.sms.model.Message;
import com.sms.model.Staff;
import com.sms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getAllStaff(){
        List<Staff> result = this.staffService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/staff")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff){
        Staff result = this.staffService.save(staff);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Object> findStaffById(@PathVariable String id){
        Optional<Staff> result = this.staffService.findById(id);

        return getStaffById(id, result);
    }

    private static ResponseEntity<Object> getStaffById(String id, Optional<Staff> result) {
        if(result.isEmpty()){
            Message error = new Message();
            error.setStatus("Not Found");
            error.setMessage("No Student record found using this " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<Object> deleteStaff(@PathVariable String id){
        Optional<Staff> result = this.staffService.findById(id);
        if(result.isEmpty()){
            Message error = new Message();
            error.setStatus("Not Found");
            error.setMessage("No Student record found using this " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        else{
            this.staffService.delete(result.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
    }
}
