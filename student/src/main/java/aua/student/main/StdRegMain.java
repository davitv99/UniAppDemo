package aua.student.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableMongoRepositories("aua.student.repository")
@ComponentScan(basePackages = {"aua.student"})
@EntityScan("aua.student.model")
@EnableAsync
public class StdRegMain {

    public static void main(String[] args) {
        SpringApplication.run(StdRegMain.class, args);
    }

}
