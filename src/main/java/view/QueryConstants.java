package view;

public interface QueryConstants {
    String FIND_ALL_BY_REF_TYPE_AND_PATIENT_ID = "SELECT * FROM exam_result_by_referral " +
            "LEFT JOIN referral ON exam_result_by_referral.ref_id = referral.id " +
            "WHERE referral.ref_type=? AND referral.patient_id=?";
    String MEDICAL_EMPLOYEE_BY_PERSON = "SELECT * FROM medical_employee WHERE person_id=?";

    String PATIENT_BY_PERSONAL_REG_DATA = "SELECT * FROM patient WHERE person_id=?";
    String PATIENT_BY_REFERRAL = "SELECT * FROM patient INNER JOIN referral on patient.patient_id = referral.patient_id\n" +
            " where referral.id =?";
    String PATIENT_BY_MEDICAL_CARD_ID = "SELECT * FROM patient WHERE medical_card_id=?";
    String GET_MEDICAL_CARD_NUMBER_FOR_NEW_PATIENT = "SELECT * from patient ORDER BY patient_id DESC LIMIT 1";
    String PATIENT_BY_ID = "SELECT * FROM patient WHERE patient_id=?";
    String UPDATE_PATIENT_SET_ATTENDING_DOCTOR_FOR_PERSON_ID = "UPDATE patient p SET p.attending_doctor_id = ? " +
            "WHERE p.person_id = ?";
    String PATIENT_VISIT_BY_ID = "SELECT * FROM patient_visit WHERE patient_id=?";
    String PATIENT_VISITS_BY_DOCTOR_ID_AND_APP_TYPE_AND_APP_STATE = "SELECT * FROM patient_visit where doctor_id=? " +
            "AND app_type=? AND app_state=true";
    String PATIENT_VISITS_BY_APP_TYPE_AND_APP_STATE = "SELECT * FROM patient_visit where app_type=? AND app_state=true";
    String UPDATE_PATIENT_VISIT_SET_APP_STATE_FOR_ID = "UPDATE patient_visit pv SET app_state=? WHERE id=?";
    String UPDATE_PATIENT_VISIT_SET_EXECUTED_BY_PERSON_FOR_ID = "UPDATE patient_visit pv SET resp_med_employee=? WHERE id=?";
    String ALL_FROM_PERSONAL_REG_DATA_BY_ROLE_ID_TITLE = "SELECT * FROM personal_reg_data " +
            "INNER JOIN `role` ON personal_reg_data.`role` = `role`.role_id where title=?";
    String ALL_FROM_PERSONAL_REG_DATA_BY_PATIENT_ATTENDING_DOCTOR = "SELECT * FROM personal_reg_data " +
            "INNER JOIN patient ON personal_reg_data.person_id = patient.person_id where attending_doctor_id=?";
    String ALL_FROM_PERSONAL_REG_DATA_BY_SURNAME_NAME_PATRONYMIC = "SELECT * FROM personal_reg_data " +
            "WHERE surname=? AND name=? AND patronymic=?";
    String USER_DATA_BY_ROLE_TITLE = "SELECT * FROM user_data where role=?";
    String USER_DATA_BY_LOGIN = "SELECT * FROM user_data WHERE login=?";
    String USER_DATA_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user_data WHERE login=? AND password=?";
    String ROLE_BY_LOGIN_AND_PASSWORD = "SELECT `role`.role_id, `role`.title, `role`.code FROM personal_reg_data JOIN `role`" +
            " ON personal_reg_data.`role` = `role`.role_id WHERE personal_reg_data.login=? AND" +
            " personal_reg_data.`password`=?";

    String REGISTER_PERSON = "INSERT INTO user_data" +
            "(surname_uk, surname_en, name_uk, name_en, patronymic_uk, patronymic_en, " +
            "login, `password`, `role`, photo) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
