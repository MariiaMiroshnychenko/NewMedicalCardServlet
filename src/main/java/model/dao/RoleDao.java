package model.dao;

import model.entity.PersonalRegData;
import model.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;

public interface RoleDao extends EntityDao<Role> {
    //    public abstract PersonalRegData findPersonalRegDataByLoginAndPassword(String login, String password);
    Role findRoleTitleByLoginAndPassword(String login, String password);
    String findRoleByCode(String code);
//    public List<T> getAll() {
//        List<T> list = new ArrayList<>();
//
//        try (PreparedStatement statement = connection.prepareStatement(getQuery())) {
//            ResultSet results = statement.executeQuery();
//
//            while (results.next()) {
//                T t = extractEntityData(results);
//
//                list.add(t);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

//    public abstract String getQuery ();
//    public abstract T extractEntityData(ResultSet results);
}
