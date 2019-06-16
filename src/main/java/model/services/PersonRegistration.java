package model.services;

import model.entity.UserData;

public interface PersonRegistration {
    Integer assignDoctor();
    void toSignUp(UserData userData);
}
