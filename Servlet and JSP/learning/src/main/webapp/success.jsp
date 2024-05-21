<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.learn.MVC.Person"%> 

<html>
  <body>

    <% Person person = (Person) request.getAttribute("data"); %>
    ID : <%= person.getId()%> <br/>
    Name : <%= person.getNama()%> <br/>
    NIM :  <%= person.getNim()%> <br/>
    Alamat :  <%= person.getAlamat()%> <br/>

  </body>
</html>
