package model.services;//package model.services;
//
//import JdbcFactoryDao;
//
//import java.util.ArrayList;
//
//public abstract class MedicalCardCreation implements AllCardsCreator {
//    public List<MedicalCard> createCard() {
//        List<MedicalCard> medicalCards = new ArrayList<>();
//
//        List<Patient> patients = new JdbcFactoryDao().getPatientJdbcDao().getAll();
//        List<Doctor> doctors = new JdbcFactoryDao().getDoctorJdbcDao().getAll();
//        List<Visit> visits = new JdbcFactoryDao().getVisitJdbcDao().getAll();
//
//        for (Patient patient : patients) {
//            MedicalCard medicalCard = new MedicalCard();
//
//            extractMedCardData(medicalCard, patient, doctors, visits);
//
//            medicalCards.add(medicalCard);
//        }
//        return medicalCards;
//    }
//
//    public abstract void extractMedCardData(MedicalCard medicalCard, Patient patient, List<Doctor> doctors, List<Visit> visits);
//}