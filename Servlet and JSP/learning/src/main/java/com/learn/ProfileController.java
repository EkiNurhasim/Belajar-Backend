package com.learn;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet{

  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
    List<ProfileObject> po = Arrays.asList(new ProfileObject("Orange", 12, "serang"), new ProfileObject("white", 23, "cilegon"), new ProfileObject("black", 10, "pandeglang"));
    req.setAttribute("profiles", po);
    RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
    rd.forward(req, res);
  }

}
