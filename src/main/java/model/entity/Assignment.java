package model.entity;

public class Assignment {
    private Integer id;
    private Integer patientId;
    private String assignmentTypeUk;
    private String assignmentTypeEn;
    private Boolean state;
    private Integer executeDocId;

    public Assignment(Integer id, Integer patientId, String assignmentTypeUk,
                      String assignmentTypeEn, Boolean state, Integer executeDocId) {
        this.id = id;
        this.patientId = patientId;
        this.assignmentTypeUk = assignmentTypeUk;
        this.assignmentTypeEn = assignmentTypeEn;
        this.state = state;
        this.executeDocId = executeDocId;
    }

    public Assignment(Integer patientId, String assignmentTypeUk, String assignmentTypeEn,
                      Boolean state, Integer executeDocId) {
        this.patientId = patientId;
        this.assignmentTypeUk = assignmentTypeUk;
        this.assignmentTypeEn = assignmentTypeEn;
        this.state = state;
        this.executeDocId = executeDocId;
    }

    public Assignment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getAssignmentTypeUk() {
        return assignmentTypeUk;
    }

    public void setAssignmentTypeUk(String assignmentTypeUk) {
        this.assignmentTypeUk = assignmentTypeUk;
    }

    public String getAssignmentTypeEn() {
        return assignmentTypeEn;
    }

    public void setAssignmentTypeEn(String assignmentTypeEn) {
        this.assignmentTypeEn = assignmentTypeEn;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getExecuteDocId() {
        return executeDocId;
    }

    public void setExecuteDocId(Integer executeDocId) {
        this.executeDocId = executeDocId;
    }
}
