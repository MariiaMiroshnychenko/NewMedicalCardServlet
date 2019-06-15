package model.services.implementation;

import model.dao.FactoryDao;
import model.dao.PersonalRegDataDao;
import model.entity.PersonalRegData;
import model.entity.Role;
import model.services.PersonRegistration;
import servlet.mapper.implementation.PersonalRegDataMapper;
import servlet.mapper.implementation.RoleMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonRegistrationService implements PersonRegistration {

    @Override
    public void toSignUp(PersonalRegData personalRegData) {
        PersonalRegDataDao personalRegDataDao = FactoryDao.getInstance().getPersonalRegDataJdbcDao();

//        if (Objects.nonNull(personalRegDataDao.findByLogin(user.getLogin()))) {
//            throw new LoginAlreadyExistsException();
//        }

        personalRegDataDao.create(personalRegData);
        try {
            personalRegDataDao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
