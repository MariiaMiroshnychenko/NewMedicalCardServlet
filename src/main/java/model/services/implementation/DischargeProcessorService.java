package model.services.implementation;

import model.dao.DischargeDao;
import model.dao.FactoryDao;
import model.entity.Discharge;
import model.services.DischargeProcessor;

public class DischargeProcessorService implements DischargeProcessor {
    @Override
    public void addDischarge(Discharge discharge) {
        DischargeDao dischargeDao = FactoryDao.getInstance().getDischargeJdbcDao();
        dischargeDao.create(discharge);
        dischargeDao.close();
    }
}
