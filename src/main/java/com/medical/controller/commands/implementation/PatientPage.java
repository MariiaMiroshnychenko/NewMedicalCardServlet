package com.medical.controller.commands.implementation;

import com.medical.controller.commands.Command;
import com.medical.model.dao.FactoryDao;
import com.medical.model.entity.UserData;
import com.medical.model.services.TreatmentProcessor;
import com.medical.model.services.UserDataProcessor;
import com.medical.model.services.implementation.TreatmentProcessorService;
import com.medical.model.services.implementation.UserDataService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class PatientPage implements Command {
    private PageLocalization pageLocalization;
    private TreatmentProcessor treatmentProcessor;
    private UserDataProcessor userDataProcessor;

    public PatientPage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    public TreatmentProcessor getTreatmentProcessor() {
        return treatmentProcessor;
    }

    public void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    public UserDataProcessor getUserDataProcessor() {
        return userDataProcessor;
    }

    public void setUserDataProcessor(UserDataProcessor userDataProcessor) {
        this.userDataProcessor = userDataProcessor;
    }

    @Override
    public String execute(HttpServletRequest request) {
        UserData userData = (UserData) request.getSession().getAttribute("user");
        setTreatmentProcessor(new TreatmentProcessorService());
        setUserDataProcessor(new UserDataService(FactoryDao.getInstance().getUserDataJdbcDao()));

        LocalDate beginDate = getTreatmentProcessor().getFirstPatientTreatment(userData.getId()).getDate();
        LocalDate endDate = getTreatmentProcessor().getDecsPatientTreatment(userData.getId()).getDate();

        request.setAttribute("beginDate", beginDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("treatmentList", getTreatmentProcessor().getTreatmentsByPatientIdAndDates(userData.getId()));

        pageLocalization.setAttributeWithLocalUserData(request);
        return "/WEB-INF/view/templates/patientPage.jsp";
    }
}
