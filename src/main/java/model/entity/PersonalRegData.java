package model.entity;

import java.sql.Date;
import java.util.Objects;

public class PersonalRegData {
    private Integer id;

    private String surname;
    private String name;
    private String patronymic;

    private Date birthDate;
    private String passSeries;
    private String passNumber;
    private String identCode;

    private String phone;
    private String email;
    private String login;
    private String password;
    private Integer roleId;

    private boolean enabled;
    private String photo;

//    private MedicalEmployee medicalEmployee;
//    private Patient patient;
    private Role role;

//    public PersonalRegData(Integer id, String surname, String name, String patronymic, Date birthDate,
//                           String passSeries, String passNumber, String identCode, String phone,
//                           String email, String login, String password, Integer roleId, boolean enabled,
//                           String photo, MedicalEmployee medicalEmployee, Patient patient, Role role) {
//        this.id = id;
//        this.surname = surname;
//        this.name = name;
//        this.patronymic = patronymic;
//        this.birthDate = birthDate;
//        this.passSeries = passSeries;
//        this.passNumber = passNumber;
//        this.identCode = identCode;
//        this.phone = phone;
//        this.email = email;
//        this.login = login;
//        this.password = password;
//        this.roleId = roleId;
//        this.enabled = enabled;
//        this.photo = photo;
//        this.medicalEmployee = medicalEmployee;
//        this.patient = patient;
//        this.role = role;
//    }

    public PersonalRegData(Integer id, String surname, String name,
                           String patronymic, Date birthDate, String passSeries,
                           String passNumber, String identCode, String phone,
                           String email, String login, String password,
                           Integer roleId, boolean enabled, String photo) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passSeries = passSeries;
        this.passNumber = passNumber;
        this.identCode = identCode;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.enabled = enabled;
        this.photo = photo;
    }

    public PersonalRegData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassSeries() {
        return passSeries;
    }

    public void setPassSeries(String passSeries) {
        this.passSeries = passSeries;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public String getIdentCode() {
        return identCode;
    }

    public void setIdentCode(String identCode) {
        this.identCode = identCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    public MedicalEmployee getMedicalEmployee() {
//        return medicalEmployee;
//    }

//    public void setMedicalEmployee(MedicalEmployee medicalEmployee) {
//        this.medicalEmployee = medicalEmployee;
//    }

//    public Patient getPatient() {
//        return patient;
//    }

//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalRegData that = (PersonalRegData) o;
        return enabled == that.enabled &&
                Objects.equals(id, that.id) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(passSeries, that.passSeries) &&
                Objects.equals(passNumber, that.passNumber) &&
                Objects.equals(identCode, that.identCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(photo, that.photo) &&
//                Objects.equals(medicalEmployee, that.medicalEmployee) &&
//                Objects.equals(patient, that.patient) &&
                Objects.equals(role, that.role);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, surname, name, patronymic, birthDate, passSeries,
//                passNumber, identCode, phone, email, login, password, roleId,
//                enabled, photo, medicalEmployee, patient, role);
//    }
}
