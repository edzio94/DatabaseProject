package pl.edu.pwr.carpartsshop.user.mapper.user;

import org.springframework.jdbc.core.RowMapper;
import pl.edu.pwr.carpartsshop.user.user.model.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lukasz on 11/30/16.
 */
public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
