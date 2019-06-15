package model.dao;

import model.dao.implementation.JdbcFactoryDao;
import model.entity.PersonalRegData;

import java.util.Optional;

public abstract class FactoryDao {
    private static Optional<FactoryDao> factory = Optional.empty();

//    public abstract EntityDao<ExamResultByReferral> getExamResultByReferralJdbcDao();
//    public abstract EntityDao<MedicalEmployee> getMedicalEmployeeJdbcDao();
//    public abstract EntityDao<Patient> getPatientJdbcDao();
//    public abstract EntityDao<PatientVisit> getPatientVisitJdbcDao();
    public abstract PersonalRegDataDao<PersonalRegData> getPersonalRegDataJdbcDao();
//    public abstract EntityDao<Referral> getReferralJdbcDao();
//    public abstract EntityDao<Role> getRoleJdbcDao();

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
