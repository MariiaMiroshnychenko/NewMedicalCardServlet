package com.medical.model.services;

import com.medical.model.entity.UserData;

import java.util.List;

public interface UserDataProcessor {
    UserData identifyPersonByLogin(String login);
    UserData identifyPersonById(Integer id);
    List<UserData> identifyPersonByRole(String role);
    void toSignUp(UserData userData);
}
