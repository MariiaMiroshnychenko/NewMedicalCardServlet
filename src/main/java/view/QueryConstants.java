package view;

public interface QueryConstants {
    String SELECT_FROM_VISIT = "select * from visit";
    String SELECT_FROM_PATIENT = "select * from patient";
    String SELECT_FROM_PATIENT_DOCTOR = "select * from patient_doctor_link";
    String SELECT_FROM_DOCTOR = "select * from doctor";

    String SELECT = "SELECT patient.p_id, patient.p_surname,\n" +
            "       patient.p_first_name, patient.p_second_name,\n" +
            "       patient.med_card_id, doctor.d_id, \n" +
            "       doctor.d_surname, doctor.d_first_name,\n" +
            "       doctor.d_second_name FROM patient join patient_doctor_link on patient.p_id = patient_doctor_link.p_id\n" +
            "       JOIN doctor on patient_doctor_link.d_id = doctor.d_id;";

    //---------------------------------------------------------------------------------------------------------
    String FIND_ALL_BY_REF_TYPE_AND_PATIENT_ID = "SELECT * FROM exam_result_by_referral " +
            "LEFT JOIN referral ON exam_result_by_referral.ref_id = referral.id " +
            "WHERE referral.ref_type=? AND referral.patient_id=?";
    String MEDICAL_EMPLOYEE_BY_PERSON = "SELECT * FROM medical_employee WHERE person_id=?";
    String PATIENT_BY_PERSONAL_REG_DATA = "SELECT * FROM patient WHERE person_id=?";
    String PATIENT_BY_REFERRAL = "SELECT * FROM patient INNER JOIN referral on patient.patient_id = referral.patient_id\n" +
            " where referral.id =?";
    String PATIENT_BY_MEDICAL_CARD_ID = "SELECT * FROM patient WHERE medical_card_id=?";
    String PATIENT_BY_ID = "SELECT * FROM patient WHERE patient_id=?";
    String UPDATE_PATIENT_SET_ATTENDING_DOCTOR_FOR_PERSON_ID = "UPDATE patient p SET p.attending_doctor_id = ? " +
            "WHERE p.person_id = ?";
    String PATIENT_VISIT_BY_ID = "SELECT * FROM patient_visit WHERE patient_id=?";
    String ALL_BY_DOCTOR_ID_AND_APP_TYPE_AND_APP_STATE = "SELECT * FROM patient_visit where doctor_id=? " +
            "AND app_type=? AND app_state=true";
    String ALL_BY_APP_TYPE_AND_APP_STATE = "SELECT * FROM patient_visit where app_type=? AND app_state=true";
    String UPDATE_PATIENT_VISIT_SET_APP_STATE_FOR_ID = "UPDATE patient_visit pv SET app_state=? WHERE id=?";
    String UPDATE_PATIENT_VISIT_SET_EXECUTED_BY_PERSON_FOR_ID = "UPDATE patient_visit pv SET resp_med_employee=? WHERE id=?";
    String ALL_FROM_PERSONAL_REG_DATA_BY_ROLE_ID_TITLE = "SELECT * FROM personal_reg_data " +
            "INNER JOIN `role` ON personal_reg_data.`role` = `role`.role_id where title=?";


    String ALL_FROM_PERSONAL_REG_DATA_BY_PATIENT_ATTENDING_DOCTOR = "SELECT * FROM personal_reg_data " +
            "INNER JOIN patient ON personal_reg_data.person_id = patient.person_id where attending_doctor_id=?";
    String ALL_FROM_PERSONAL_REG_DATA_BY_SURNAME_NAME_PATRONYMIC = "SELECT * FROM personal_reg_data " +
            "WHERE surname=? AND name=? AND patronymic=?";
    String PERSONAL_REG_DATA_BY_LOGIN = "SELECT * FROM personal_reg_data WHERE login=?";
    String PERSONAL_REG_DATA_BY_LOGIN_AND_PASSWORD = "SELECT * FROM personal_reg_data WHERE login=? AND password=?";
    String ROLE_BY_LOGIN_AND_PASSWORD = "SELECT `role`.role_id, `role`.title, `role`.code FROM personal_reg_data JOIN `role`" +
            " ON personal_reg_data.`role` = `role`.role_id WHERE personal_reg_data.login=? AND" +
            " personal_reg_data.`password`=?";
    String REFERRAL_BY_ID = "SELECT * FROM referral WHERE id=?";
    String ROLE_BY_CODE = "SELECT * FROM role WHERE code=?";
    String ROLE_BY_CODE_IS_NULL = "SELECT * FROM role WHERE code IS null";
}
