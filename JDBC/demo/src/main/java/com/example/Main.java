package com.example;


public class Main {
    public static void main(String[] args){

        StudentDAO sd = new StudentDAO();
        sd.connect();        

        // Student s1 = new Student();
        // s1.nama = "Verdy Yusufrani";
        // s1.nim = 11232451;
        // s1.alamat = "Anyer";
        // sd.updateStudent(6, s1);
        // sd.deleteStudent(6);
        
        // Student newStudent = new Student();
        // newStudent.id = 6;
        // newStudent.nama = "Test";
        // newStudent.nim = 11234512;
        // newStudent.alamat = "Palembang";
        // sd.addStudent(newStudent);
        // sd.deleteStudent(5);
        
        // Student s = sd.getStudentById(1);
        // System.out.println(s.id + " | " + s.nama + " | " + s.nim + " | " + s.alamat);
        // System.out.println("---------------------------------------------------------------------------");
        
        sd.getAllStudent();
        sd.connectClose();
    }
}