package com.medical.controller.commands.implementation;

import com.medical.controller.commands.Command;
import com.medical.model.entity.Discharge;
import com.medical.model.entity.Treatment;
import com.medical.model.entity.UserData;
import com.medical.model.services.DischargeProcessor;
import com.medical.model.services.TreatmentProcessor;
import com.medical.model.services.implementation.DischargeProcessorService;
import com.medical.model.services.implementation.TreatmentProcessorService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

public class DoctorAppointment implements Command {
    private final static Logger LOGGER = Logger.getLogger(DoctorAppointment.class.getSimpleName());

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
        LOGGER.info("method started");
        pageLocalization.defineLanguageForAppointmentPage(request);
        LOGGER.info("defined UI language");

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
            LOGGER.info("Doctor made final diagnosis");
        } else if (Objects.nonNull(appTypeUk) && Objects.nonNull(appTypeEn)) {
            Integer user = Integer.valueOf(request.getParameter("patients"));

            LOGGER.info("Doctor make an assignment to treatment");
            new TreatmentProcessorService().addNewTreatment(new Treatment(user, LocalDate.now(),
                    "Діагноз", "Diagnosis", appTypeUk, appTypeEn, doctor.getId(), true));
        }
        LOGGER.info("method return page");
        return "/WEB-INF/view/templates/doctor-appointments.jsp";
    }
}
