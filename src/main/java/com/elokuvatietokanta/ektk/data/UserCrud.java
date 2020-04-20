package com.elokuvatietokanta.ektk.data;

import com.elokuvatietokanta.ektk.model.User;
import com.elokuvatietokanta.ektk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class UserCrud {

    private static final Logger log = LoggerFactory.getLogger(UserCrud.class);

    @Bean
    public CommandLineRunner userDemo(UserRepository userRepository){
        return (args) -> {
            log.info("STATUS OK !!!");
        };
    }
}
