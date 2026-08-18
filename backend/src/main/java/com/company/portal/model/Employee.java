package com.company.portal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String fullName;
    @NotBlank @Column(nullable = false)
    private String position;
    @Email @NotBlank @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    @ManyToOne(optional = false) private Department department;

    public Employee() {}
    public Employee(String fullName, String position, String email, String phone, Department department) {
        this.fullName = fullName; this.position = position; this.email = email; this.phone = phone; this.department = department;
    }
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
