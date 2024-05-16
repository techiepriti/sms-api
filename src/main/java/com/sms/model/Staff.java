package com.sms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SMS_Staff")
public class Staff {

    @Id
    private String registrationId;
    private String name;
    private String contact;
    private String email;
    private String gender;
    private Address address;
    private String qualification;
    private String experience;
    private String emergencyContact;

    public Staff() {

    }

    public Staff(String registrationId, String name, String contact, String email, String gender, Address address, String qualification, String experience, String emergencyContact) {
        this.registrationId = registrationId;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.qualification = qualification;
        this.experience = experience;
        this.emergencyContact = emergencyContact;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "registrationId='" + registrationId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", qualification='" + qualification + '\'' +
                ", experience='" + experience + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }
}
