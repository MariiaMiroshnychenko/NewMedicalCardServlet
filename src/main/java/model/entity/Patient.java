//package model.entity;
//
//import java.util.List;
//import java.util.Objects;
//
//public class Patient {
//    private Integer id;
//    private PersonalRegData person;
////    private MedicalCard medicalCard;
//    private MedicalEmployee attendingDoctor;
//    private List<PatientVisit> patientVisits;
//    private List<Referral> referrals;
//
//    public Patient(Integer id, PersonalRegData person, MedicalCard medicalCard,
//                   MedicalEmployee attendingDoctor, List<PatientVisit> patientVisits,
//                   List<Referral> referrals) {
//        this.id = id;
//        this.person = person;
//        this.medicalCard = medicalCard;
//        this.attendingDoctor = attendingDoctor;
//        this.patientVisits = patientVisits;
//        this.referrals = referrals;
//    }
//
//    public Patient() {
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
//    public PersonalRegData getPerson() {
//        return person;
//    }
//
//    public void setPerson(PersonalRegData person) {
//        this.person = person;
//    }
//
//    public MedicalCard getMedicalCard() {
//        return medicalCard;
//    }
//
//    public void setMedicalCard(MedicalCard medicalCard) {
//        this.medicalCard = medicalCard;
//    }
//
//    public MedicalEmployee getAttendingDoctor() {
//        return attendingDoctor;
//    }
//
//    public void setAttendingDoctor(MedicalEmployee attendingDoctor) {
//        this.attendingDoctor = attendingDoctor;
//    }
//
//    public List<PatientVisit> getPatientVisits() {
//        return patientVisits;
//    }
//
//    public void setPatientVisits(List<PatientVisit> patientVisits) {
//        this.patientVisits = patientVisits;
//    }
//
//    public List<Referral> getReferrals() {
//        return referrals;
//    }
//
//    public void setReferrals(List<Referral> referrals) {
//        this.referrals = referrals;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Patient patient = (Patient) o;
//        return Objects.equals(id, patient.id) &&
//                Objects.equals(person, patient.person) &&
//                Objects.equals(medicalCard, patient.medicalCard) &&
//                Objects.equals(attendingDoctor, patient.attendingDoctor) &&
//                Objects.equals(patientVisits, patient.patientVisits) &&
//                Objects.equals(referrals, patient.referrals);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, person, medicalCard, attendingDoctor, patientVisits, referrals);
//    }
//}
