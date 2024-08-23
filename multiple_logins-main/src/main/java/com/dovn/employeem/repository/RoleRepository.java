package com.dovn.employeem.repository;

import com.dovn.employeem.entity.ERole;
import com.dovn.employeem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(ERole role);
}
