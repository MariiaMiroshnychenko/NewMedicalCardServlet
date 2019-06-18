package model.services;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentProcessor {
    Treatment getFirstPatientTreatment(Integer patientId);
    Treatment getDecsPatientTreatment(Integer patientId);

    List<Treatment> getTreatmentsByState(Boolean state);
    List<Treatment> getTreatmentsByTypesAndState(String firstType, String secondType, Boolean state);
    List<Treatment> getTreatmentsByPatientIdAndDates(Integer patientId);

    void addNewTreatment(Treatment treatment);
    void updateTreatmentStateAndExecutorWithService(Boolean state, Integer executorId, Integer id);
}
