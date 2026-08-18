package com.company.portal.dto;
import jakarta.validation.constraints.*;
public record EmployeeRequest(@NotBlank String fullName, @NotBlank String position, @Email @NotBlank String email, String phone, @NotNull Long departmentId) {}
