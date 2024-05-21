package com.learn.MVC;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showPerson")
public class PersonSuccessController extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PersonDAO personDAO = new PersonDAO();    
    int personID = (int) req.getAttribute("id");
    Person person = personDAO.showPerson(personID);    

    req.setAttribute("data", person);
    RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
    rd.forward(req, resp);

  }

}
