package model.services.implementation;

//public class AvailableMedCards extends MedicalCardCreation {
//    @Override
//    public void extractMedCardData(MedicalCard medicalCard, Patient patient, List<Doctor> doctors, List<Visit> visits) {
//        medicalCard.setPatient(patient);
//        medicalCard.setDoctor(createDoctor(doctors, medicalCard.getPatient()));
//        medicalCard.setVisits(createVisit(visits, medicalCard.getPatient()));
//
//    }
//
//    @Override
//    public Doctor createDoctor(List<Doctor> doctors, Patient patient) {
//        return doctors
//                .stream()
//                .filter(d -> d.getDoctorId() == patient.getDoctorId())
//                .findFirst()
//                .get();
//    }
//
//    @Override
//    public List<Visit> createVisit(List<Visit> visits, Patient patient) {
//        return visits
//                .stream()
//                .filter(v -> v.getMedicalCardId() == patient.getMedCardId())
//                .collect(Collectors.toList());
//    }
//}
