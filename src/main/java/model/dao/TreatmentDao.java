package model.dao;

import model.entity.Treatment;

import java.time.LocalDate;
import java.util.List;

public interface TreatmentDao extends GenericDao<Treatment> {
    Treatment findFirstPatientTreatment(Integer patientId);
    Treatment findPatientTreatmentDesc(Integer patientId);
    List<Treatment> findPatientTreatmentsByIdAndDates(Integer patientId, LocalDate beginDate, LocalDate endDate);
    List<Treatment> findAllTreatmentsByState(Boolean state);
    List<Treatment> findAllTreatmentsByTypesAndState(String firstType, String secondType, Boolean state);
    List<Treatment> findAllTreatmentByPatientId(Integer patientId);

    void updateTreatmentStateAndExecutor(Boolean state, Integer executorId, Integer id);
}
