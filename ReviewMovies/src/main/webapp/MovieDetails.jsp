<%@ page import ="java.util.List" %>
<%@ page import ="beans.Movie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="movie" value="${requestScope.movie}" />
<c:set var="comment" value="${requestScope.comments}" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="DetailsStyle.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" type="text/css" href="navbar.css">

</head>
<style>

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

  .disabled-input {
    width: 212px;
    height: 24px;
    color: red;
    background-color: white;
    border-radius: 4px;
    text-align: center;
    font-weight: bold;
    opacity: 0.4;
    transition: all 0.3s ease-in-out;
  }
  
  .disabled-input:hover{
	width: 214px;
    height: 26px;
    opacity: 1;
  }

</style>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">
		<div class="background-image" style="background: linear-gradient(to bottom, rgba(0,0,0,0) 0%, rgba(0,0,0,0) 10%, rgba(0,0,0,1) 80%), url('<c:out value="${movie.getFullPicture()}" />');"></div>
	<div class="movie-card">
        <div class="movie-poster">
            <img src="${movie.getMoviePath()}" alt="Movie Poster">
        </div>
        <div class="movie-info">
            <div class="movie-title"><c:out value="${movie.getTitle()}"/></div>
            <div class="movie-synopsis">
                <c:out value="${movie.getDescription()}"/>
            </div>
            <div class="movie-details">
                Released: <c:out value="${movie.getReleaseYear()}"/><br>
                Genre: <c:out value="${movie.getGenre()}"/><br>
                Casts: Josh Brolin, Dave Bautista, Tony Cook, Italo Arrighi, Stellan Skarsgård<br>
                Duration: 167 min<br>
                Country: United States America<br>
                Production: Legendary Pictures, Legendary Entertainment
            </div>
            <div class="movie-rating">
            Rating: <c:out value="${movie.getRating()}"></c:out>
            </div>
        </div>
    </div>
    
</div>
	<c:choose>
    	<c:when test="${not empty sessionScope.user.getUsername()}">
    	</c:when>
    	<c:otherwise>
    	
    	</c:otherwise>
	</c:choose>
	
	<div class="comment-section">
  <h2>Comments</h2>
  <form action="film" method="post">
    <label for="comment">Post a comment:</label><br>
    <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
	<input type="hidden" name="movieId" value="${movie.getMovieId()}">
    <c:choose>
    <c:when test="${not empty sessionScope.user.getUsername()}">
    <input type="submit" value="submit">
    </c:when>
    <c:otherwise>
    <input class="disabled-input" value="Must be logged in to comment" disabled="disabled">
    </c:otherwise>
    </c:choose>
  </form>
<c:forEach var="comment" items="${requestScope.comments}">
	<div class="comments">
    	<div class="comment">	
      <h3><c:out value="${comment.username}"/></h3>
      <c:out value="${comment.commentText}" />
    </div>
  	</div>
</c:forEach>
</div>		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js	"></script>    
</body>
</html>
