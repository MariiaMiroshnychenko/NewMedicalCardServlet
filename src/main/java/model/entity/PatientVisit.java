//package model.entity;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class PatientVisit {
//    private Integer id;
//    private Referral idReferralToDoctor;
//    private Patient patientId;
//    private LocalDateTime visitDate;
//    private String diagnosis;
//    private String appType;
//    private String appointment;
//    private boolean appState;
//    private MedicalEmployee doctorId;
//    private Integer executedByMedId;
//
//    public PatientVisit(Integer id, Referral idReferralToDoctor,
//                        Patient patientId, LocalDateTime visitDate,
//                        String diagnosis, String appType, String appointment,
//                        boolean appState, MedicalEmployee doctorId, Integer executedByMedId) {
//        this.id = id;
//        this.idReferralToDoctor = idReferralToDoctor;
//        this.patientId = patientId;
//        this.visitDate = visitDate;
//        this.diagnosis = diagnosis;
//        this.appType = appType;
//        this.appointment = appointment;
//        this.appState = appState;
//        this.doctorId = doctorId;
//        this.executedByMedId = executedByMedId;
//    }
//
//    public PatientVisit() {
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
//    public Referral getIdReferralToDoctor() {
//        return idReferralToDoctor;
//    }
//
//    public void setIdReferralToDoctor(Referral idReferralToDoctor) {
//        this.idReferralToDoctor = idReferralToDoctor;
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
//    public LocalDateTime getVisitDate() {
//        return visitDate;
//    }
//
//    public void setVisitDate(LocalDateTime visitDate) {
//        this.visitDate = visitDate;
//    }
//
//    public String getDiagnosis() {
//        return diagnosis;
//    }
//
//    public void setDiagnosis(String diagnosis) {
//        this.diagnosis = diagnosis;
//    }
//
//    public String getAppType() {
//        return appType;
//    }
//
//    public void setAppType(String appType) {
//        this.appType = appType;
//    }
//
//    public String getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(String appointment) {
//        this.appointment = appointment;
//    }
//
//    public boolean isAppState() {
//        return appState;
//    }
//
//    public void setAppState(boolean appState) {
//        this.appState = appState;
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
//    public Integer getExecutedByMedId() {
//        return executedByMedId;
//    }
//
//    public void setExecutedByMedId(Integer executedByMedId) {
//        this.executedByMedId = executedByMedId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PatientVisit that = (PatientVisit) o;
//        return appState == that.appState &&
//                Objects.equals(id, that.id) &&
//                Objects.equals(idReferralToDoctor, that.idReferralToDoctor) &&
//                Objects.equals(patientId, that.patientId) &&
//                Objects.equals(visitDate, that.visitDate) &&
//                Objects.equals(diagnosis, that.diagnosis) &&
//                Objects.equals(appType, that.appType) &&
//                Objects.equals(appointment, that.appointment) &&
//                Objects.equals(doctorId, that.doctorId) &&
//                Objects.equals(executedByMedId, that.executedByMedId);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, idReferralToDoctor, patientId, visitDate, diagnosis, appType, appointment, appState, doctorId, executedByMedId);
//    }
//}
