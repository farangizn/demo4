<%@ page import="java.util.List" %>
<%@ page import="com.example.demo4.entity.Student" %>
<%@ page import="com.example.demo4.repo.StudentRepo" %>
<%@ page import="com.example.demo4.entity.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body>

<%
    Object currentUser1 = request.getSession().getAttribute("currentUser");
    Student currentUser = null;
    if (currentUser1 != null) {
        currentUser = (Student) currentUser1;
    }
    StudentRepo studentRepo = new StudentRepo();
    List<Student> students = studentRepo.findAll();
//    List<Student> validStudents = new ArrayList<>();
//    Object object = session.getAttribute("validStudents");
//    if (object != null) {
//        validStudents = (List<Student>) object;
//    }
%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">User Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
            </ul>

            <form action="http://localhost:8080/search" method="post" class="d-flex" role="search">
                <input name="text" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <div>
                <%if (currentUser == null) {%>
                <a class="btn btn-outline-dark" href="login.jsp">Login</a>
                <%} else if (currentUser.getRoleByName("admin").getName().equalsIgnoreCase("admin")) { %>
                <a class="btn btn-outline-success" href="admin/admin.jsp">Admin</a>
                <a class="btn btn-outline-danger" href="http://localhost:8080/auth/logout">Log Out</a>
                <%} else if (currentUser.getRoleByName("student").getName().equalsIgnoreCase("student")) { %>
                <a class="btn btn-outline-danger" href="/auth/logout">Log Out</a>
                <% } %>
            </div>
        </div>
    </div>
</nav>

<!-- User Table -->
<div class="container mt-4">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Age</th>
            <th scope="col">Roles</th>
            <th scope="col">Group</th>
        </tr>
        </thead>
        <tbody>
        <%--        <% if (validStudents != null) {--%>
        <%--        <% for (Student student : validStudents) { %>--%>
        <%--        <td><%=student.getFirstName()%>></td>--%>
        <%--        <td><%=student.getLastName()%>></td>--%>
        <%--        <td><%=student.getEmail()%>></td>--%>
        <%--        <td><%=student.getAge()%>--%>
        <%--        </td>--%>
        <%--        <td>--%>
        <%--            <% for (Role role : student.getRoles()) { %>--%>
        <%--            <%=role.getName()%>--%>
        <%--            <% } %>--%>
        <%--        </td>--%>
        <%--        <td>--%>
        <%--            <%=student.getGroup().getName()%>--%>
        <%--        </td>--%>
        <%--        <% }--%>
        <%--        } else { %>--%>
        <% for (Student user : students) { %>
        <tr>
            <td><%=user.getFirstName()%>></td>
            <td><%=user.getLastName()%>></td>
            <td><%=user.getEmail()%>></td>
            <td><%=user.getAge()%>
            </td>
            <td>
                <%--                <% for (Role role : user.getRoles()) { %>--%>
                <%--                <%=role.getName()%>--%>
                <%--                <% } %>--%>
            </td>
            <td>
                <%--                <%=user.getGroup().getName()%>--%>
            </td>
        </tr>
        <% } %>
        <%--        <% } %>--%>

        </tbody>
    </table>
</div>

<!-- Bootstrap Bundle with Popper -->
</body>
</html>