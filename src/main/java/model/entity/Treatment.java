package model.entity;

import java.time.LocalDate;

public class Treatment {
    private Integer id;
    private Integer patientId;
    private LocalDate date;
    private String diagnosisUk;
    private String diagnosisEn;
    private Integer assignment;
    private Integer docId;

    public Treatment(Integer id, Integer patientId, LocalDate date, String diagnosisUk,
                     String diagnosisEn, Integer assignment, Integer docId) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.diagnosisUk = diagnosisUk;
        this.diagnosisEn = diagnosisEn;
        this.assignment = assignment;
        this.docId = docId;
    }

    public Treatment(Integer patientId, LocalDate date, String diagnosisUk,
                     String diagnosisEn, Integer assignment, Integer docId) {
        this.patientId = patientId;
        this.date = date;
        this.diagnosisUk = diagnosisUk;
        this.diagnosisEn = diagnosisEn;
        this.assignment = assignment;
        this.docId = docId;
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

    public Integer getAssignment() {
        return assignment;
    }

    public void setAssignment(Integer assignment) {
        this.assignment = assignment;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }
}
