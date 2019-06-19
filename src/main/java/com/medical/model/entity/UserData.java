package com.medical.model.entity;

public class UserData {
    private Integer id;

    private String surnameUk;
    private String surnameEn;
    private String nameUk;
    private String nameEn;
    private String patronymicUk;
    private String patronymicEn;
    private String login;
    private String password;
    private String role;
    private String photo;

    public UserData(Integer id, String surnameUk, String surnameEn, String nameUk,
                    String nameEn, String patronymicUk, String patronymicEn, String login,
                    String password, String role, String photo) {
        this.id = id;
        this.surnameUk = surnameUk;
        this.surnameEn = surnameEn;
        this.nameUk = nameUk;
        this.nameEn = nameEn;
        this.patronymicUk = patronymicUk;
        this.patronymicEn = patronymicEn;
        this.login = login;
        this.password = password;
        this.role = role;
        this.photo = photo;
    }

    public UserData(String surnameUk, String surnameEn, String nameUk, String nameEn, String patronymicUk,
                    String patronymicEn, String login, String password, String role, String photo) {
        this.surnameUk = surnameUk;
        this.surnameEn = surnameEn;
        this.nameUk = nameUk;
        this.nameEn = nameEn;
        this.patronymicUk = patronymicUk;
        this.patronymicEn = patronymicEn;
        this.login = login;
        this.password = password;
        this.role = role;
        this.photo = photo;
    }

    public UserData(String surnameUk, String surnameEn, String nameUk, String nameEn,
                    String patronymicUk, String patronymicEn, String login, String password) {
        this.surnameUk = surnameUk;
        this.surnameEn = surnameEn;
        this.nameUk = nameUk;
        this.nameEn = nameEn;
        this.patronymicUk = patronymicUk;
        this.patronymicEn = patronymicEn;
        this.login = login;
        this.password = password;
    }

    public UserData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurnameUk() {
        return surnameUk;
    }

    public void setSurnameUk(String surnameUk) {
        this.surnameUk = surnameUk;
    }

    public String getSurnameEn() {
        return surnameEn;
    }

    public void setSurnameEn(String surnameEn) {
        this.surnameEn = surnameEn;
    }

    public String getNameUk() {
        return nameUk;
    }

    public void setNameUk(String nameUk) {
        this.nameUk = nameUk;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getPatronymicUk() {
        return patronymicUk;
    }

    public void setPatronymicUk(String patronymicUk) {
        this.patronymicUk = patronymicUk;
    }

    public String getPatronymicEn() {
        return patronymicEn;
    }

    public void setPatronymicEn(String patronymicEn) {
        this.patronymicEn = patronymicEn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}