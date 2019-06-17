package controller.commands.implementation;

import controller.commands.Command;
import model.entity.Treatment;
import model.entity.UserData;
import model.services.implementation.TreatmentProcessorService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

public class DoctorAppointment implements Command {
    private PageLocalization pageLocalization;

    public DoctorAppointment(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.defineLanguageForAppointmentPage(request);

        UserData doctor = (UserData) request.getSession().getAttribute("user");

        String appTypeUk = request.getParameter("appTypeUk");
        String appTypeEn = request.getParameter("appTypeEn");
        System.out.println(Objects.nonNull(appTypeUk));
        System.out.println(Objects.nonNull(appTypeEn));
        if (Objects.nonNull(appTypeUk) && Objects.nonNull(appTypeEn)) {
            Integer user = Integer.valueOf(request.getParameter("patients"));
            System.out.println(user);
            new TreatmentProcessorService().addNewTreatment(new Treatment(user, LocalDate.now(),
                    "Діагноз", "Diagnosis", appTypeUk , appTypeEn, doctor.getId(), true));
        }
        return "/WEB-INF/view/templates/doctor-appointments.jsp";
    }
}
