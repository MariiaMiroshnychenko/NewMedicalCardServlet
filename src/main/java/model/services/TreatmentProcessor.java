package model.services;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentProcessor {
    void addNewTreatment(Treatment treatment);
    List<Treatment> getTreatmentsByState(Boolean state);
    List<Treatment> getTreatmentsByTypesAndState(String firstType, String secondType, Boolean state);
    void updateTreatmentStateAndExecutorWithService(Boolean state, Integer executorId, Integer id);
}
