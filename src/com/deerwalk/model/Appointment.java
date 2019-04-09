package com.deerwalk.model;

import java.sql.Timestamp;

public class Appointment {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String address;
    private String province;
    private String zone;
    private String district;
    private String atype;
    private String selectdoctor;
    private String description;
    private String status;
    private String userName;
    private String department;
    private String selectHealthinstitute;
    private String preferredDate;
    private String preferredTime;
    private Timestamp timestamp;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getAtype() {
        return atype;
    }

    public void setSelectdoctor(String selectdoctor) {
        this.selectdoctor = selectdoctor;
    }

    public String getSelectdoctor() {
        return selectdoctor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


    public void setSelectHealthinstitute(String selectHealthinstitute) {
        this.selectHealthinstitute = selectHealthinstitute;
    }

    public String getSelectHealthinstitute() {
        return selectHealthinstitute;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }

        public String getPreferredTime() {
            return preferredTime;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
}

