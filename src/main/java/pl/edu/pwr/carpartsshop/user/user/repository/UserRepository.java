package pl.edu.pwr.carpartsshop.user.user.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.model.entity.UserEntity;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by lukasz on 11/23/16.
 */
public interface  UserRepository extends CrudRepository<UserEntity,String> {
}
