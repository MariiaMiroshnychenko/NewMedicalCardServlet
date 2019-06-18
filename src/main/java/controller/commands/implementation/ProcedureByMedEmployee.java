package controller.commands.implementation;

import controller.commands.Command;
import model.entity.UserData;
import model.services.TreatmentProcessor;
import model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class ProcedureByMedEmployee implements Command {
    private PageLocalization pageLocalization;
    private TreatmentProcessor treatmentProcessor;

    public ProcedureByMedEmployee(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        treatmentProcessor = new TreatmentProcessorService();

        String treatmentId = request.getParameter("treatmentId");
        UserData userId = (UserData) request.getSession().getAttribute("user");

        if (Objects.nonNull(treatmentId)) {
            Integer tret = Integer.valueOf(treatmentId);
            treatmentProcessor.updateTreatmentStateAndExecutorWithService(false, userId.getId(), tret);
        }
        if (userId.getRole().equals("doctor")) {
            pageLocalization.defineLanguageForDoctorProcedurePage(request);
            return "/WEB-INF/view/templates/procedure.jsp";
        } else {
            pageLocalization.defineLanguageForNurseProcedurePage(request);
            return "/WEB-INF/view/templates/procedure-med-emp.jsp";
        }
    }
}
