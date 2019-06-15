package servlet.mapper.implementation;

import model.entity.Role;
import servlet.mapper.MainMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RoleMapper implements MainMapper<Role> {
    @Override
    public Role extractFromResultSet(ResultSet resultSet) throws SQLException {
//        Integer id = resultSet.getInt("role_id");
        String title = resultSet.getString("title");
//        String code = resultSet.getString("code");

//        return new Role(id, title, code);
        return new Role(title);
    }

    @Override
    public Role makeUnique(Map<Integer, Role> cache, Role entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
