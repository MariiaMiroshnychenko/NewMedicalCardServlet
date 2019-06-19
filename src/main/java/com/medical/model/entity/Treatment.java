package com.medical.model.entity;

import java.time.LocalDate;

public class Treatment {
    private Integer id;
    private Integer patientId;
    private LocalDate date;
    private String diagnosisUk;
    private String diagnosisEn;
    private String appointmentTypeUk;
    private String appointmentTypeEn;
    private Integer docId;
    private Boolean state;
    private Integer executor;

    public Treatment(Integer id, Integer patientId, LocalDate date, String diagnosisUk,
                     String diagnosisEn, String appointmentTypeUk, String appointmentTypeEn,
                     Integer docId, Boolean state, Integer executor) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.diagnosisUk = diagnosisUk;
        this.diagnosisEn = diagnosisEn;
        this.appointmentTypeUk = appointmentTypeUk;
        this.appointmentTypeEn = appointmentTypeEn;
        this.docId = docId;
        this.state = state;
        this.executor = executor;
    }

    public Treatment(Integer patientId, LocalDate date, String diagnosisUk,
                     String diagnosisEn, String appointmentTypeUk,
                     String appointmentTypeEn, Integer docId, Boolean state) {
        this.patientId = patientId;
        this.date = date;
        this.diagnosisUk = diagnosisUk;
        this.diagnosisEn = diagnosisEn;
        this.appointmentTypeUk = appointmentTypeUk;
        this.appointmentTypeEn = appointmentTypeEn;
        this.docId = docId;
        this.state = state;
    }

    public Treatment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiagnosisUk() {
        return diagnosisUk;
    }

    public void setDiagnosisUk(String diagnosisUk) {
        this.diagnosisUk = diagnosisUk;
    }

    public String getDiagnosisEn() {
        return diagnosisEn;
    }

    public void setDiagnosisEn(String diagnosisEn) {
        this.diagnosisEn = diagnosisEn;
    }

    public String getAppointmentTypeUk() {
        return appointmentTypeUk;
    }

    public void setAppointmentTypeUk(String appointmentTypeUk) {
        this.appointmentTypeUk = appointmentTypeUk;
    }

    public String getAppointmentTypeEn() {
        return appointmentTypeEn;
    }

    public void setAppointmentTypeEn(String appointmentTypeEn) {
        this.appointmentTypeEn = appointmentTypeEn;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getExecutor() {
        return executor;
    }

    public void setExecutor(Integer executor) {
        this.executor = executor;
    }
}
