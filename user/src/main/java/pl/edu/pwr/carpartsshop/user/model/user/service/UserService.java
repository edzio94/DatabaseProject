package pl.edu.pwr.carpartsshop.user.model.user.service;

import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.model.user.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.model.user.repository.UserRepository;
import pl.edu.pwr.carpartsshop.user.model.userdetails.service.UserDetailsService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
//
//        PreparedStatement statement = jdbcTemplate.getDataSource()
//                .getConnection().prepareStatement(SAVE_USER_IN_DATABASE);
//        statement.setString(1,userDto.getUsername());
//        statement.setString(2,userDto.getPassword());
//
//        statement.execute();
        System.out.println("AFTER ADDING USER");
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
