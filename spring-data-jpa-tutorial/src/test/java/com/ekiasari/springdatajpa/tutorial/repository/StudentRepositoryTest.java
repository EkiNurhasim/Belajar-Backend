package com.ekiasari.springdatajpa.tutorial.repository;

import com.ekiasari.springdatajpa.tutorial.entity.Guardian;
import com.ekiasari.springdatajpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("orange@gmail.com")
                .firstName("orange")
                .lastName("white").build();
//                .guardianName("pupu")
//                .guardianEmail("guard@gmail.com")
//                .guardianMobile("234567726").build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("gigi@gmail.com")
                .name("oraopra")
                .mobile("423421")
                .build();

        Student student = Student.builder()
                .firstName("Migyu")
                .emailId("migyu.com")
                .lastName("nono")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> student = studentRepository.findAll();
        System.out.println("Student List : " + student);
    }

    @Test
    public void findStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("orange");
        System.out.println(students);
    }

    @Test
    public void findStudentByFirstNameCharacter(){
        List<Student> students = studentRepository.findByFirstNameContaining("ge");
        System.out.println(students);
    }

    @Test
    public void findByLastNameNotNull(){
        List<Student> s = studentRepository.findByLastNameNotNull();
        System.out.println(s);
    }

    @Test
    public void findByGuardianName(){
        List<Student> s = studentRepository.findByGuardianName("pupu");
        System.out.println(s);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student s = studentRepository.getStudentByEmailAddress("migyu.com");
        System.out.println(s);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student s = studentRepository.getStudentByEmailAddressNative("migyu.com");
        System.out.println(s);
    }

    @Test
    public void getStudentByEmailAddressNativeParam(){
        Student s = studentRepository.getStudentByEmailAddressNativeNameParam("migyu.com");
        System.out.println(s);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int result = studentRepository.updateStudentNameByEmailId("It's not orange anymore", "orange@gmail.com");
        System.out.println(result);
    }
}