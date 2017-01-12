package pl.edu.pwr.carpartsshop.user.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.userdetails.repository.UserDetailsRepository;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
@Service
public class UserDetailsService implements UserDetailsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUserDetails(UserDetailsDto userDetailsDto) throws SQLException {
        PreparedStatement statement = jdbcTemplate.getDataSource()
                .getConnection().prepareStatement(SAVE_USER_DETAILS);

        statement.setDate(1, new java.sql.Date(userDetailsDto.getCreated().getTime()));
        statement.setBoolean(2,userDetailsDto.isAdmin());
        statement.setString(3,userDetailsDto.getName());
        statement.setString(4,userDetailsDto.getSurname());
        statement.setString(5,userDetailsDto.getAddress());
        statement.setInt(6,userDetailsDto.getUserId());
        statement.execute();
    }

    @Override
    public UserDetailsDto findUserDetailsById(int id) throws SQLException {
        return jdbcTemplate.queryForObject(FIND_USER_DETAILS_BY_ID, new Object[]{id}, UserDetailsDto.class);
//        return jdbcTemplate.queryForObject(FIND_USER_DETAILS_BY_ID,  new Statement setInt(1,id), UserDetailsDto.class);
//                return jdbcTemplate.queryForObject(FIND_USER_DETAILS_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<UserDetailsDto>());
//                return jdbcTemplate.queryForObject(FIND_USER_DETAILS_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<UserDetailsDto>());
    }

    @Override
    public UserDetailsDto findUserDetailsByName(String name) {
        return null;
    }



    @Override
    public void deleteUserDetails(int id) {

    }

    @Override
    public void updateUserDetails(UserDetailsDto userDetailsDto) {
    }
}
