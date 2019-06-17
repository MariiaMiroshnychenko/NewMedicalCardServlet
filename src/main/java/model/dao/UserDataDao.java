package model.dao;

import model.entity.UserData;

import java.util.List;

public interface UserDataDao extends GenericDao<UserData> {
    UserData findUserDataByLogin(String login);
    List<UserData> findUserDataByRole(String role);
}
