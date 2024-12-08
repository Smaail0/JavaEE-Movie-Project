<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="beans.Movie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="LoginStyle.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
        <div class="login-form">
            <h1>Ratiny</h1>
            <form action="userlogin" method="post">
                <div class="form-group">
                    <input type="text" id="email" name="userEmail" value="${empty userEmail ? '' : userEmail}" placeholder ="${empty userEmail ? 'Email' : ''}">
                    <span class="error-message"><c:out value="${userErrors != null ? userErrors['userEmail'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="userPassword" placeholder = "Password">
                    <span class="error-message"><c:out value="${userErrors != null ? userErrors['userPassword'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <input type="submit" value="Log in">
                    <span class="error-message"><c:out value="${userErrors != null ? userErrors['loginError'] : ''}"/></span>
                </div>
            </form>
			<a href="RegisterPage.jsp" class="my-menu-link">You don't already have an account? Sign up</a>
        </div>
    </div>
</body>
</html>