package model.services.implementation;

import model.dao.UserDataDao;
import model.entity.UserData;
import model.services.UserDataProcessor;

import java.util.List;

public class UserDataService implements UserDataProcessor {
    private UserDataDao userDataDao;

    public UserDataService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    @Override
    public UserData identifyPersonByLogin(String login) {
        UserData user = userDataDao.findUserDataByLogin(login);
        userDataDao.close();
        return user;
    }

    @Override
    public UserData identifyPersonById(Integer id) {
        UserData userData = userDataDao.findUserDataById(id);
        userDataDao.close();
        return userData;
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
