package com.medical.model.dao.implementation;

import com.medical.container.QueryContainer;
import com.medical.model.dao.UserDataDao;
import com.medical.model.dao.mapper.implementation.UserDataMapper;
import com.medical.model.entity.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDataJdbcDao implements UserDataDao {
    private UserDataMapper userDataMapper = new UserDataMapper();
    private Map<Integer, UserData> personalRegDataMap = new HashMap<>();

    private Connection connection;

    UserDataJdbcDao(Connection connection) {
        this.connection = connection;
    }

    private UserData findUserDataByField(Object field, String query) {
        UserData userData = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, field);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userData = userDataMapper.extractFromResultSet(resultSet);
            }
            if (Objects.nonNull(userData)) {
                userDataMapper.makeUnique(personalRegDataMap, userData);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }
    @Override
    public UserData findUserDataByLogin(String login) {
        return findUserDataByField(login, QueryContainer.USER_DATA_BY_LOGIN);
    }

    @Override
    public UserData findUserDataById(Integer id) {
        return findUserDataByField(id, QueryContainer.USER_DATA_BY_ID);
    }

    @Override
    public List<UserData> findUserDataByRole(String role) {
        List<UserData> userData = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(QueryContainer.USER_DATA_BY_ROLE_TITLE)) {
            statement.setString(1, role);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UserData user = userDataMapper.extractFromResultSet(resultSet);

                userDataMapper.makeUnique(personalRegDataMap, user);
            }
            resultSet.close();
            userData = new ArrayList<>(personalRegDataMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(UserData userData) {
        try (PreparedStatement statement = connection.prepareStatement(QueryContainer.REGISTER_PERSON)) {
            statement.setString(1, userData.getSurnameUk());
            statement.setString(2, userData.getSurnameEn());
            statement.setString(3, userData.getNameUk());
            statement.setString(4, userData.getNameEn());
            statement.setString(5, userData.getPatronymicUk());
            statement.setString(6, userData.getPatronymicEn());
            statement.setString(7, userData.getLogin());
            statement.setString(8, userData.getPassword());
            statement.setString(9, userData.getRole());
            statement.setString(10, userData.getPhoto());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object field, Integer id, String query) {

    }
}
