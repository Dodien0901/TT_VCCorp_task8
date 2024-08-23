package com.dovn.employeem.service.impl;

import com.dovn.employeem.entity.ERole;
import com.dovn.employeem.entity.Role;
import com.dovn.employeem.repository.RoleRepository;
import com.dovn.employeem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public Role getRoleByName(ERole role) {
        return roleRepository.findByName(role);
    }
}
