package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.container.RoleContainer;
import com.medical.controller.commands.Command;
import com.medical.controller.commands.PageLocalization;
import com.medical.model.entity.UserData;
import com.medical.model.services.TreatmentProcessor;
import com.medical.model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

public class ProcedureByMedEmployee implements Command {
    private String[] hasAuthority = {RoleContainer.ROLE_NURSE};
    private PageLocalization pageLocalization;
    private TreatmentProcessor treatmentProcessor;

    public ProcedureByMedEmployee(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    private void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    @Override
    public String execute(HttpServletRequest request) {
        setTreatmentProcessor(new TreatmentProcessorService());

        String treatmentId = request.getParameter("treatmentId");
        UserData userId = (UserData) request.getSession().getAttribute("user");

        if (Objects.nonNull(treatmentId)) {
            Integer tret = Integer.valueOf(treatmentId);
            treatmentProcessor.updateTreatmentStateAndExecutorWithService(false, userId.getId(), tret);
        }
        if (userId.getRole().equals("doctor")) {
            pageLocalization.defineLanguageForDoctorProcedurePage(request);
            return PagesContainer.PAGE_PROCEDURE;
        } else {
            pageLocalization.defineLanguageForNurseProcedurePage(request);
            return PagesContainer.PAGE_NURSE_PROCEDURE;
        }
    }

    @Override
    public boolean checkAuthority(String role) {
        return Arrays.asList(hasAuthority).contains(role);
    }
}
