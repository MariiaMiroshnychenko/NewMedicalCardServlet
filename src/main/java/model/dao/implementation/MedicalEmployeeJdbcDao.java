//package model.dao.implementation;//package model.dao.implementation;
//
//import model.dao.MedicalEmployeeDao;
//import servlet.mapper.implementation.MedicalEmployeeMapper;
//import view.QueryConstants;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MedicalEmployeeJdbcDao implements MedicalEmployeeDao {
//    private MedicalEmployeeMapper medicalEmployeeMapper = new MedicalEmployeeMapper();
//    private Map<Integer, MedicalEmployee> medicalEmployeeMap = new HashMap<>();
//
//    public Connection connection;
//
//    public MedicalEmployeeJdbcDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public void close() {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void create(MedicalEmployee medicalEmployee) {
//        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.ADD_MEDICAL_EMPLOYEE)) {
//            statement.setInt(1, medicalEmployee.getPerson().getId());
//            statement.setString(2, medicalEmployee.getSpeciality());
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
//    public List<MedicalEmployee> findMedicalEmployeesByRole(String role) {
//        List<MedicalEmployee> resultList = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.MEDICAL_EMPLOYEES_BY_ROLE_TITLE)) {
//            statement.setString(1, role);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while(resultSet.next()) {
//               MedicalEmployee medicalEmployee = medicalEmployeeMapper.extractFromResultSet(resultSet);
//                medicalEmployeeMapper.makeUnique(medicalEmployeeMap, medicalEmployee);
//            }
//            resultSet.close();
//
//            resultList.addAll(medicalEmployeeMap.values());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultList;
//    }
//}
