package com.ekiasari.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ekiasari.springboot.tutorial.entity.Department;
import com.ekiasari.springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department = Department.builder()
        .departmentId(1L)
        .departmentName("IT")
        .departmentAddress("Serang")
        .departmentCode("IT-02")
        .build();

    Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
  }

  @Test
  @DisplayName("Get data based on valid department name")
  void testFetchDepartmentByName() {
    String departmentName = "IT";
    Department found = departmentService.fetchDepartmentByName(departmentName);
    assertEquals(departmentName, found.getDepartmentName());
  }

}
