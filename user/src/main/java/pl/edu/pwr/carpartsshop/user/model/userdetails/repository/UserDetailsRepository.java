package pl.edu.pwr.carpartsshop.user.model.userdetails.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;

import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
@Repository
public interface UserDetailsRepository {
    void saveUserDetails(UserDetailsDto userDetailsEntity) throws SQLException;
    UserDetailsDto findUserDetailsById(int id) throws SQLException;
    UserDetailsDto findUserDetailsByName(String name);


}
