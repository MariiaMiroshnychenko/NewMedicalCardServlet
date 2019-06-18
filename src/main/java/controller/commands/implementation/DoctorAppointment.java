package controller.commands.implementation;

import controller.commands.Command;
import model.entity.Discharge;
import model.entity.Treatment;
import model.entity.UserData;
import model.services.DischargeProcessor;
import model.services.TreatmentProcessor;
import model.services.implementation.DischargeProcessorService;
import model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

public class DoctorAppointment implements Command {
    private PageLocalization pageLocalization;
    private TreatmentProcessor treatmentProcessor;
    private DischargeProcessor dischargeProcessor;

    public DoctorAppointment(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    public TreatmentProcessor getTreatmentProcessor() {
        return treatmentProcessor;
    }

    public void setTreatmentProcessor(TreatmentProcessor treatmentProcessor) {
        this.treatmentProcessor = treatmentProcessor;
    }

    public PageLocalization getPageLocalization() {
        return pageLocalization;
    }

    public void setPageLocalization(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    public DischargeProcessor getDischargeProcessor() {
        return dischargeProcessor;
    }

    public void setDischargeProcessor(DischargeProcessor dischargeProcessor) {
        this.dischargeProcessor = dischargeProcessor;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.defineLanguageForAppointmentPage(request);

        UserData doctor = (UserData) request.getSession().getAttribute("user");

        String patient = request.getParameter("patients_with_login");
        String appTypeUk = request.getParameter("appTypeUk");
        String appTypeEn = request.getParameter("appTypeEn");
        if (Objects.nonNull(patient)) {
            Integer patientId = Integer.valueOf(patient);

            setTreatmentProcessor(new TreatmentProcessorService());
            setDischargeProcessor(new DischargeProcessorService());

            Integer userFinalDiagnosis = Integer.valueOf(patient);
            getDischargeProcessor().addDischarge(
                    new Discharge(userFinalDiagnosis, getTreatmentProcessor().getFirstPatientTreatment(patientId).getDate(),
                    getTreatmentProcessor().getDecsPatientTreatment(patientId).getDate(), "Фінальний діагноз",
                    "Final diagnosis", doctor.getId()));

        } else if (Objects.nonNull(appTypeUk) && Objects.nonNull(appTypeEn)) {
            Integer user = Integer.valueOf(request.getParameter("patients"));

            new TreatmentProcessorService().addNewTreatment(new Treatment(user, LocalDate.now(),
                    "Діагноз", "Diagnosis", appTypeUk, appTypeEn, doctor.getId(), true));
        }
        return "/WEB-INF/view/templates/doctor-appointments.jsp";
    }
}
