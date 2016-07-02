package pl.skni.java.umcs.group.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;

/**
 * Created by Jakub Pyda on 03.04.2016.
 */
interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findByRole(Role role);
}
