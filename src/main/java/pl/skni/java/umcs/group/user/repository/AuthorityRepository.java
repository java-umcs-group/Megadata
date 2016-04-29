package pl.skni.java.umcs.group.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;

/**
 * Created by Jakub Pyda on 03.04.2016.
 */
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {

    Authority findByRole(Role role);
}
