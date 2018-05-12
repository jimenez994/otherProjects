<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Login</h1>
    <form action="login" method="post">
        <input type="text" name="username" placeholder="username"><br><br>
        <input type="submit" value="Login">
    </form><br>
    
     <h1>Register</h1>
    <form:form  action="/register" method="post" modelAttribute="user">
        <p>
            <form:label path="name">Name:
                <form:errors path="name"></form:errors><br>
                <form:input path="name"></form:input>
            </form:label>
        </p>
        <p>
            <form:label path="username">username:
                <form:errors path="username"></form:errors><br>
                <form:input path="username"></form:input>
            </form:label>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
</body>
</html>