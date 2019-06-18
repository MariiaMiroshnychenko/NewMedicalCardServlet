package controller.commands.implementation;

import model.dto.LocalAssignmentDto;
import model.dto.LocalUserDataDto;
import model.dao.FactoryDao;
import model.entity.Treatment;
import model.entity.UserData;
import model.services.UserDataProcessor;
import model.services.TreatmentProcessor;
import model.services.implementation.UserDataService;
import model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PageLocalization {
    private UserDataProcessor userDataProcessor;
    private TreatmentProcessor treatmentProcessor;

    public void setPersonIdentifier(UserDataProcessor userDataProcessor) {
        this.userDataProcessor = userDataProcessor;
    }

    public UserDataProcessor getUserDataProcessor() {
        return userDataProcessor;
    }

    public TreatmentProcessor getTreatmentProcessor() {
        return treatmentProcessor;
    }

    public void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    private String defineLocale(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("language");
    }

    private UserData getSessionUserData(HttpServletRequest request) {
        return (UserData) request.getSession().getAttribute("user");
    }

    private List<UserData> getPatientData(String role) {
        setPersonIdentifier(new UserDataService(FactoryDao.getInstance().getUserDataJdbcDao()));
        return getUserDataProcessor().identifyPersonByRole(role);
    }

    private List<Treatment> getAllEnableTreatments(Boolean state) {
        setTreatmentProcessor(new TreatmentProcessorService());
        return treatmentProcessor.getTreatmentsByState(state);
    }

    private List<Treatment> getAllEnableTreatments(String firstType, String secondType, Boolean state) {
        setTreatmentProcessor(new TreatmentProcessorService());
        return treatmentProcessor.getTreatmentsByTypesAndState(firstType, secondType, state);
    }

    private LocalUserDataDto getLocalizedPersonData(String language, UserData userData) {
        return language.equals("uk") ? new LocalUserDataDto(userData, userData.getNameUk(),
                userData.getSurnameUk(), userData.getPatronymicUk())
                : new LocalUserDataDto(userData, userData.getNameEn(),
                userData.getSurnameEn(), userData.getPatronymicEn());
    }

    private LocalAssignmentDto getLocalizedAssignment(String language, Treatment treatment) {
        return language.equals("uk") ? new LocalAssignmentDto(treatment,
                treatment.getAppointmentTypeUk(), treatment.getDiagnosisUk())
                : new LocalAssignmentDto(treatment,
                treatment.getAppointmentTypeEn(), treatment.getDiagnosisEn());
    }

    public void setAttributeWithLocalUserData(HttpServletRequest request) {
        request.setAttribute("localUser", getLocalizedPersonData(defineLocale(request), getSessionUserData(request)));
    }

    public void defineLanguageForAppointmentPage(HttpServletRequest request) {
        List<LocalUserDataDto> localUserDataDtos = new ArrayList<>();

        getPatientData("patient")
                .forEach(pData -> localUserDataDtos
                        .add(getLocalizedPersonData(defineLocale(request),
                                                    pData)));

        request.setAttribute("localPatients", localUserDataDtos);
    }

    public void defineLanguageForDoctorProcedurePage(HttpServletRequest request) {
        List<LocalAssignmentDto> localAssignmentDtos = new ArrayList<>();

        getAllEnableTreatments(true)
                .forEach(aData -> localAssignmentDtos
                        .add(getLocalizedAssignment(defineLocale(request),
                                aData)));

        request.setAttribute("localAssignments", localAssignmentDtos);
    }

    public void defineLanguageForNurseProcedurePage(HttpServletRequest request) {
        List<LocalAssignmentDto> localAssignmentDtos = new ArrayList<>();

        getAllEnableTreatments("Pills", "Procedure", true)
                .forEach(aData -> localAssignmentDtos
                        .add(getLocalizedAssignment(defineLocale(request),
                                aData)));

        request.setAttribute("localAssignments", localAssignmentDtos);
    }
}
