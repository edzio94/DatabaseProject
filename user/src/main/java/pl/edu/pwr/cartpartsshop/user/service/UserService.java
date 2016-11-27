package pl.edu.pwr.cartpartsshop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.cartpartsshop.user.model.dto.UserDto;
import pl.edu.pwr.cartpartsshop.user.repository.UserRepository;

/**
 * Created by lukasz on 11/23/16.
 */
@Service
public class UserService implements UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(UserDto userDto) {
        jdbcTemplate.execute("");
    }

    @Override
    public void deleteUser(UserDto userDto) {

    }
}
