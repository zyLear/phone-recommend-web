package com.zylear.model;

public class PeopleInfo {
    private Integer id;

    private String password;

    private String gender;

    private Integer age;

    private String status;

    public PeopleInfo(Integer id, String password, String gender, Integer age, String status) {
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.status = status;
    }

    public PeopleInfo(Integer id, Integer age,String gender, String status) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.status = status;
    }

    public PeopleInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}