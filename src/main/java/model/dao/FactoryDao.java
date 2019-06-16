package model.dao;

import model.dao.implementation.JdbcFactoryDao;

import java.util.Optional;

public abstract class FactoryDao {
    private static Optional<FactoryDao> factory = Optional.empty();

//    public abstract EntityDao<ExamResultByReferral> getExamResultByReferralJdbcDao();
//    public abstract EntityDao<PatientVisit> getPatientVisitJdbcDao();
    public abstract UserDataDao getUserDataJdbcDao();
//    public abstract EntityDao<Referral> getReferralJdbcDao();

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
