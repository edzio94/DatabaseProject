package pl.edu.pwr.carpartsshop.user.mapper.user;

import org.springframework.jdbc.core.RowMapper;
import pl.edu.pwr.carpartsshop.user.model.userdetails.entity.UserDetailsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
public class UserDetailsRowMapper implements RowMapper<UserDetailsEntity> {
    @Override
    public UserDetailsEntity mapRow(ResultSet rs, int i) throws SQLException {
        return UserDetailsEntity.builder()
                .address(rs.getString("address"))
                .created(rs.getDate("created"))
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .isAdmin(rs.getBoolean("is_admin"))
                .build();
    }
}
