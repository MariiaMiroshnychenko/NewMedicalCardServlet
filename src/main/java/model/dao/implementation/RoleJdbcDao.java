package model.dao.implementation;//package model.dao.implementation;

import model.dao.RoleDao;
import model.entity.Role;

import java.sql.Connection;

public class RoleJdbcDao extends RoleDao<Role> {
    @Override
    public String findRoleTitleByLoginAndPassword(String login, String password) {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    public RoleJdbcDao(Connection connection) {
        super(connection);
    }

}
