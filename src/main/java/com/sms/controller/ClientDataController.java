package com.sms.controller;

import com.sms.model.ClientData;
import com.sms.model.Message;
import com.sms.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientDataController {

    @Autowired
    private ClientDataService clientDataService;

    @PostMapping("/saveClientData")
    public ResponseEntity<Object> saveClientData(@RequestBody ClientData clientData) {
        if (null != clientData.getHostName() && null != clientData.getHostIP()) {
            String dataKey = clientData.getHostName().replace(" ", "") + clientData.getHostIP().replace(".", "");
            Optional<ClientData> data = this.clientDataService.findById(dataKey);
            if (data.isEmpty()) {
                clientData.setDataKey(dataKey);
                this.clientDataService.save(clientData);
                return ResponseEntity.status(HttpStatus.OK).body(clientData);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(new Message("error", "Client Data Already Exist!"));
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(new Message("error","Internal Server error"));
    }
}

