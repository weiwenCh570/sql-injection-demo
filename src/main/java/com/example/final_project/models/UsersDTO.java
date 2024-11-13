package com.example.final_project.models;

public class UsersDTO {
    private int user_id;
    private String user_name;
    private String email;
    private int role_id;
    private String password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    public int getRole() {
        return role_id;
    }


    public void setRole(int role) {
        this.role_id = role;
    }

    public int getUid() {
        return user_id;
    }

    public void setUid(int uid) {
        this.user_id = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
