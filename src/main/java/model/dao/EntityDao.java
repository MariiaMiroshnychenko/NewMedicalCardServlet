package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface EntityDao<T> extends AutoCloseable {
    void close();
    void create(T t);
    void update();

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
