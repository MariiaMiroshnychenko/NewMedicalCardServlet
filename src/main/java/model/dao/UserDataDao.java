package model.dao;

import model.entity.UserData;

import java.util.List;

public interface UserDataDao extends EntityDao<UserData> {
    UserData findUserDataByLoginAndPassword(String login, String password);

    UserData findUserDataByLogin(String login);

    List<UserData> findUserDataByRole(String role);
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
