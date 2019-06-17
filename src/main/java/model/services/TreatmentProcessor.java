package model.services;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentProcessor {
    void addNewTreatment(Treatment treatment);
    List<Treatment> getTreatmentsByState(Boolean state);
}
