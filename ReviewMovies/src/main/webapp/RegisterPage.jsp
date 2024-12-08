<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="registrationErrors" value="${requestScope.errors}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="RegisterStyle.css">

</head>
<body>
    <div class="container">
        <div class="registration-form">
            <h1>Registration</h1>
            <form action="registration" method="post">
                <div class="form-group">
                    <input type="text" id="username" name="username" placeholder="Username" value="${empty username ? '' : username}">
	                    <span class="error-message"><c:out value="${registrationErrors != null ? registrationErrors['username'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <input type="text" id="email" name="email" placeholder="Email" value="${empty userEmail ? '' : userEmail}">
                    <span class="error-message"><c:out value="${registrationErrors != null ? registrationErrors['userEmail'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder="Password">
                    <span class="error-message"><c:out value="${registrationErrors != null ? registrationErrors['userPassword'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                    <span class="error-message"><c:out value="${registrationErrors != null ? registrationErrors['confirmPassword'] : ''}"/></span>
                </div>
                <div class="form-group">
                    <span class="error-message"><c:out value="${registrationErrors != null ? registrationErrors['existingUser'] : ''}"/></span>
                    <input type="submit" value="Sign up">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
