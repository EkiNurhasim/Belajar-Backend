<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>

    <%
    
    Class.forName("com.mysql.cj.jdbc.Driver");    
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_mahasiswa", "root", "");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from tb_mahasiswa where id = 1");
    rs.next();

    %>

    ID : <%= rs.getString(1)%> <br/>
    Name : <%= rs.getString(2)%> <br/>
    NIM :  <%= rs.getString(3)%> <br/>
    Alamat :  <%= rs.getString(4)%> <br/>


    <c:forEach items="${profiles}" var="profile">
      <p>${profile.name}</p>
      <p>${profile.age}</p>
      <p>${profile.address}</p><br/>
    </c:forEach>

  </body>
</html>
