package com.ssandyy.jwtspringsecurity;

import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.entity.Role;
import com.ssandyy.jwtspringsecurity.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtspringsecurityApplication implements CommandLineRunner {

    @Autowired
    private MyUserRepository myUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(JwtspringsecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MyUser adminAccount = myUserRepository.findByRole(Role.ADMIN);

        if (adminAccount == null) {
            MyUser user = new MyUser();

            user.setFname("admin");
            user.setLname("admin");
            user.setEmail("admin@admin.com");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            myUserRepository.save(user);
        }
    }
}
