package model.dao.implementation;

import model.dao.TreatmentDao;
import model.dao.mapper.implementation.TreatmentMapper;
import model.entity.Treatment;
import constants.QueryConstants;
import model.entity.UserData;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

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

    private List<Treatment> allTreatmentsByOneField(Object field, String query) {
        List<Treatment> treatments = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, field);

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
    public List<Treatment> findAllTreatmentsByState(Boolean state) {
        return allTreatmentsByOneField(state, QueryConstants.TREATMENTS_BY_STATE);
    }

    @Override
    public List<Treatment> findAllTreatmentByPatientId(Integer patientId) {
        return allTreatmentsByOneField(patientId, QueryConstants.TREATMENTS_BY_PATIENT_ID);
    }

    @Override
    public List<Treatment> findAllTreatmentsByTypesAndState(String firstType, String secondType, Boolean state) {
        List<Treatment> treatments = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREATMENTS_BY_TYPES_AND_STATE)) {
            statement.setString(1, firstType);
            statement.setString(2, secondType);
            statement.setBoolean(3, state);

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
    public List<Treatment> findPatientTreatmentsByIdAndDates(Integer patientId, LocalDate beginDate, LocalDate endDate) {
        List<Treatment> treatments = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREATMENT_IN_DATE_BETWEEN)) {
            statement.setInt(1, patientId);
            statement.setDate(2, Date.valueOf(beginDate));
            statement.setDate(3, Date.valueOf(endDate));

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
    public void update(Object field, Integer id, String query) {
    }

    @Override
    public void updateTreatmentStateAndExecutor(Boolean state, Integer executorId, Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.UPDATE_TREATMENT_STATE_AND_EXECUTOR)) {
            statement.setBoolean(1, state);
            statement.setInt(2, executorId);
            statement.setInt(3, id);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Treatment findTreatmentForPatient(Integer patientId, String query) {
        Treatment treatment = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                treatment = treatmentMapper.extractFromResultSet(resultSet);
            }
            if (Objects.nonNull(treatment)) {
                treatmentMapper.makeUnique(treatmentMap, treatment);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatment;
    }
    @Override
    public Treatment findFirstPatientTreatment(Integer patientId) {
        return findTreatmentForPatient(patientId, QueryConstants.FIRST_TREATMENT);
    }

    @Override
    public Treatment findPatientTreatmentDesc(Integer patientId) {
        return findTreatmentForPatient(patientId, QueryConstants.TREATMENT_DESC_LIMIT);
    }
}
