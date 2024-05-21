package com.ekiasari.springdatajpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ekiasari.springdatajpa.tutorial.entity.Course;

@SpringBootTest
public class CourseRepositoryTest {

  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println(courses);
  }

  @Test
  public void pagination() {
    Pageable page = PageRequest.of(0, 4);

    List<Course> courses = courseRepository.findAll(page).getContent();

    Long totalElement = courseRepository.findAll(page).getTotalElements();
    Long totalPages = (long) courseRepository.findAll(page).getTotalPages();

    System.out.println("totalElement : " + totalElement);
    System.out.println("totalPages : " + totalPages);
    System.out.println(courses);
  }

  @Test
  public void sorting() {
    Pageable page = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

    List<Course> courses = courseRepository.findAll(page).getContent();
    System.out.println(courses);
  }

  @Test
  public void findByTitleContaining() {
    Pageable page = PageRequest.of(0, 10);
    List<Course> courses = courseRepository.findByTitleContaining("D", page).getContent();
    System.out.println(courses);
  }
}
