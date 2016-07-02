package pl.skni.java.umcs.group.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MegadataApplication {

    public static void main(String[] args) {
        SpringApplication.run("classpath:META-INF/spring/springConfig.xml", args);
        System.out.println("Application is running");
    }
}
