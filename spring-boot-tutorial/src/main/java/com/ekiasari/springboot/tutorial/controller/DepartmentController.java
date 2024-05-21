package com.ekiasari.springboot.tutorial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekiasari.springboot.tutorial.entity.Department;
import com.ekiasari.springboot.tutorial.error.DepartmentNotFoundException;
import com.ekiasari.springboot.tutorial.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @Autowired
  private DepartmentService departmentService;

  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {
    LOGGER.info("inside saveDepartment /departments @PostMapping");
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentsList() {
    LOGGER.info("Inside fetchDepartmentsList /departments @GetMapping");
    return departmentService.fetchDepartmentsList();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
    LOGGER.info("Inside fetchDepartmentById /departments/{id} @GetMapping");
    return departmentService.fetchDepartmentById(id);
  }

  @DeleteMapping("departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long id) {
    LOGGER.info("Inside deleteDepartmentById /departments/{id} @DeleteMapping");
    departmentService.deleteDepartmentById(id);
    return "Department with ID : " + id + " has Been Deleted";
  }

  @PutMapping("/departments/{id}")
  public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
    LOGGER.info("Inside updateDepartment /departments/{id} @PutMapping");
    return departmentService.updateDepartment(id, department);
  }

  @GetMapping("/departments/name/{name}")
  public Department fetchDepartmentByName(@PathVariable String name) {
    LOGGER.info("Inside fetchDepartmentByName /departments/name/{name} @GetMapping");
    return departmentService.fetchDepartmentByName(name);
  }

}
