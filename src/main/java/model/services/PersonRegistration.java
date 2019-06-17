package model.services;

import model.entity.UserData;

import java.util.List;

public interface PersonRegistration {
    UserData identifyPersonByLogin(String login);
    List<UserData> identifyPersonByRole(String role);
    void toSignUp(UserData userData);
}
