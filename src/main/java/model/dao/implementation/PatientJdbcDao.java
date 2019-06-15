package model.dao.implementation;//package model.dao.implementation;
//
//import model.dao.EntityDao;
//import model.entity.Patient;
//import view.QueryConstants;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//
//public class PatientJdbcDao extends EntityDao<Patient> implements QueryConstants {
//    public PatientJdbcDao(Connection connection) {
//        super(connection);
//    }
//
//    @Override
//    public String getQuery() {
//        return null;//SELECT_FROM_PATIENT;
//    }
//
//    @Override
//    public Patient extractEntityData(ResultSet results) {
//        Patient patient = new Patient();
//
//        try {
//            patient.setPatientId(results.getInt(1));
//            patient.setSurname(results.getString(2));
//            patient.setFirstName(results.getString(3));
//            patient.setSecondName(results.getString(4));
//            patient.setMedCardId(results.getInt(5));
//            patient.setDoctorId(results.getInt(6));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
