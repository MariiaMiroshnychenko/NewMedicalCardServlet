package model.dao.implementation;//package model.dao.implementation;

import model.dao.RoleDao;
import model.entity.Role;
import servlet.mapper.implementation.RoleMapper;
import view.QueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RoleJdbcDao implements RoleDao {
    private RoleMapper roleMapper = new RoleMapper();
    private Map<Integer, Role> roleMap = new HashMap<>();

    public Connection connection;

    public RoleJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Role findRoleTitleByLoginAndPassword(String login, String password) {
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.ROLE_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                role = roleMapper.extractFromResultSet(resultSet);
            }

            if (Objects.nonNull(role)) {
                roleMapper.makeUnique(roleMap, role);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public String findRoleByCode(String code) {
        return null;
    }

    @Override
    public void create(Role role) {

    }

    @Override
    public void update() {

    }

    @Override
    public void close() throws Exception {

    }

}
