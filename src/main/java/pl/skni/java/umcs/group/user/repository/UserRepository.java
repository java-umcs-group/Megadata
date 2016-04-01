package pl.skni.java.umcs.group.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.user.model.User;

/**
 * Created by kuba on 01.04.16.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
