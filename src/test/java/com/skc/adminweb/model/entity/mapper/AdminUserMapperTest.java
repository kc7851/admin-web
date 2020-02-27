package com.skc.adminweb.model.entity.mapper;

import com.skc.adminweb.model.entity.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserMapperTest {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Test
    public void get() {
        AdminUser adminUser = adminUserMapper.getAdminUser(1L);

        assertThat(adminUser.getAccount()).isEqualTo("AdminUser01");
    }

}