package model.services.implementation;

import model.dao.FactoryDao;
import model.dao.TreatmentDao;
import model.entity.Treatment;
import model.services.TreatmentProcessor;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TreatmentProcessorService implements TreatmentProcessor {
    @Override
    public void addNewTreatment(Treatment treatment) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        treatmentDao.create(treatment);
        treatmentDao.close();
    }

    @Override
    public List<Treatment> getTreatmentsByState(Boolean state) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        List<Treatment> treatments = treatmentDao.findAllTreatmentsByState(state);

        treatmentDao.close();
        return treatments;
    }

    @Override
    public List<Treatment> getTreatmentsByTypesAndState(String firstType, String secondType, Boolean state) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        List<Treatment> treatments = treatmentDao.findAllTreatmentsByTypesAndState(firstType, secondType, state);

        treatmentDao.close();
        return treatments;
    }

    @Override
    public void updateTreatmentStateAndExecutorWithService(Boolean state, Integer executorId, Integer id) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        treatmentDao.updateTreatmentStateAndExecutor(state, executorId, id);
        treatmentDao.close();
    }

    @Override
    public List<Treatment> getTreatmentsByPatientIdAndDates(Integer patientId) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        List<Treatment> treatments = treatmentDao.findAllTreatmentByPatientId(patientId);
        treatmentDao.close();
        return treatments;
    }

    @Override
    public Treatment getFirstPatientTreatment(Integer patientId) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        Treatment treatment = treatmentDao.findFirstPatientTreatment(patientId);
        treatmentDao.close();
        return treatment;
    }

    @Override
    public Treatment getDecsPatientTreatment(Integer patientId) {
        TreatmentDao treatmentDao = FactoryDao.getInstance().getTreatmentJdbcDao();
        Treatment treatment = treatmentDao.findPatientTreatmentDesc(patientId);
        treatmentDao.close();
        return treatment;
    }
}
