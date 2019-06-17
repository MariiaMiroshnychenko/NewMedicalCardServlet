package model.services.implementation;

import model.dao.UserDataDao;
import model.entity.UserData;
import model.services.PersonRegistration;

import java.util.List;

public class PersonRegistrationService implements PersonRegistration {
    private UserDataDao userDataDao;

    public PersonRegistrationService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    @Override
    public UserData identifyPersonByLogin(String login) {
        UserData user = userDataDao.findUserDataByLogin(login);
        userDataDao.close();
        return user;
    }

    @Override
    public List<UserData> identifyPersonByRole(String role) {
        List<UserData> userData = userDataDao.findUserDataByRole(role);
        userDataDao.close();
        return userData;
    }

    @Override
    public void toSignUp(UserData userData) {
        userDataDao.create(userData);
        userDataDao.close();
    }
}
