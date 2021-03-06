package com.medical.model.dao;

import com.medical.model.dao.implementation.JdbcFactoryDao;

import java.util.Optional;

public abstract class FactoryDao {
    private static Optional<FactoryDao> factory = Optional.empty();

    public abstract UserDataDao getUserDataJdbcDao();
    public abstract TreatmentDao getTreatmentJdbcDao();
    public abstract DischargeDao getDischargeJdbcDao();

    public static FactoryDao getInstance() {
        if (!factory.isPresent()) {
            synchronized (FactoryDao.class) {
                if (!factory.isPresent()) {
                    factory = Optional.of(new JdbcFactoryDao());
                }
            }
        }
        return factory.get();
    }

}
