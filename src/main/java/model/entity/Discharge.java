package model.entity;

import java.time.LocalDate;

public class Discharge {
    private Integer id;
    private Integer patientId;
    private LocalDate beginDate;
    private Integer endDate;
    private String finalDiagnosisUk;
    private String finalDiagnosisEn;
    private Integer doctorId;

    public Discharge(Integer id, Integer patientId, LocalDate beginDate,
                     Integer endDate, String finalDiagnosisUk, String finalDiagnosisEn, Integer doctorId) {
        this.id = id;
        this.patientId = patientId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.finalDiagnosisUk = finalDiagnosisUk;
        this.finalDiagnosisEn = finalDiagnosisEn;
        this.doctorId = doctorId;
    }

    public Discharge(Integer patientId, LocalDate beginDate, Integer endDate,
                     String finalDiagnosisUk, String finalDiagnosisEn, Integer doctorId) {
        this.patientId = patientId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.finalDiagnosisUk = finalDiagnosisUk;
        this.finalDiagnosisEn = finalDiagnosisEn;
        this.doctorId = doctorId;
    }

    public Discharge() {
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

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getFinalDiagnosisUk() {
        return finalDiagnosisUk;
    }

    public void setFinalDiagnosisUk(String finalDiagnosisUk) {
        this.finalDiagnosisUk = finalDiagnosisUk;
    }

    public String getFinalDiagnosisEn() {
        return finalDiagnosisEn;
    }

    public void setFinalDiagnosisEn(String finalDiagnosisEn) {
        this.finalDiagnosisEn = finalDiagnosisEn;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
}
