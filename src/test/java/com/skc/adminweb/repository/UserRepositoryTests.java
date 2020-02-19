package com.skc.adminweb.repository;

import com.skc.adminweb.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("test2");
        user.setEmail("test2@exmaple.com");
        user.setPhoneNumber("010-1111-2222");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("testUser2");

        User save = repository.save(user);
        System.out.println("newUser: " + save);
    }

    @Test
    public void read() {
        Optional<User> user = repository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("User: " + selectUser);
        });

        assertThat(user.get().getAccount()).isEqualTo("test");
    }

    @Test
    public void update() {
        Optional<User> user = repository.findById(2L);

        user.ifPresent(selectUser -> {
           selectUser.setAccount("aaaa");
           selectUser.setUpdatedAt(LocalDateTime.now());
           selectUser.setUpdatedBy("update method()");

           repository.save(selectUser);
        });
    }
}