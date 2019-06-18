package model.dao;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentDao extends GenericDao<Treatment> {
    List<Treatment> findAllTreatmentsByState(Boolean state);
    List<Treatment> findAllTreatmentsByTypesAndState(String firstType, String secondType, Boolean state);

    void updateTreatmentStateAndExecutor(Boolean state, Integer executorId, Integer id);
}
