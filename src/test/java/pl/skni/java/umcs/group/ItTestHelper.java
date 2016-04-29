package pl.skni.java.umcs.group;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.skni.java.umcs.group.transaction.service.TransactionService;
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

    @Autowired
    protected TransactionService transactionService;

    @Test
    public void contextLoads() {
    }
}
