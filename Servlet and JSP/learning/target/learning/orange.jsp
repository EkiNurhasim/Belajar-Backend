<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <%@ page import="import java.util.*"  %>
    <%! int num1 = 10;  %>
    <% num1 = num1 + num1;  %>
    <%= num1;  %>
  </body>
</html>
