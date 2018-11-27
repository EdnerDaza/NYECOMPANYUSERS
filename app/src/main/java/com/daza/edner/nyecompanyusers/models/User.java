package com.daza.edner.nyecompanyusers.models;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String position;
    private int image;

    public User() {
    }

    public User(int id, String name, String email, String phone, String mobile, String position, int image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.position = position;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
