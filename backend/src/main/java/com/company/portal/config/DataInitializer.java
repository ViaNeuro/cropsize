package com.company.portal.config;

import com.company.portal.model.*;
import com.company.portal.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final DepartmentRepository departments; private final EmployeeRepository employees; private final AnnouncementRepository announcements; private final PortalDocumentRepository documents;
    public DataInitializer(DepartmentRepository departments, EmployeeRepository employees, AnnouncementRepository announcements, PortalDocumentRepository documents) { this.departments = departments; this.employees = employees; this.announcements = announcements; this.documents = documents; }
    @Override public void run(String... args) {
        if (departments.count() > 0) return;
        var it = departments.save(new Department("IT", "Инфраструктура, сервис-деск и внутренние системы"));
        var hr = departments.save(new Department("HR", "Персонал, адаптация и корпоративная культура"));
        employees.save(new Employee("Анна Смирнова", "Руководитель IT", "anna.smirnova@company.local", "+7 495 100-10-10", it));
        employees.save(new Employee("Иван Петров", "HR бизнес-партнер", "ivan.petrov@company.local", "+7 495 100-10-11", hr));
        announcements.save(new Announcement("Запуск корпоративного портала", "Портал объединяет новости, справочник сотрудников, документы и сервисы предприятия.", LocalDateTime.now().minusDays(1)));
        announcements.save(new Announcement("Плановые работы", "В пятницу с 20:00 до 22:00 возможны кратковременные перерывы внутренних сервисов.", LocalDateTime.now()));
        documents.save(new PortalDocument("Политика информационной безопасности", "Регламенты", "/docs/security-policy.pdf"));
        documents.save(new PortalDocument("Заявка в сервис-деск", "Формы", "/docs/service-desk-request.docx"));
    }
}
