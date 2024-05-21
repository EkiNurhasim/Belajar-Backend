package com.learn;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
  {

    // int result = Integer.parseInt( req.getParameter("k"));
    // HttpSession session = req.getSession();
    // int result = (int) session.getAttribute("k");

    HttpSession session = req.getSession();
    int result = (int) session.getAttribute("k");
    result = result * result;

    res.getWriter().println(result);


    // int result = 0;
    // Cookie cookie[] = req.getCookies();
    // for(Cookie c : cookie){
    //   if(c.getName().equals("k")){
    //     result = Integer.parseInt(c.getValue());
    //   }
    // }

    // result = result * result;
    // res.getWriter().println("Result : " + result);

    // int k = (int) req.getAttribute("k");
    // k = k * 2;
    // res.getWriter().println("Result : " + k);

    // ServletContext ctx = getServletContext();
    // ServletConfig cg = getServletConfig();

    // String name1 = ctx.getInitParameter("name1");
    // String name2 = cg.getInitParameter("name2");

    // res.getWriter().println(name1 + " | " + name2);
  }
}
