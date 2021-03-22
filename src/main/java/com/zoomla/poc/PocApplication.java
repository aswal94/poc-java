package com.zoomla.poc;

import com.zoomla.poc.entities.User;
import com.zoomla.poc.respositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocApplication {

    private static final Logger log = LoggerFactory.getLogger(PocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PocApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new User("Rohit Mewar", "rohit", "rohit@123"));
            userRepository.save(new User("Amit Aswal", "amit", "amit@123"));
            userRepository.save(new User("Shubham Kumar", "shubham", "shubham@123"));

            log.info("-------------------------");
            log.info("List all users");
            userRepository.findAll().forEach(user -> {
                log.info(user.toString());
            });

            log.info("");

            // fetch user by id
            User user = userRepository.findById(1L);
            log.info(user.toString());
            log.info("");

            log.info("Fetch user by full name");

            userRepository.findByFullName("Rohit Mewar").forEach(u -> {
                log.info(u.toString());
            });
            log.info("");

        };
    }

}
