//package model.entity;
//
//import java.util.List;
//import java.util.Objects;
//
//public class MedicalEmployee {
//    private Integer medId;
//    private PersonalRegData person;
//    private String speciality;
//    private List<Patient> patients;
//    private List<PatientVisit> patientVisit;
//    private ExamResultByReferral respDoctor;
//    private List<Referral> referral;
//
//    public MedicalEmployee(Integer medId, PersonalRegData person, String speciality,
//                           List<Patient> patients, List<PatientVisit> patientVisit,
//                           ExamResultByReferral respDoctor, List<Referral> referral) {
//        this.medId = medId;
//        this.person = person;
//        this.speciality = speciality;
//        this.patients = patients;
//        this.patientVisit = patientVisit;
//        this.respDoctor = respDoctor;
//        this.referral = referral;
//    }
//
//    public MedicalEmployee() {
//    }
//
//    public Integer getMedId() {
//        return medId;
//    }
//
//    public void setMedId(Integer medId) {
//        this.medId = medId;
//    }
//
//    public PersonalRegData getPerson() {
//        return person;
//    }
//
//    public void setPerson(PersonalRegData person) {
//        this.person = person;
//    }
//
//    public String getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(String speciality) {
//        this.speciality = speciality;
//    }
//
//    public List<Patient> getPatients() {
//        return patients;
//    }
//
//    public void setPatients(List<Patient> patients) {
//        this.patients = patients;
//    }
//
//    public List<PatientVisit> getPatientVisit() {
//        return patientVisit;
//    }
//
//    public void setPatientVisit(List<PatientVisit> patientVisit) {
//        this.patientVisit = patientVisit;
//    }
//
//    public ExamResultByReferral getRespDoctor() {
//        return respDoctor;
//    }
//
//    public void setRespDoctor(ExamResultByReferral respDoctor) {
//        this.respDoctor = respDoctor;
//    }
//
//    public List<Referral> getReferral() {
//        return referral;
//    }
//
//    public void setReferral(List<Referral> referral) {
//        this.referral = referral;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MedicalEmployee that = (MedicalEmployee) o;
//        return Objects.equals(medId, that.medId) &&
//                Objects.equals(person, that.person) &&
//                Objects.equals(speciality, that.speciality) &&
//                Objects.equals(patients, that.patients) &&
//                Objects.equals(patientVisit, that.patientVisit) &&
//                Objects.equals(respDoctor, that.respDoctor) &&
//                Objects.equals(referral, that.referral);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(medId, person, speciality, patients, patientVisit, respDoctor, referral);
//    }
//}
