package com.ekiasari.springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ekiasari.springboot.tutorial.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private TestEntityManager entityManager;

  @BeforeEach
  void setUp() {
    Department department = Department.builder()
        .departmentId(1L)
        .departmentName("CE")
        .departmentAddress("Jakarta")
        .departmentCode("CE-24").build();

    entityManager.persist(department);
  }

  @Test
  void testFindById() {
    Department department = departmentRepository.findById(1L).get();
    assertEquals(department.getDepartmentName(), "CE");
  }
}
