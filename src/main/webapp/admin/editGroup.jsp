<%@ page import="java.util.UUID" %>
<%@ page import="static com.example.demo4.repo.BaseRepo.entityManagerFactory" %>
<%@ page import="com.example.demo4.entity.Group" %><%--
  Created by IntelliJ IDEA.
  User: Farangiz
  Date: 4/19/2024
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<style>
    /* Custom styles for this page */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #343a40;
    }
    .card {
        width: 400px;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
</style>
<%
    UUID id = UUID.fromString(request.getParameter("groupId"));
    Group group = entityManagerFactory.createEntityManager().find(Group.class, id);
%>
<body>
<div class="card">
    <h5 class="card-title text-center mb-4">Edit <%=group.getName()%></h5>
    <form action="/group/edit?id=<%=group.getId()%>" method="post">
        <div class="form-group">
            <label for="name">Group Name</label>
            <input value="<%=group.getName()%>" type="text" class="form-control" id="name" name="name" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Edit group</button>
    </form>
</div>
</body>
</html>
