<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 27.05.2023
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="src.Person"%>
<html>
<head>
    <title>Person</title>
</head>
<body>
<p>

    <%Person person = (Person) session.getAttribute("person"); %>

<p> Имя : <%= person.getName()%></p>
<p> Возраст : <%= person.getAge()%></p>

</p>
</body>
</html>
