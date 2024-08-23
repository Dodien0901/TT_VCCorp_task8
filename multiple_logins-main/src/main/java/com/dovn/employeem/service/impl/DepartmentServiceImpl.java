package com.dovn.employeem.service.impl;

import com.dovn.employeem.entity.Department;
import com.dovn.employeem.repository.DepartmentRepository;
import com.dovn.employeem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public Department findById(String id) {
        return departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
    }
}
