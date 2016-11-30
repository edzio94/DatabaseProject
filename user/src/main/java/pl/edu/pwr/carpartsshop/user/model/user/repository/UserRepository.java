package pl.edu.pwr.carpartsshop.user.model.user.repository;

import pl.edu.pwr.carpartsshop.user.model.user.dto.UserDto;

import java.sql.SQLException;

/**
 * Created by lukasz on 11/23/16.
 */
public interface  UserRepository {
    final String SAVE_USER_IN_DATABASE = "INSERT INTO USER(username,password) VALUES(?,?)";
    String FIND_USER_ID_BY_USERANME = "SELECT id FROM USER WHERE USERNAME = ?";
    void saveUser(UserDto userDto) throws SQLException;
    int findUserIdByUsername(String username);
    void deleteUser(UserDto userDto);
}
