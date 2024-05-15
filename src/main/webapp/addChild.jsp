<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Child</title>
<%@include file="css.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h2>Add Child</h2>
    <form action="create" method="post">
      <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" class="form-control" name="name">
      </div>
      <div class="mb-3">
              <label class="form-label">Age</label>
              <input min="2" max="7" value="2" type="number" class="form-control" name="age">
      </div>
      <div class="mb-3">
              <label class="form-label">Gender</label>
              <input type="text" class="form-control" name="gender">
      </div>
      <div class="mb-3">
              <label class="form-label">Group</label>
              <input type="text" class="form-control" name="group">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</body>
</html>
