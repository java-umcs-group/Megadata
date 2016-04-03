package pl.skni.java.umcs.group;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.repository.AuthorityRepository;
import pl.skni.java.umcs.group.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@EntityScan(basePackages = {"pl.skni.java.umcs.group"})
@ContextConfiguration(locations = "classpath*:META-INF/spring/springTestConfig.xml")
public class ItTestHelper {

	@Autowired
	protected UserService userService;

	@Autowired
	protected AuthorityRepository authorityRepository;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() throws Exception {
		//wartosci slownikowe
		authorityRepository.save(new Authority(Role.ROLE_ADMIN));
		authorityRepository.save(new Authority(Role.ROLE_USER));
	}
}
