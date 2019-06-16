package model.services;

import model.entity.UserData;

public interface PersonIdentifier {
    UserData identifyPerson(String login);
}
