package model.dao;

import model.entity.PersonalRegData;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class PersonalRegDataDao<T> extends EntityDao {
    public PersonalRegDataDao(Connection connection) {
        super(connection);
    }

    public abstract PersonalRegData findPersonalRegDataByLoginAndPassword(String login, String password);
    public abstract String findRoleTitleByLoginAndPassword(String login, String password);
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

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
