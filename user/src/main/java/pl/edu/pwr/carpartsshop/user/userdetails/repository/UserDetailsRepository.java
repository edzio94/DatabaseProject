package pl.edu.pwr.carpartsshop.user.userdetails.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.sql.SQLException;

/**
 * Created by lukasz on 11/29/16.
 */
@Repository
public interface UserDetailsRepository {
    String SAVE_USER_DETAILS = "INSERT INTO userdetails(created,is_admin,name,surname,address,user_id) VALUES (?,?,?,?,?,?)";
    final String FIND_USER_DETAILS_BY_ID = "SELECT * FROM userdetails WHERE id = ?";
    void saveUserDetails(UserDetailsDto userDetailsEntity) throws SQLException;
    UserDetailsDto findUserDetailsById(int id) throws SQLException;
    UserDetailsDto findUserDetailsByName(String name);
    void deleteUserDetails(int id);
    void updateUserDetails(UserDetailsDto userDetailsDto);


}
