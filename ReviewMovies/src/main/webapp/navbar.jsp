<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="beans.Movie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="navbar.css">
<link
href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
        rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>

*{
margin: 0px;
}

select {	
	position: fixed;
    width: 200px;
    right: 514px;
    top: 5px;
    height: 40px;
    border: 1px solid #000;
    border-radius: 5px;
    padding: 10px;
    font-size: 16px;
    background-color: black;
    color: white;
    transition: all 0.4s ease-in-out;
    border: none;
    cursor: pointer;
	}
	
	select:focus {
		border: none;
	}

</style>

<body>

<div class="my-navbar">
        <div class="my-navbar-container">
            <div class="my-logo-container">
                <h1 class="my-logo">Ratiny</h1>
            </div>
            <div class="my-menu-container">
                <ul class="my-menu-list">
                    <li class="my-menu-list-item"><a href="homepage" class="my-menu-link">Home</a></li>
                    <c:if test="${not empty sessionScope.adminUsername}">
                    <li class="my-menu-list-item"><a href="addMovie" class="my-menu-link">Add Movie</a></li>
                    </c:if>
                </ul>
            </div>
            <c:choose>
            <c:when test="${not empty sessionScope.user.getUsername()}">
            	<div class="my-profile-container">
	                <img class="my-profile-picture" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png" alt="">
	                <div class="my-profile-text-container">
	                    <span class="my-profile-text"><a href="Testing.jsp" class="my-menu-link"><c:out value="${sessionScope.user.getUsername()}"/></a></span>
	                    <i class="fas fa-caret-down"></i>
	                </div>
					<div class="my-logout-icon" style="display: inline-block;">
        				<span><a href="logout" class="my-menu-link"><i class="fas fa-sign-out-alt"></i></a></span>
    				</div>
            	</div>
            </c:when>
            <c:when test="${not empty sessionScope.adminUsername}">
            	<div class="my-profile-container">
	                <img class="my-profile-picture" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png" alt="">
	                <div class="my-profile-text-container">
	                    <span class="my-profile-text"><a href="#Testing.jsp" class="my-menu-link"><c:out value="${sessionScope.adminUsername}"/></a></span>
	                    <i class="fas fa-caret-down"></i>
	                </div>
					<div class="my-logout-icon" style="display: inline-block;">
        				<span><a href="logout" class="my-menu-link"><i class="fas fa-sign-out-alt"></i></a></span>
    				</div>
            	</div>
            </c:when>
            <c:when test="${empty sessionScope.user.getUsername()}">
            <div class="my-profile-container">
                <div class="my-profile-text-container">
                    <span class="my-profile-text"><a href="userlogin" class="my-menu-link"><i class="fas fa-globe"></i></a></span>
                    <i class="fas fa-caret-down"></i>
                </div>
            </div>
            
            </c:when>
            </c:choose>
            <div class="my-search-bar">
            	<form action="search" method="GET">
				<input type="text" id="search" name="search" value="" placeholder="Search..." autocomplete="off">
                <button type="submit" class="my-search-btn"><i class="fas fa-search"></i></button>
                </form>
            </div>
        <div class="my-select-container">
        	<div class = "select">
        		<select name="genre" class="select">
				  <option value="">All genres</option>
				  <option value="action">Action</option>
				  <option value="thriller">Thriller</option>
				  <option value="adventure">Adventure</option>
				  <option value="comedy">Comedy</option>
				  <option value="crime">Crime</option>
				  <option value="romance">Romance</option>
				  <option value="fantasy">Fantasy</option>
				</select>        	
			</div>
        </div>
        </div>
</div>

</body>
</html>