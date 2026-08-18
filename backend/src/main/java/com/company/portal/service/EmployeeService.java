package com.company.portal.service;

import com.company.portal.dto.EmployeeRequest;
import com.company.portal.model.Employee;
import com.company.portal.repository.DepartmentRepository;
import com.company.portal.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employees;
    private final DepartmentRepository departments;
    public EmployeeService(EmployeeRepository employees, DepartmentRepository departments) { this.employees = employees; this.departments = departments; }
    public List<Employee> search(String q) { return q == null || q.isBlank() ? employees.findAll() : employees.findByFullNameContainingIgnoreCaseOrPositionContainingIgnoreCase(q, q); }
    public Employee create(EmployeeRequest request) {
        var department = departments.findById(request.departmentId()).orElseThrow(() -> new IllegalArgumentException("Department not found"));
        return employees.save(new Employee(request.fullName(), request.position(), request.email(), request.phone(), department));
    }
}
