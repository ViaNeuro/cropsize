package com.company.portal.repository;
import com.company.portal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> { List<Employee> findByFullNameContainingIgnoreCaseOrPositionContainingIgnoreCase(String name, String position); }
