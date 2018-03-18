package com.zylear.model;

public class PeopleLike {
    private Integer peopleId;

    private Integer phoneId;

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public PeopleLike(Integer peopleId, Integer phoneId) {
        this.peopleId = peopleId;
        this.phoneId = phoneId;
    }

    public PeopleLike() {
    }
}