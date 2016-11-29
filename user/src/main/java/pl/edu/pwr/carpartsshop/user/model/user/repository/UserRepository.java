package pl.edu.pwr.carpartsshop.user.model.user.repository;

import pl.edu.pwr.carpartsshop.user.model.user.dto.UserDto;

/**
 * Created by lukasz on 11/23/16.
 */
public interface  UserRepository {
    void saveUser(UserDto userDto);
    void deleteUser(UserDto userDto);
}
