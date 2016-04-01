package pl.skni.java.umcs.group.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by kuba on 10.02.16.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"pl.skni.java.umcs.group"})
@EnableJpaRepositories(basePackages = {"pl.skni.java.umcs.group"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
