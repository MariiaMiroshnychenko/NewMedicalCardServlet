package com.medical.model.services.implementation;

import com.medical.model.dao.DischargeDao;
import com.medical.model.dao.FactoryDao;
import com.medical.model.entity.Discharge;
import com.medical.model.services.DischargeProcessor;

public class DischargeProcessorService implements DischargeProcessor {
    @Override
    public void addDischarge(Discharge discharge) {
        DischargeDao dischargeDao = FactoryDao.getInstance().getDischargeJdbcDao();
        dischargeDao.create(discharge);
        dischargeDao.close();
    }
}
