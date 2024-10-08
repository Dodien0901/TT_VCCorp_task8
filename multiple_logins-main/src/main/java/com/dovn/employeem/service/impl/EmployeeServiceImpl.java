package com.dovn.employeem.service.impl;

import com.dovn.employeem.dto.request.EmployeeDto;
import com.dovn.employeem.dto.request.LoginRequest;
import com.dovn.employeem.entity.Department;
import com.dovn.employeem.entity.ERole;
import com.dovn.employeem.entity.Employee;
import com.dovn.employeem.entity.Role;
import com.dovn.employeem.repository.EmployeeRepository;
import com.dovn.employeem.service.DepartmentService;
import com.dovn.employeem.service.EmployeeService;
import com.dovn.employeem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;
    private final DepartmentService departmentService;
    private final LdapTemplate ldapTemplate;

    // Sử dụng ConcurrentHashMap để lưu trữ khóa TOTP
    private final ConcurrentHashMap<String, String> employeeOtpKeys = new ConcurrentHashMap<>();

    @Override
    public Employee register(EmployeeDto dto) {
        Set<Role> roles = new HashSet<>();
        Role role;
        if(dto.getRole() == null) {
            role = roleService.getRoleByName(ERole.INTERNSHIP);
            roles.add(role);
        }else{
            role = roleService.getRoleByName(dto.getRole());
            roles.add(role);
        }
        Department department = departmentService.findById(dto.getDepartmentId());

        Employee employee = Employee.builder()
                .userName(dto.getUserName())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .department(department)
                .listRole(roles)
                .build();
        return employeeRepository.save(employee);
    }

    @Override
    public boolean login(LoginRequest request) {
        Employee employee = employeeRepository.findByName(request.getUserName());
        if (employee != null) {
            return employee.getPassword().equals(request.getPassword());
        }
        return false;
    }
    // Lưu khóa TOTP vào ConcurrentHashMap
    @Override
    public void saveSecretKeyForEmployee(String username, String secretKey) {
        employeeOtpKeys.put(username, secretKey);
    }

    // Lấy khóa TOTP từ ConcurrentHashMap
    @Override
    public String getSecretKeyForEmployee(String username) {
        return employeeOtpKeys.get(username);
    }

    @Override
    public List<String> search(String username) {
        return ldapTemplate.search(
                "ou=people,dc=springframework,dc=org",
                "(cn=" + username + ")",
                (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get()
        );
    }
}
