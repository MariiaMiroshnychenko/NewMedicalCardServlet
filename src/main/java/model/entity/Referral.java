package model.entity;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class Referral {
//    private Integer id;
//    private String refType;
//    private String actTitle;
//    private LocalDateTime refDate;
//    private Patient patientId;
//    private MedicalEmployee doctorId;
//    private ExamResultByReferral examResultId;
//    private PatientVisit patientVisit;
//
//    public Referral(Integer id, String refType, String actTitle,
//                    LocalDateTime refDate, Patient patientId,
//                    MedicalEmployee doctorId, ExamResultByReferral examResultId,
//                    PatientVisit patientVisit) {
//        this.id = id;
//        this.refType = refType;
//        this.actTitle = actTitle;
//        this.refDate = refDate;
//        this.patientId = patientId;
//        this.doctorId = doctorId;
//        this.examResultId = examResultId;
//        this.patientVisit = patientVisit;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getRefType() {
//        return refType;
//    }
//
//    public void setRefType(String refType) {
//        this.refType = refType;
//    }
//
//    public String getActTitle() {
//        return actTitle;
//    }
//
//    public void setActTitle(String actTitle) {
//        this.actTitle = actTitle;
//    }
//
//    public LocalDateTime getRefDate() {
//        return refDate;
//    }
//
//    public void setRefDate(LocalDateTime refDate) {
//        this.refDate = refDate;
//    }
//
//    public Patient getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Patient patientId) {
//        this.patientId = patientId;
//    }
//
//    public MedicalEmployee getDoctorId() {
//        return doctorId;
//    }
//
//    public void setDoctorId(MedicalEmployee doctorId) {
//        this.doctorId = doctorId;
//    }
//
//    public ExamResultByReferral getExamResultId() {
//        return examResultId;
//    }
//
//    public void setExamResultId(ExamResultByReferral examResultId) {
//        this.examResultId = examResultId;
//    }
//
//    public PatientVisit getPatientVisit() {
//        return patientVisit;
//    }
//
//    public void setPatientVisit(PatientVisit patientVisit) {
//        this.patientVisit = patientVisit;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Referral referral = (Referral) o;
//        return Objects.equals(id, referral.id) &&
//                Objects.equals(refType, referral.refType) &&
//                Objects.equals(actTitle, referral.actTitle) &&
//                Objects.equals(refDate, referral.refDate) &&
//                Objects.equals(patientId, referral.patientId) &&
//                Objects.equals(doctorId, referral.doctorId) &&
//                Objects.equals(examResultId, referral.examResultId) &&
//                Objects.equals(patientVisit, referral.patientVisit);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, refType, actTitle, refDate, patientId,
//                doctorId, examResultId, patientVisit);
//    }
//}
