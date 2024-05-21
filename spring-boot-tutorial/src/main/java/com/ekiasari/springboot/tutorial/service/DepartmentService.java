package com.ekiasari.springboot.tutorial.service;

import java.util.List;

import com.ekiasari.springboot.tutorial.entity.Department;
import com.ekiasari.springboot.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

  public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentsList();

  public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long id);

  public Department updateDepartment(Long id, Department department);

  public Department fetchDepartmentByName(String name);

}
