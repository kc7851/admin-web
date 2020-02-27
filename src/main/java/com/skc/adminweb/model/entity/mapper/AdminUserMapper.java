package com.skc.adminweb.model.entity.mapper;

import com.skc.adminweb.model.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {

    AdminUser getAdminUser(Long id);

}
