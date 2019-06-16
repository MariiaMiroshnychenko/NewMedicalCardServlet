//package model.dao.implementation;
//
//import model.dao.PatientDao;
//import servlet.mapper.implementation.PatientMapper;
//import view.QueryConstants;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class PatientJdbcDao implements PatientDao {
//    private PatientMapper patientMapper = new PatientMapper();
//    private Map<Integer, Patient> patientMap = new HashMap<>();
//
//    public Connection connection;
//
//    public PatientJdbcDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public void close(){
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void create(Patient patient) {
//        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.ADD_PATIENT)) {
//            statement.setInt(1, patient.getPerson());
//            statement.setInt(2, patient.getMedicalCard());
//            statement.setInt(3, patient.getAttendingDoctor());
//
//            statement.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update() {
//
//    }
//
//    @Override
//    public Patient findMedicalCardForNewPatient() {
//        Patient patient = null;
//
//        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.GET_MEDICAL_CARD_NUMBER_FOR_NEW_PATIENT)) {
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                patient = patientMapper.extractFromResultSet(resultSet);
//            }
//
//            if (Objects.nonNull(patient)) {
//                patientMapper.makeUnique(patientMap, patient);
//            }
//
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return patient;
//    }
//}
