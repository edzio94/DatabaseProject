package pl.edu.pwr.carpartsshop.user.model.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.user.model.user.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.model.user.repository.UserRepository;

/**
 * Created by lukasz on 11/23/16.
 */
@Service
public class UserService implements UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(UserDto userDto) {
        jdbcTemplate.execute("INSERT INTO USER VALUES (?,?,?)");
    }

    @Override
    public void deleteUser(UserDto userDto) {

    }
}
