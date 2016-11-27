package pl.edu.pwr.cartpartsshop.user.repository;

import pl.edu.pwr.cartpartsshop.user.model.dto.UserDto;

/**
 * Created by lukasz on 11/23/16.
 */
public interface  UserRepository {
    void saveUser(UserDto userDto);
    void deleteUser(UserDto userDto);
}
