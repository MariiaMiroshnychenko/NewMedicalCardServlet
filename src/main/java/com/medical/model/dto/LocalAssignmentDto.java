package com.medical.model.dto;

import com.medical.model.entity.Treatment;
import com.medical.model.entity.UserData;

public class LocalAssignmentDto implements LocalDataDto {
    private Treatment treatment;

    private String appType;
    private String diagnosis;

    public LocalAssignmentDto(Treatment treatment, String appType, String diagnosis) {
        this.treatment = treatment;
        this.appType = appType;
        this.diagnosis = diagnosis;
    }

    public LocalAssignmentDto() {
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
