package com.medical;

import com.medical.controller.commands.implementation.PageLocalization;
import com.medical.model.entity.Discharge;
import com.medical.model.entity.Treatment;
import com.medical.model.entity.UserData;
import com.medical.model.services.DischargeProcessor;
import com.medical.model.services.TreatmentProcessor;
import com.medical.model.services.implementation.DischargeProcessorService;
import com.medical.model.services.implementation.TreatmentProcessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DoctorAppointmentTest {
//    private PageLocalization pageLocalization;
//    private TreatmentProcessor treatmentProcessor;
//    private DischargeProcessor dischargeProcessor;
    @Test
    public void testVoid() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        TreatmentProcessor treatmentProcessor = mock(TreatmentProcessorService.class);
        PageLocalization pageLocalization = mock(PageLocalization.class);
        DischargeProcessor dischargeProcessor = mock(DischargeProcessorService.class);

        verify(request).getSession();
        pageLocalization.defineLanguageForAppointmentPage(request);
        UserData doctor = (UserData) request.getSession().getAttribute("user");

        String patient = request.getParameter("patients_with_login");
        String appTypeUk = request.getParameter("appTypeUk");
        String appTypeEn = request.getParameter("appTypeEn");

        if (Objects.nonNull(patient)) {
            Integer patientId = Integer.valueOf(patient);

            Integer userFinalDiagnosis = Integer.valueOf(patient);
            dischargeProcessor.addDischarge(
                    new Discharge(userFinalDiagnosis, treatmentProcessor.getFirstPatientTreatment(patientId).getDate(),
                            treatmentProcessor.getDecsPatientTreatment(patientId).getDate(), "Фінальний діагноз",
                            "Final diagnosis", doctor.getId()));

        } else if (Objects.nonNull(appTypeUk) && Objects.nonNull(appTypeEn)) {
            Integer user = Integer.valueOf(request.getParameter("patients"));

            new TreatmentProcessorService().addNewTreatment(new Treatment(user, LocalDate.now(),
                    "Діагноз", "Diagnosis", appTypeUk, appTypeEn, doctor.getId(), true));
        }
        //return "/WEB-INF/view/templates/doctor-appointments.jsp";
    }



}
