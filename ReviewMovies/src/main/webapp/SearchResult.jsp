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
    <link rel="stylesheet" href="SearchStyle.css">
	<link rel="stylesheet" type="text/css" href="navbar.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Search Result</title>
</head>

<style>

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}


</style>	

<body>

<%@ include file="navbar.jsp" %>

    	<div class="movie-container">
        <c:if test="${not empty movieError}">
            <p style="color: black;">${movieError['notFound']}</p>
        </c:if>
        <c:if test="${not empty moviesFound}">
            <c:forEach var="movie" items="${moviesFound}">
                <div class="movie-card">
                	<div class="image-container">
                    <img class = "image" src="<c:out value="${movie.getMoviePath()}" />" alt="<c:out value="${movie.getTitle()}" />">            		
                	</div>
						<div class="movie-details-container" style="max-width: 400px; max-height: 420px">
						    <div class="movie-title"><c:out value="${movie.getTitle()}" /></div>
						    <div class="release-year">Release Year: <c:out value="${movie.getReleaseYear()}" /></div>
						    <div class="genre">Genre: <c:out value="${movie.getGenre()}" /></div>
						    <div class="description">Description: <c:out value="${movie.getDescription()}" /></div>
						    <div class="rating">Rating: <c:out value="${movie.getRating()}" /></div>
						    <a href="film?movieId=${movie.getMovieId()}" class="button" >More details</a>
						    <c:if test="${not empty sessionScope.adminUsername}" >
                            <a href="delete?movieId=${movie.getMovieId()}" class="delete">Delete</a>
                            </c:if>		
						</div>
	                </div>
            </c:forEach>
        </c:if>
    </div>

</body>
</html>