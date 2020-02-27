package com.skc.adminweb.service;

import com.skc.adminweb.model.entity.AdminUser;
import com.skc.adminweb.model.entity.mapper.AdminUserMapper;
import com.skc.adminweb.repository.AdminUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class AdminUserServiceTests {

    @InjectMocks
    private AdminUserService adminUserService;

    @Mock
    private AdminUserMapper adminUserMapper;

    @Mock
    private AdminUserRepository adminUserRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWithMybatis() {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser01");

        given(adminUserMapper.getAdminUser(1L)).willReturn(adminUser);

        AdminUser adminUserWithMybatis = adminUserService.getAdminUserWithMybatis(1L);

        assertThat(adminUserWithMybatis.getAccount()).isEqualTo("AdminUser01");
    }

    @Test
    public void getWithJpa() {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser01");

        given(adminUserRepository.findById(1L)).willReturn(Optional.of(adminUser));

        AdminUser adminUserWithJpa = adminUserService.getAdminUserWithJpa(1L);

        assertThat(adminUserWithJpa.getAccount()).isEqualTo("AdminUser01");
    }
}