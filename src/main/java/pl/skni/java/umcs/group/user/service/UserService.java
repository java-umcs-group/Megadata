package pl.skni.java.umcs.group.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.skni.java.umcs.group.user.model.User;

/**
 * Created by Jakub Pyda on 31.03.2016.
 */
public interface UserService extends UserDetailsService {
    User getUserById(Integer userId);

    User createUser(String userName, String password, String firstName, String lastName, String email,
                    String address, String phoneNumber, String zipCode, String city);
}
