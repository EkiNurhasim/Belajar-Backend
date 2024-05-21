package com.ekiasari.springdatajpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekiasari.springdatajpa.tutorial.entity.Teacher;

import jakarta.persistence.Entity;

@Entity
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
