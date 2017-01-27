package pl.edu.pwr.carpartsshop.user.userdetails.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.userdetails.model.entity.UserDetailsEntity;
import pl.edu.pwr.carpartsshop.user.userdetails.repository.UserDetailsRepository;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    private ModelMapper mapper = new ModelMapper();


    public void saveUserDetails(UserDetailsDto userDetailsDto) throws SQLException {
        UserDetailsEntity map = mapper.map(userDetailsDto, UserDetailsEntity.class);
        userDetailsRepository.save(map);
    }

    public UserDetailsDto findUserDetailsById(int id) throws SQLException {
        return null;
    }

    public UserDetailsDto findUserDetailsByName(String name) {
        return null;
    }



    public void deleteUserDetails(int id) {

    }

    public void updateUserDetails(UserDetailsDto userDetailsDto) {
    }
}
