<%@ page import="utils.DBConnection" %>
<%@ page import="dao.ChildDao" %>
<%@ page import="model.Child" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="css.jsp" %>
</head>
<body>
    <%@include file="navbar.jsp" %>

    <%
        Connection conn = DBConnection.getConnection();

    %>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Age</th>
          <th scope="col">Gender</th>
          <th scope="col">Group</th>
          <th scope="col">Action</th>

        </tr>
      </thead>
      <tbody>

       <%
            ChildDao dao = new ChildDao(DBConnection.getConnection());
            List<Child> list = dao.getChildren();

            for (Child c: list)
            {%>
               <tr>
               <th><%=c.getName() %></th>
               <td><%=c.getAge() %></td>
               <td><%=c.getGender() %></td>
                <td><%=c.getGroup() %></td>


               <td>
               <a href="editChild.jsp?id=<%= c.getId() %>" class="btn btn-primary">Edit</a>
               <a href="delete?id=<%= c.getId() %>" class="btn btn-danger">Remove</a>
               </td>
               </tr>
            <%}
            %>

      </tbody>
    </table>
</body>
</html>
