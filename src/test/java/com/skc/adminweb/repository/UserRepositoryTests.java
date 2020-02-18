package com.skc.adminweb.repository;

import com.skc.adminweb.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("test");
        user.setEmail("test@exmaple.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("testUser");

        User save = repository.save(user);
        System.out.println("newUser: " + save);
    }
}