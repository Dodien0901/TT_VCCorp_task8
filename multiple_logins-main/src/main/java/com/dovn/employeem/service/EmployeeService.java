package com.dovn.employeem.service;

import com.dovn.employeem.dto.request.EmployeeDto;
import com.dovn.employeem.dto.request.LoginRequest;
import com.dovn.employeem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee register(EmployeeDto employeeDto);
    boolean login(LoginRequest request);
    void saveSecretKeyForEmployee(String username, String secretKey);
    String getSecretKeyForEmployee(String username);
    List<String> search(String username);
}
