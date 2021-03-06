package com.medical.model.dto;

import com.medical.model.entity.UserData;

public class LocalUserDataDto implements LocalDataDto {
    private UserData userData;
    private String name;
    private String surname;
    private String patronymic;

    public LocalUserDataDto(UserData userData, String name, String surname, String patronymic) {
        this.userData = userData;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public LocalUserDataDto() {
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
