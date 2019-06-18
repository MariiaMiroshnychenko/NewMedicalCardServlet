package model.dao.mapper.implementation;

import model.dao.mapper.MainMapper;
import model.entity.Discharge;
import model.entity.Treatment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class DischargeMapper implements MainMapper<Discharge> {
    @Override
    public Discharge extractFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("d_id");
        Integer patientId = resultSet.getInt("patient_id");
        LocalDate beginDate = LocalDate.parse(resultSet.getString("begin_date"));
        LocalDate endDate = LocalDate.parse(resultSet.getString("end_date"));
        String finalDiagnosisUk = resultSet.getString("final_diagnosis_uk");
        String finalDiagnosisEn = resultSet.getString("final_diagnosis_en");
        Integer docId = resultSet.getInt("doc_id");


        return new Discharge(id, patientId, beginDate, endDate, finalDiagnosisUk, finalDiagnosisEn, docId);
    }

    @Override
    public Discharge makeUnique(Map<Integer, Discharge> cache, Discharge entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
