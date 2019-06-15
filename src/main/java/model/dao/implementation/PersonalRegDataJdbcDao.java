package model.dao.implementation;

import model.dao.PersonalRegDataDao;
import model.entity.PersonalRegData;
import model.entity.Role;
import servlet.mapper.implementation.PersonalRegDataMapper;
import servlet.mapper.implementation.RoleMapper;
import view.QueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonalRegDataJdbcDao implements PersonalRegDataDao {
    private PersonalRegDataMapper personalRegDataMapper = new PersonalRegDataMapper();
    private Map<Integer, PersonalRegData> personalRegDataMap = new HashMap<>();

    public Connection connection;

    public PersonalRegDataJdbcDao(Connection connection) {
        this.connection = connection;
    }
//    public PersonalRegDataJdbcDao(Connection connection, PersonalRegDataMapper personalRegDataMapper,
//                                  Map<Integer, PersonalRegData> personalRegDataMap) {
//        super(connection);
//        this.personalRegDataMapper = personalRegDataMapper;
//        this.personalRegDataMap = personalRegDataMap;
//    }

    @Override
    public PersonalRegData findPersonalRegDataByLoginAndPassword(String login, String password) {
        PersonalRegData personalRegData = null;

        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PERSONAL_REG_DATA_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                personalRegData = personalRegDataMapper.extractFromResultSet(resultSet);
            }

            if (Objects.nonNull(personalRegData)) {
                personalRegDataMapper.makeUnique(personalRegDataMap, personalRegData);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalRegData;
    }

    @Override
    public PersonalRegData findPersonalRegDataByLogin(String login) {
        return null;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(PersonalRegData personalRegData) {

    }

    @Override
    public void update() {

    }
}
