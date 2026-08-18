package com.company.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PortalControllerTest {
    @Autowired MockMvc mvc;
    @Test void returnsSeededAnnouncements() throws Exception { mvc.perform(get("/api/announcements")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2)))); }
    @Test void createsDepartment() throws Exception { mvc.perform(post("/api/departments").contentType("application/json").content("{\"name\":\"Finance\",\"description\":\"Budgeting\"}")) .andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Finance")); }
    @Test void validatesEmployeeDepartment() throws Exception { mvc.perform(post("/api/employees").contentType("application/json").content("{\"fullName\":\"Test User\",\"position\":\"QA\",\"email\":\"qa@company.local\",\"departmentId\":999}")) .andExpect(status().isBadRequest()); }
}
