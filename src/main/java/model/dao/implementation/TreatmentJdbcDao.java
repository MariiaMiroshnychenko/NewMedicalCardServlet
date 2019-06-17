package model.dao.implementation;

import model.dao.TreatmentDao;
import model.dao.mapper.implementation.TreatmentMapper;
import model.entity.Treatment;
import constants.QueryConstants;
import model.entity.UserData;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreatmentJdbcDao implements TreatmentDao {
    private TreatmentMapper treatmentMapper = new TreatmentMapper();
    private Map<Integer, Treatment> treatmentMap = new HashMap<>();

    public Connection connection;

    public TreatmentJdbcDao(Connection connection) {
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
    public void create(Treatment treatment) {
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.ADD_TREATMENT)) {
            statement.setInt(1, treatment.getPatientId());
            statement.setDate(2, Date.valueOf(treatment.getDate()));
            statement.setString(3, treatment.getDiagnosisUk());
            statement.setString(4, treatment.getDiagnosisEn());
            statement.setString(5, treatment.getAppointmentTypeUk());
            statement.setString(6, treatment.getAppointmentTypeEn());
            statement.setInt (7, treatment.getDocId());
            statement.setBoolean(8, treatment.getState());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Treatment> findAllTreatmentsByState(Boolean state) {
        List<Treatment> treatments = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREATMENTS_BY_STATE)) {
            statement.setBoolean(1, state);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Treatment treatment = treatmentMapper.extractFromResultSet(resultSet);

                treatmentMapper.makeUnique(treatmentMap, treatment);
            }
            resultSet.close();

            treatments = new ArrayList<>(treatmentMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatments;
    }

    @Override
    public void update() {

    }
}
