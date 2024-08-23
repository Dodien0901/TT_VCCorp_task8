package com.dovn.employeem.service;

import com.dovn.employeem.entity.ERole;
import com.dovn.employeem.entity.Role;

public interface RoleService {
    Role getRoleByName(ERole role);
}
