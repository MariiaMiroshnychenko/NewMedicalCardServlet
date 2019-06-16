package servlet.mapper.implementation;

import model.entity.UserData;
import servlet.mapper.MainMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class UserDataMapper implements MainMapper<UserData> {
    @Override
    public UserData extractFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("person_id");
        String surnameUk = resultSet.getString("surname_uk");
        String surnameEn = resultSet.getString("surname_en");
        String nameUk = resultSet.getString("name_uk");
        String nameEn = resultSet.getString("name_en");
        String patronymicUk = resultSet.getString("patronymic_uk");
        String patronymicEn = resultSet.getString("patronymic_en");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");
        String photo = resultSet.getString("photo");


        return new UserData(id, surnameUk, surnameEn, nameUk, nameEn,
                patronymicUk, patronymicEn, login, password, role, photo);
    }

    @Override
    public UserData makeUnique(Map<Integer, UserData> cache, UserData entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
