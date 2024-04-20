<%--
  Created by IntelliJ IDEA.
  User: Farangiz
  Date: 4/19/2024
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h4 class="text-center">Login</h4>
                </div>
                <div class="card-body">
                    <form action="http://localhost:8080/auth/login" method="post">
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input name="email" type="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                        <div>
                            <labal class="form-check-label my-2 mx-2">
                                remember me
                                <input name="rememberMe" class="form-check my-2 mx-2" type="checkbox">
                            </labal>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input name="password" type="password" class="form-control" id="password"
                                   placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                        <p>Don't have an account?<a href="register.jsp">Sign up</a></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
