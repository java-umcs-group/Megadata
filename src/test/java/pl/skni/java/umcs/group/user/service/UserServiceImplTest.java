package pl.skni.java.umcs.group.user.service;

import org.junit.Before;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jakub Pyda on 03.04.2016.
 */

public class UserServiceImplTest extends ItTestHelper {

    @Before
    public void setUp() throws Exception {
        //wartosci slownikowe
        authorityRepository.save(new Authority(Role.ROLE_ADMIN));
        authorityRepository.save(new Authority(Role.ROLE_USER));
    }

    @Test
    public void shouldCreateUserAndGetById() {
        //given
        String test = "test";
        String pass = "pass";
        String mail = "mail";
        String address = "address";
        String phoneNumber = "phoneNumber";
        String zipCode = "20-000";
        String city = "Lublin";

        //when
        User user = userService.createUser(test, pass, test, test, mail, address, phoneNumber, zipCode, city);
        User userById = userService.getUserById(user.getUserId());

        //then
        assertThat(userById).isNotNull();
        assertThat(user.getUserId()).isEqualTo(userById.getUserId());
    }

}