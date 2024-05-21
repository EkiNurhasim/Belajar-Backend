package com.learn;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add")
public class AddServlet extends HttpServlet{

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
    int i = Integer.parseInt(req.getParameter("num1"));
    int j = Integer.parseInt(req.getParameter("num2"));

    int k = i + j;

    HttpSession session = req.getSession();
    session.setAttribute("k", k);

    res.sendRedirect("sq");    
    

    // Cookie cookie = new Cookie("k", k + "");
    // res.addCookie(cookie);

    // res.sendRedirect("sq");

    // HttpSession session = req.getSession();
    // session.setAttribute("k", k);
    // res.sendRedirect("sq");

    // res.sendRedirect("sq?k=" + k);

    // req.setAttribute("k", k);
    // RequestDispatcher rq = req.getRequestDispatcher("sq");
    // rq.forward(req, res);
  }

}
