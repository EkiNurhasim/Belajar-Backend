package com.ekiasari.springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekiasari.springboot.tutorial.entity.Department;
import com.ekiasari.springboot.tutorial.error.DepartmentNotFoundException;
import com.ekiasari.springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public List<Department> fetchDepartmentsList() {
    return departmentRepository.findAll();
  }

  @Override
  public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
    Optional<Department> department = departmentRepository.findById(id);

    if (!department.isPresent()) {
      throw new DepartmentNotFoundException("DEPARTMENT PAGE NOT FOUND");
    }

    return department.get();
  }

  @Override
  public void deleteDepartmentById(Long id) {
    departmentRepository.deleteById(id);
  }

  @Override
  public Department updateDepartment(Long id, Department department) {
    Department tempDB = departmentRepository.findById(id).get();

    if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
      tempDB.setDepartmentName(department.getDepartmentName());
    }
    if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
      tempDB.setDepartmentAddress(department.getDepartmentAddress());
    }
    if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
      tempDB.setDepartmentCode(department.getDepartmentCode());
    }

    return departmentRepository.save(tempDB);
  }

  @Override
  public Department fetchDepartmentByName(String name) {
    return departmentRepository.findByDepartmentNameIgnoreCase(name);
  }

}
