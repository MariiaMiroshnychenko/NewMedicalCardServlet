package model.dao.mapper.implementation;

import model.dao.mapper.MainMapper;
import model.entity.Treatment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class TreatmentMapper implements MainMapper<Treatment> {
    @Override
    public Treatment extractFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("t_id");
        Integer patientId = resultSet.getInt("patient_id");
        LocalDate date = LocalDate.parse(resultSet.getString("t_date"));
        String diagnosisUk = resultSet.getString("diagnosis_uk");
        String diagnosisEn = resultSet.getString("diagnosis_en");
        String assignmentUk = resultSet.getString("assignment_type_uk");
        String assignmentEn = resultSet.getString("assignment_type_en");
        Integer docId = resultSet.getInt("doc_id");
        Boolean state = resultSet.getBoolean("state");
        Integer docExecutor = resultSet.getInt("doc_executor");


        return new Treatment(id, patientId, date, diagnosisUk, diagnosisEn,
                assignmentUk, assignmentEn, docId, state, docExecutor);
    }

    @Override
    public Treatment makeUnique(Map<Integer, Treatment> cache, Treatment entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
