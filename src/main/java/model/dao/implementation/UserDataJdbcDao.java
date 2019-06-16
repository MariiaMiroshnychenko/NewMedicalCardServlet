package model.dao.implementation;

import model.dao.UserDataDao;
import model.entity.UserData;
import servlet.mapper.implementation.UserDataMapper;
import view.QueryConstants;

import java.sql.*;
import java.util.*;

public class UserDataJdbcDao implements UserDataDao {
    private UserDataMapper userDataMapper = new UserDataMapper();
    private Map<Integer, UserData> personalRegDataMap = new HashMap<>();

    public Connection connection;

    public UserDataJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserData findUserDataByLoginAndPassword(String login, String password) {
        UserData userData = null;

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_DATA_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

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
        UserData userData = null;

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_DATA_BY_LOGIN)) {
            statement.setString(1, login);

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
    public List<UserData> findUserDataByRole(String role) {
        List<UserData> userData = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_DATA_BY_ROLE_TITLE)) {
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
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.REGISTER_PERSON)) {
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
    public void update() {

    }
}
