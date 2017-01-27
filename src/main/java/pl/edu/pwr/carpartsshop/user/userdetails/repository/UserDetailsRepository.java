package pl.edu.pwr.carpartsshop.user.userdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.userdetails.model.entity.UserDetailsEntity;

import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity,Integer> {

}
