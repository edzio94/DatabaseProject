package pl.edu.pwr.carpartsshop.user.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.repository.UserRepository;
import pl.edu.pwr.carpartsshop.user.userdetails.service.UserDetailsService;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by lukasz on 11/23/16.
 */
@Service
public class UserService implements UserRepository{

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void saveUser(UserDto userDto) throws SQLException {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        logger.debug("Adding new user");
        simpleJdbcInsert.withTableName("USER").usingGeneratedKeyColumns("id");
        HashMap<String,Object> params = new HashMap<>();
        params.put("username",userDto.getUsername());
        params.put("password",userDto.getPassword());
        Number number = simpleJdbcInsert.executeAndReturnKey(params);
        userDto.getUserDetailsDto().setUserId(number.intValue());
        userDetailsService.saveUserDetails(userDto.getUserDetailsDto());
    }

    @Override
    public int findUserIdByUsername(String username) {
        Object[] params = new Object[] {new String(username)};
        System.out.println("USERNAME: "+username);
        return jdbcTemplate.queryForObject(FIND_USER_ID_BY_USERANME, params,Integer.class);

    }

    @Override
    public void deleteUser(UserDto userDto) {

    }
}
