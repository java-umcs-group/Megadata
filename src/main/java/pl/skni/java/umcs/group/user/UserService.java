package pl.skni.java.umcs.group.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.model.User;

/**
 * Created by Jakub Pyda on 31.03.2016.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public User getUserById(Integer userId) {
        return userRepository.findOne(userId);
    }

    public User createUser(String userName, String password, String firstName, String lastName, String email,
                           String address, String phoneNumber, String zipCode, String city) {

        Authority authority = authorityRepository.findByRole(Role.ROLE_USER);
        User user = new User(userName, password, authority, firstName, lastName, email, address,
                phoneNumber, zipCode, city);

        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName);
    }
}
