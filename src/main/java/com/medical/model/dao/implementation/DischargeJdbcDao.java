package com.medical.model.dao.implementation;

import com.medical.constants.QueryConstant;
import com.medical.model.dao.DischargeDao;
import com.medical.model.entity.Discharge;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DischargeJdbcDao implements DischargeDao {
    public Connection connection;

    public DischargeJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Discharge discharge) {
        try (PreparedStatement statement = connection.prepareStatement(QueryConstant.ADD_DISCHARGE)) {
            statement.setInt(1, discharge.getPatientId());
            statement.setDate(2, Date.valueOf(discharge.getBeginDate()));
            statement.setDate(3, Date.valueOf(discharge.getEndDate()));
            statement.setString(4, discharge.getFinalDiagnosisUk());
            statement.setString(5, discharge.getFinalDiagnosisEn());
            statement.setInt (6, discharge.getDoctorId());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object field, Integer id, String query) {

    }
}
