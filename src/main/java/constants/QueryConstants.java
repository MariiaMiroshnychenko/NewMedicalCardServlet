package constants;

public interface QueryConstants {
    String TREATMENTS_BY_STATE = "SELECT * FROM treatment WHERE state=?";
    String TREATMENTS_BY_TYPES_AND_STATE = "SELECT * FROM treatment WHERE assignment_type_en=? OR assignment_type_en=? AND state=?";
    String UPDATE_TREATMENT_STATE_AND_EXECUTOR = "UPDATE treatment AS t SET t.state=?, t.doc_executor=? WHERE t.t_id=?";

    String USER_DATA_BY_ROLE_TITLE = "SELECT * FROM user_data where role=?";
    String USER_DATA_BY_LOGIN = "SELECT * FROM user_data WHERE login=?";
    String USER_DATA_BY_ID = "SELECT * FROM user_data WHERE id=?";

    String REGISTER_PERSON = "INSERT INTO user_data" +
            "(surname_uk, surname_en, name_uk, name_en, patronymic_uk, patronymic_en, " +
            "login, `password`, `role`, photo) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String ADD_TREATMENT = "INSERT INTO treatment(patient_id, t_date, " +
            "diagnosis_uk, diagnosis_en, assignment_type_uk, assignment_type_en, " +
            "doc_id, state) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    String ADD_DISCHARGE = "INSERT INTO discharge(patient_id, begin_date, end_date, final_diagnosis_uk, " +
            "final_diagnosis_en, doc_id) VALUES (?, ?, ?, ?, ?, ?)";
    String DISCHARGES_BY_PATIENT_ID = "select * from discharge where patient_id=?";

}
