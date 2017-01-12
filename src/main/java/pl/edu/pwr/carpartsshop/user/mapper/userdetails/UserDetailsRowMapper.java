package pl.edu.pwr.carpartsshop.user.mapper.userdetails;

import org.springframework.jdbc.core.RowMapper;
import pl.edu.pwr.carpartsshop.user.userdetails.model.entity.UserDetailsEntity;

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
                .userId(rs.getInt("user_id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .isAdmin(rs.getBoolean("is_admin"))
                .build();
    }
}
