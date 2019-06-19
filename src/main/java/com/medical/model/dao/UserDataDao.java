package com.medical.model.dao;

import com.medical.model.entity.UserData;

import java.util.List;

public interface UserDataDao extends GenericDao<UserData> {
    UserData findUserDataByLogin(String login);
    List<UserData> findUserDataByRole(String role);
    UserData findUserDataById(Integer id);
}
