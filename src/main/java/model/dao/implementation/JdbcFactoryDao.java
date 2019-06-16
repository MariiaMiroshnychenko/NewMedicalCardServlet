package model.dao.implementation;

import model.dao.*;

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
//    public EntityDao<PatientVisit> getPatientVisitJdbcDao() {
//        return new PatientVisitJdbcDao(getConnection());
//    }
//
    @Override
    public UserDataDao getUserDataJdbcDao() {
        return new UserDataJdbcDao(getConnection());
    }

    //
//    @Override
//    public EntityDao<Referral> getReferralJdbcDao() {
//        return new ReferralJdbcDao(getConnection());
//    }
//

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}