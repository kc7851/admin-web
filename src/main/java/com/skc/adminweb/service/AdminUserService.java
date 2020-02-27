package com.skc.adminweb.service;

import com.skc.adminweb.model.entity.AdminUser;
import com.skc.adminweb.model.entity.mapper.AdminUserMapper;
import com.skc.adminweb.repository.AdminUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminUserService {

    private AdminUserMapper adminUserMapper;

    private AdminUserRepository adminUserRepository;

    public AdminUser getAdminUserWithMybatis(Long id) {
        AdminUser adminUser = adminUserMapper.getAdminUser(id);
        return adminUser;
    }

    public AdminUser getAdminUserWithJpa(Long id) {
        AdminUser adminUser = adminUserRepository.findById(id).orElse(null);

        return adminUser;
    }
}
