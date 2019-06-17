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
        return treatmentDao.findAllTreatmentsByState(state);
    }
}
