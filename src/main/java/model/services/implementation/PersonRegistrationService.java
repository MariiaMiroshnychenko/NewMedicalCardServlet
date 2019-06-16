package model.services.implementation;

import model.dao.FactoryDao;
import model.dao.UserDataDao;
import model.entity.UserData;
import model.services.PersonRegistration;

import java.util.*;

public class PersonRegistrationService implements PersonRegistration {
    @Override
    public void toSignUp(UserData userData) {
        UserDataDao userDataDao = FactoryDao.getInstance().getUserDataJdbcDao();

//        if (Objects.nonNull(userDataDao.findByLogin(user.getLogin()))) {
//            throw new LoginAlreadyExistsException();
//        }
        userDataDao.create(userData);
            userDataDao.close();
    }

    @Override
    public Integer assignDoctor() {
        UserDataDao userDataDao = FactoryDao.getInstance().getUserDataJdbcDao();

        List<UserData> familyDoctors = userDataDao.findUserDataByRole("doctor");
        Random random = new Random();
        return familyDoctors.get(random.nextInt(familyDoctors.size())).getId();
    }
}
