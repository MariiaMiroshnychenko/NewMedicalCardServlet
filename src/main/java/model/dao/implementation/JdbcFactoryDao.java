package model.dao.implementation;

import model.dao.ConnectionPool;
import model.dao.FactoryDao;
import model.dao.TreatmentDao;
import model.dao.UserDataDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcFactoryDao extends FactoryDao {
    private DataSource dataSource = ConnectionPool.getDataSource();

    @Override
    public UserDataDao getUserDataJdbcDao() {
        return new UserDataJdbcDao(getConnection());
    }

    @Override
    public TreatmentDao getTreatmentJdbcDao() {
        return new TreatmentJdbcDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}