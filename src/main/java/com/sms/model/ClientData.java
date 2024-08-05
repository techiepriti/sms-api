package com.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientData {

    @Id
    @JsonIgnore
    private String dataKey;
    private String hostName;
    private String hostIP;
    private String hostLocation;

    public ClientData() {
    }

    public ClientData(String dataKey, String hostName, String hostIP, String hostLocation) {
        this.dataKey = dataKey;
        this.hostName = hostName;
        this.hostIP = hostIP;
        this.hostLocation = hostLocation;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getHostLocation() {
        return hostLocation;
    }

    public void setHostLocation(String hostLocation) {
        this.hostLocation = hostLocation;
    }

    @Override
    public String toString() {
        return "ClientData{" +
                "dataKey='" + dataKey + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostIP='" + hostIP + '\'' +
                ", hostLocation='" + hostLocation + '\'' +
                '}';
    }
}
