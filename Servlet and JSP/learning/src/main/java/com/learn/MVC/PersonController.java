package com.learn.MVC;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/person")
public class PersonController extends HttpServlet{
    
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
    int id = Integer.parseInt(req.getParameter("id"));
    String nama = req.getParameter("nama");
    int nim = Integer.parseInt(req.getParameter("nim"));
    String alamat = req.getParameter("alamat");      
    
    PersonDAO personDAO = new PersonDAO();
    Person person = new Person();    
    person.setId(id);
    person.setNama(nama);
    person.setNim(nim);
    person.setAlamat(alamat);

    int result = personDAO.addPerson(person);
    if(result < 0)          
      resp.sendRedirect("failed.jsp");
    
    req.setAttribute("id", person.getId());
    RequestDispatcher rd = req.getRequestDispatcher("showPerson");
    rd.forward(req, resp);

  }

}
