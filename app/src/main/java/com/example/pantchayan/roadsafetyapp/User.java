package com.example.pantchayan.roadsafetyapp;

public class User {
    private String userName;
    private String userEmail;
    private String userImgUrl;
    private String userType;
    private String token;

    public User(String userName, String userEmail, String userImgUrl, String userType, String token) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImgUrl = userImgUrl;
        this.userType = userType;
        this.token = token;
    }

    public User() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserType(){ return userType; }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken(){ return token; }

    public void setToken(String favGenre2) {
        this.token = token;
    }

}