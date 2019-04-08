package com.deerwalk.model;

public class Healthinstitute {
    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private String hid;
    private String name;
    private String type;
    private String address;
    private String phone;

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHid() {
        return hid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
