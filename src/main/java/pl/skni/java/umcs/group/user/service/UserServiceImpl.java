package pl.skni.java.umcs.group.user.service;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.model.User;
import pl.skni.java.umcs.group.user.repository.AuthorityRepository;
import pl.skni.java.umcs.group.user.repository.UserRepository;

/**
 * Created by Jakub Pyda on 31.03.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User createUser(String userName, String password, String firstName, String lastName, String email,
                           String address, String phoneNumber, String zipCode, String city) {

        Authority authority = authorityRepository.findByRole(Role.ROLE_USER);
        User user = new User(userName, password, authority, firstName, lastName, email, address,
                phoneNumber, zipCode, city);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName);
    }
}
