package com.ekiasari.springdatajpa.tutorial.repository;

import com.ekiasari.springdatajpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // JPQL QUERY
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);

    // NATIVE QUERY
    @Query(value = "select * from tbl_student where email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "select * from tbl_student where email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNameParam(@Param("emailId") String emailId);

    @Modifying // use @Modifying if you want to modified value in database
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);

}
