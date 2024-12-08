<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<c:set var="movieError" value="${requestScope.movieError}"/>
<c:set var="moviesFound" value="${requestScope.moviesFound}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Movie Search Result</title>
    <style>
        /* Navbar styles */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            background-color: #333;
            color: #fff;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        }

        .navbar h1 {
            margin: 0;
            padding-bottom: 5px;
            background-color: #45a049;
            color: #fff;
            display: inline-block;
            padding: 4px 10px;
            border-radius: 8px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }

        .search-bar {
            flex: 1;
            margin: 10px;
        }

        .search-bar input[type="text"] {
            width: calc(90% - 40px);
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
        }

        .search-btn {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 8px;
            padding: 9px 10px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }

        .search-btn:hover {
            background-color: #45a049;
        }

        /* Movie card styles */
        .movie-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding: 16px; /* Adjusted padding */
        }

        .movie-card {
            
            margin-bottom: 16px; /* Adjusted margin */
            display: flex;
            align-items: flex-start;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.1); /* Slightly reduced box shadow */
            border-radius: 7px; /* Slightly reduced border radius */
            overflow: hidden;
        }

        .movie-card img {
            width: 90px; /* Adjusted image width */
            height: 130px; /* Adjusted image height */
            border-radius: 7px 0 0 7px; /* Adjusted border radius for image */
            object-fit: cover; /* Ensure image covers the container */
        }

        .movie-details {
            flex: 1;
            padding: 8px 8px; /* Adjusted padding */
            background-color: #f9f9f9;
            border-radius: 0 7px 7px 0; /* Adjusted border radius for details */
        }

        .movie-title {
            margin-top: 0;
            font-weight: bold;
            margin-bottom: 8px; /* Adjusted margin */
        }

        .release-year,
        .genre {
            font-size: 0.9em;
            color: #888;
            margin-bottom: 4px; /* Adjusted margin */
        }

        .description {
            margin-bottom: 12px; /* Adjusted margin */
        }

        .rating {
            font-weight: bold;
        }

        .no-movies {
            text-align: center;
            margin-top: 16px; /* Adjusted margin */
            font-size: 1.08em; /* Slightly reduced font size */
            color: #555;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <h1>Ratiny</h1>
        <div class="search-bar">
            <form action="search" method="GET">
                <input type="text" id="search" name="search" placeholder="Search...">
                <button type="submit" class="search-btn"><i class="fas fa-search"></i></button>
            </form>
        </div>
    </div>

    <div class="movie-container">
        <c:if test="${not empty movieError}">
            <p style="color: black;">${movieError['notFound']}</p>
        </c:if>
        <c:if test="${not empty moviesFound}">
            <c:forEach var="movie" items="${moviesFound}">
                <div class="movie-card">
                    <img src="<c:out value="${movie.getMoviePath()}" />" alt="<c:out value="${movie.getTitle()}" />">
                    <div class="movie-details">
                        <div class="movie-title"><c:out value="${movie.getTitle()}" /></div>
                        <div class="release-year">Release Year: <c:out value="${movie.getReleaseYear()}" /></div>
                        <div class="genre">Genre: <c:out value="${movie.getGenre()}" /></div>
                        <div class="description">Description: <c:out value="${movie.getDescription()}" /></div>
                        <div class="rating">Rating: <c:out value="${movie.getRating()}" /></div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</body>
</html>
