<%@ page import="utils.DBConnection" %>
<%@ page import="dao.ChildDao" %>
<%@ page import="model.Child" %>
<%@ page import="java.sql.Connection" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Child</title>
<%@include file="css.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h2>Edit Child</h2>
<%
    int currentId = Integer.parseInt(request.getParameter("id"));
    ChildDao dao = new ChildDao(DBConnection.getConnection());
    Child child = dao.getChildById(currentId);
    System.out.println(child);
%>
    <form action="update" method="post">
      <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" class="form-control" value=<%=child.getName() %> name="name">
      </div>
      <div class="mb-3">
              <label class="form-label">Age</label>
              <input min="2" max="7" value=<%=child.getAge() %> type="number" class="form-control" name="age">
      </div>
      <div class="mb-3">
              <label class="form-label">Gender</label>
              <input type="text" value=<%=child.getGender() %> class="form-control" name="gender">
      </div>
      <div class="mb-3">
              <label class="form-label">Group</label>
              <input type="text" value=<%=child.getGroup() %> class="form-control" name="group">
      </div>
      <input type="hidden" value=<%=currentId %> class="form-control" name="id">
      <button type="submit" class="btn btn-primary">Update</button>
    </form>
</body>
</html>
