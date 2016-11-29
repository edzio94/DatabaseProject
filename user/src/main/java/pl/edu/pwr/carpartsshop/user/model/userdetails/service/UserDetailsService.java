package pl.edu.pwr.carpartsshop.user.model.userdetails.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.model.userdetails.repository.UserDetailsRepository;
import pl.edu.pwr.carpartsshop.user.mapper.user.UserDetailsRowMapper;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.model.userdetails.entity.UserDetailsEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
                .getConnection().prepareStatement("INSERT INTO userdetails VALUES(?,?,?,?,?,?)");
        statement.setInt(1,userDetailsDto.getId());
        statement.setDate(2, new java.sql.Date(userDetailsDto.getCreated().getTime()));
        statement.setBoolean(3,userDetailsDto.isAdmin());
        statement.setString(4,userDetailsDto.getName());
        statement.setString(5,userDetailsDto.getSurname());
        statement.setString(6,userDetailsDto.getAddress());
        statement.execute();
    }

    @Override
    public UserDetailsDto findUserDetailsById(int id) throws SQLException {
        List<UserDetailsEntity> query = jdbcTemplate.query("SELECT * FROM userdetails WHERE ID = ?", new Object[]{id}, new UserDetailsRowMapper());
        if(query.size() == 0)
            return null;
            else {
            UserDetailsDto userDetailsDto = new ModelMapper().map(query.get(0), UserDetailsDto.class);
            return userDetailsDto;
        }
    }

    @Override
    public UserDetailsDto findUserDetailsByName(String name) {
        return null;
    }
}
