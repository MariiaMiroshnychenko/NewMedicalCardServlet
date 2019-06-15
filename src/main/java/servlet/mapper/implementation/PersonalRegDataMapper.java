package servlet.mapper.implementation;

import model.entity.PersonalRegData;
import servlet.mapper.MainMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PersonalRegDataMapper implements MainMapper<PersonalRegData> {
    @Override
    public PersonalRegData extractFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("person_id");
        String surname = resultSet.getString("surname");
        String name = resultSet.getString("name");
        String patronymic = resultSet.getString("patronymic");
        Date birthDate = resultSet.getDate("birth_date");
        String phone = resultSet.getString("phone");
        String email = resultSet.getString("email");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        Integer roleId = resultSet.getInt("role");
        boolean enabled = resultSet.getBoolean("enabled");
        String photo = resultSet.getString("photo");

        return new PersonalRegData(id, surname, name, patronymic, birthDate,
                phone, email, login, password, roleId, enabled, photo);
    }

    @Override
    public PersonalRegData makeUnique(Map<Integer, PersonalRegData> cache, PersonalRegData entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
