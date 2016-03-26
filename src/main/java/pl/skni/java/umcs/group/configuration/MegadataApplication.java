package pl.skni.java.umcs.group.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MegadataApplication {

	public static void main(String[] args) {
		SpringApplication.run("classpath:META-INF/spring/springConfig.xml", args);
	}
}
