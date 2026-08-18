package com.company.portal.controller;

import com.company.portal.dto.EmployeeRequest;
import com.company.portal.model.*;
import com.company.portal.repository.*;
import com.company.portal.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class PortalController {
    private final DepartmentRepository departments;
    private final AnnouncementRepository announcements;
    private final PortalDocumentRepository documents;
    private final EmployeeService employeeService;
    public PortalController(DepartmentRepository departments, AnnouncementRepository announcements, PortalDocumentRepository documents, EmployeeService employeeService) {
        this.departments = departments; this.announcements = announcements; this.documents = documents; this.employeeService = employeeService;
    }
    @GetMapping("/health") public String health() { return "OK"; }
    @GetMapping("/departments") public List<Department> departments() { return departments.findAll(); }
    @PostMapping("/departments") public Department createDepartment(@Valid @RequestBody Department department) { return departments.save(department); }
    @GetMapping("/employees") public List<Employee> employees(@RequestParam(required = false) String q) { return employeeService.search(q); }
    @PostMapping("/employees") public Employee createEmployee(@Valid @RequestBody EmployeeRequest request) { return employeeService.create(request); }
    @GetMapping("/announcements") public List<Announcement> announcements() { return announcements.findAllByOrderByPublishedAtDesc(); }
    @PostMapping("/announcements") public Announcement createAnnouncement(@Valid @RequestBody Announcement announcement) { return announcements.save(announcement); }
    @GetMapping("/documents") public List<PortalDocument> documents(@RequestParam(required = false) String category) { return category == null || category.isBlank() ? documents.findAll() : documents.findByCategoryIgnoreCase(category); }
    @PostMapping("/documents") public PortalDocument createDocument(@Valid @RequestBody PortalDocument document) { return documents.save(document); }
}
