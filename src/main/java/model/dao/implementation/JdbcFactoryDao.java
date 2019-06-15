package model.dao.implementation;

import model.dao.*;
import model.entity.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcFactoryDao extends FactoryDao {
    private DataSource dataSource = ConnectionPool.getDataSource();

//    @Override
//    public EntityDao<ExamResultByReferral> getExamResultByReferralJdbcDao() {
//        return new ExamResultByReferralJdbcDao(getConnection());
//    }

//    @Override
//    public EntityDao<MedicalEmployee> getMedicalEmployeeJdbcDao() {
//        return new MedicalEmployeeJdbcDao(getConnection());
//    }

//    @Override
//    public EntityDao<Patient> getPatientJdbcDao() {
//        return new PatientJdbcDao(getConnection());
//    }
//
//    @Override
//    public EntityDao<PatientVisit> getPatientVisitJdbcDao() {
//        return new PatientVisitJdbcDao(getConnection());
//    }
//
    @Override
    public PersonalRegDataDao<PersonalRegData> getPersonalRegDataJdbcDao() {
        return new PersonalRegDataJdbcDao(getConnection());
    }
//
//    @Override
//    public EntityDao<Referral> getReferralJdbcDao() {
//        return new ReferralJdbcDao(getConnection());
//    }
//
//    @Override
//    public EntityDao<Role> getRoleJdbcDao() {
//        return new RoleJdbcDao(getConnection());
//    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}