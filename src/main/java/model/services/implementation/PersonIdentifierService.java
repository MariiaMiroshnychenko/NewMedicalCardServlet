package model.services.implementation;

import model.dao.UserDataDao;
import model.entity.UserData;
import model.services.PersonIdentifier;

public class PersonIdentifierService implements PersonIdentifier {
    UserDataDao userDataDao;

    public PersonIdentifierService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    @Override
    public UserData identifyPerson(String login) {
        UserData userData = userDataDao.findUserDataByLogin(login);

        return userData;
    }
}
