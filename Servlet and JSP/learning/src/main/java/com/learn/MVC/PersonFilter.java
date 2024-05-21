package com.learn.MVC;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/person")
public class PersonFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
    HttpServletRequest req = (HttpServletRequest) request;
    int id = Integer.parseInt(req.getParameter("id"));

    if(id > 0){
      chain.doFilter(request, response);
    }else{
      response.getWriter().println("YOUR ID IS INVALID : " + id);
    }
   
  }
  
}
