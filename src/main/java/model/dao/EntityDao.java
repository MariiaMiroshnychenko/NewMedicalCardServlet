package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class EntityDao implements AutoCloseable {
    public Connection connection;

    public EntityDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void create();
    public abstract void update();

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
