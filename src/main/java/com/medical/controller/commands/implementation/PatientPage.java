package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.container.RoleContainer;
import com.medical.controller.commands.Command;
import com.medical.controller.commands.PageLocalization;
import com.medical.model.entity.UserData;
import com.medical.model.services.TreatmentProcessor;
import com.medical.model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Arrays;

public class PatientPage implements Command {
    private String[] hasAuthority = {RoleContainer.ROLE_PATIENT};
    private PageLocalization pageLocalization;
    private TreatmentProcessor treatmentProcessor;

    public PatientPage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    private TreatmentProcessor getTreatmentProcessor() {
        return treatmentProcessor;
    }

    private void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    @Override
    public String execute(HttpServletRequest request) {
        UserData userData = (UserData) request.getSession().getAttribute("user");
        setTreatmentProcessor(new TreatmentProcessorService());

        LocalDate beginDate = getTreatmentProcessor().getFirstPatientTreatment(userData.getId()).getDate();
        LocalDate endDate = getTreatmentProcessor().getDecsPatientTreatment(userData.getId()).getDate();

        request.setAttribute("beginDate", beginDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("treatmentList", getTreatmentProcessor().getTreatmentsByPatientIdAndDates(userData.getId()));

        pageLocalization.setAttributeWithLocalUserData(request);
        return PagesContainer.PAGE_PATIENT_ACCOUNT;
    }

    @Override
    public boolean checkAuthority(String role) {
        return Arrays.asList(hasAuthority).contains(role);
    }
}
