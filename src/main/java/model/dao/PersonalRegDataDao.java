package model.dao;

import model.entity.PersonalRegData;
import model.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;

public interface PersonalRegDataDao extends EntityDao<PersonalRegData> {
    PersonalRegData findPersonalRegDataByLoginAndPassword(String login, String password);
    PersonalRegData findPersonalRegDataByLogin(String login);
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
