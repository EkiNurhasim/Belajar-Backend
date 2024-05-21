package com.exa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {   

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        // EntityManager em = emf.createEntityManager();
        // em.persist(new Object());
        // em.find(new Objeect());

        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_mahasiswa", "root", "");
        // PreparedStatement ps = con.prepareStatement("insert into tb_mahasiswa values (?,?,?,?)");
        // ps.setInt(1, 12);
        // ps.setString(2, "ximofu");
        // ps.setInt(3, 13231124);
        // ps.setString(4, "serang");
        // ps.executeUpdate();

        // Laptop laptop = new Laptop();
        // laptop.setLid(104);
        // laptop.setLname("Acer");
        
        // Student student = new Student();
        // student.setRollid(1);
        // student.setName("migyu");
        // student.setMarks(78);
        // student.getLaptop().add(laptop);
        // laptop.setStudent(student);  

        // Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        // SessionFactory sf = config.buildSessionFactory();
        // Session session = sf.openSession();
        // Transaction tx = session.beginTransaction();        
        // Query q = session.createQuery("from Student where rollid=1", Student.class);
        // Query q1 = session.createQuery("from Laptop", Laptop.class);              

        // student = (Student) q.uniqueResult();
        // List<Laptop> lists = q1.list();
        
        // System.out.println(student);
        // for(Laptop l: lists){
        //     System.out.println(l);
        // }
        // System.out.println("--------------------------------");

        // // session.persist(student);   
        // Laptop lap = session.get(Laptop.class, 102) ;
        // System.out.println(lap);

        // tx.commit();
    }

    public static void run(){
        AlienName aName = new AlienName();
        aName.setFname("Mogyu ");     
        aName.setMidname("ugu ");
        aName.setLname("mufa");

        Alien alien = new Alien();  
        alien.setAid(101);
        alien.setAname(aName);
        alien.setColor("orange");

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();        
        session.persist(alien); // Create table and insert some value to it
        // alien = (Alien) session.get(Alien.class, 101);
        tx.commit();
        System.out.println(alien);
    }
}
