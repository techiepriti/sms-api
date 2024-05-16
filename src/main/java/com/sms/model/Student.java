package com.sms.model;

import com.sms.model.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SMS_Student")
public class Student {
    @Id
    private String registrationId;
    private String name;
    private String fatherName;
    private String motherName;
    private String contact;
    private String email;
    private String gender;
    private Address address;
    private String studentClass;
    private String section;
    private String emergency_contact;

    public Student() {
    }

    public Student(String registrationId, String name, String fatherName, String motherName, String contact, String email, String gender, Address address, String studentClass, String section, String emergency_contact) {
        this.registrationId = registrationId;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.studentClass = studentClass;
        this.section = section;
        this.emergency_contact = emergency_contact;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "registrationId='" + registrationId + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", studentClass='" + studentClass + '\'' +
                ", section='" + section + '\'' +
                ", emergency_contact='" + emergency_contact + '\'' +
                '}';
    }
}
