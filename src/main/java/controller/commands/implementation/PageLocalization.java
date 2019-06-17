package controller.commands.implementation;

import model.LocalUserDataDto;
import model.dao.FactoryDao;
import model.entity.Treatment;
import model.entity.UserData;
import model.services.PersonRegistration;
import model.services.TreatmentProcessor;
import model.services.implementation.PersonRegistrationService;
import model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PageLocalization {
    private PersonRegistration personRegistration;
    private TreatmentProcessor treatmentProcessor;

    public void setPersonIdentifier(PersonRegistration personRegistration) {
        this.personRegistration = personRegistration;
    }

    public PersonRegistration getPersonRegistration() {
        return personRegistration;
    }

    public TreatmentProcessor getTreatmentProcessor() {
        return treatmentProcessor;
    }

    public void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    public void defineLanguageForUserAccount(HttpServletRequest request) {
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
        List<LocalUserDataDto> localUserDataDtos = new ArrayList<>();

        getAllEnableTreatments(true)
                .forEach(pData -> localUserDataDtos
                        .add(getLocalizedPersonData(defineLocale(request),
                                pData)));

        request.setAttribute("localPatients", localUserDataDtos);
    }

    private LocalUserDataDto getLocalizedPersonData(String language, UserData userData) {
        return language.equals("uk") ? new LocalUserDataDto(userData, userData.getNameUk(),
                userData.getSurnameUk(),
                userData.getPatronymicUk())
                : new LocalUserDataDto(userData, userData.getNameEn(),
                userData.getSurnameEn(),
                userData.getPatronymicEn());
    }

    private String defineLocale(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("language");
    }

    private UserData getSessionUserData(HttpServletRequest request) {
        return (UserData) request.getSession().getAttribute("user");
    }

    private List<UserData> getPatientData(String role) {
        setPersonIdentifier(new PersonRegistrationService(FactoryDao.getInstance().getUserDataJdbcDao()));
        return getPersonRegistration().identifyPersonByRole(role);
    }

    private List<Treatment> getAllEnableTreatments(Boolean state) {
        setTreatmentProcessor(new TreatmentProcessorService());
        return treatmentProcessor.getTreatmentsByState(state);
    }
}
