<%@ page import ="java.util.List" %>
<%@ page import ="beans.Movie" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="movieList" value="${requestScope.movieList}" />
<c:set var="topMovies" value="${requestScope.topMovies}" />
<c:set var="classicMovies" value="${requestScope.classicMovies}" />
<c:set var="featureMovies" value="${requestScope.featureMovies}" />
<c:set var="newMovies" value="${requestScope.newMovies}" />

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <title>Movie Design</title>
</head>

<style>
	
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
    <div class="navbar">
        <div class="navbar-container">
            <div class="logo-container">
                <a href ="homepage" class="logo" >Ratiny</a>
            </div>
            <div class="menu-container">
                <ul class="menu-list">
                    <li class="menu-list-item"><a href="homepage" class="menu-link">Home</a></li>
                    <c:if test="${not empty sessionScope.adminUsername}">
                    <li class="menu-list-item"><a href="AddMovie.jsp" class="menu-link">Add Movie</a></li>
                    </c:if>
                </ul>
            </div>
            <c:choose>
            <c:when test="${not empty sessionScope.user.getUsername()}">
            	<div class="profile-container">
                <img class="profile-picture" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png" alt="">
                <div class="profile-text-container">
                    <span class="profile-text"><a href="Testing.jsp" class="menu-link"><c:out value="${sessionScope.user.getUsername()}"></c:out></a></span>
                    <i class="fas fa-caret-down"></i>
                </div>
                <div class="logout-icon" style="display: inline-block;">
        				<span><a href="logout" class="menu-link"><i class="fas fa-sign-out-alt"></i></a></span>
    			</div>
            </div>
            </c:when>
            <c:when test="${not empty sessionScope.adminUsername}">
            	<div class="profile-container">
	                <img class="profile-picture" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png" alt="">
	                <div class="profile-text-container">
	                    <span class="profile-text"><a href="#Testing.jsp" class="menu-link"><c:out value="${sessionScope.adminUsername}"/></a></span>
	                    <i class="fas fa-caret-down"></i>
	                </div>
					<div class="logout-icon" style="display: inline-block;">
        				<span><a href="logout" class="menu-link"><i class="fas fa-sign-out-alt"></i></a></span>
    				</div>
            	</div>
            </c:when>
            <c:when test="${empty sessionScope.user.getUsername()}">
            <div class="profile-container">
                <div class="profile-text-container">
                    <span class="profile-text"><a href="userlogin" class="menu-link"><i class="fas fa-globe"></i></a></span>
                    <i class="fas fa-caret-down"></i>
                </div>
            </div>
            </c:when>
            </c:choose>
            <div class="search-bar">
            	<form action="search" method="GET">
				<input type="text" id="search" name="search" value="" placeholder="Search..." autocomplete="off">
                <button type="submit" class="search-btn"><i class="fas fa-search"></i></button>
                </form>
            </div>
        <div class="select-container">
        	<div class = "my-select">
        		<select name="genre" class="select">
				  <option value="All">All genres</option>
				  <option value="Action">Action</option>
				  <option value="Thriller">Thriller</option>
				  <option value="Adventure">Adventure</option>
				  <option value="Comedy">Comedy</option>
				  <option value="Crime">Crime</option>
				  <option value="Romance">Romance</option>
				  <option value="Fantasy">Fantasy</option>
				</select>        	
			</div>
        </div>
        </div>
    </div>
    <div class="container">
        <div class="content-container">
        	<div id="featuredContainer" class="featured-container">
    			<c:forEach var="feature" items="${featuredMovies}">
			        <div class="featured-content" style="background: linear-gradient(to bottom, rgba(0,0,0,0), #151515), url('<c:out value="${feature.getFullPicture()}" />');">
			            <img class="featured-title" src="<c:out value="${feature.getMoviePath()}" />" alt="">
			            <p class="featured-desc"><c:out value="${feature.getDescription()}" /></p>
			            <a href="film?movieId=${feature.getMovieId()}" class="featured-button">More details</a>
			        </div>
    			</c:forEach>
			</div>
			<div class="movie-list-container">
                <h1 class="movie-list-title">TOP MOVIES</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
					<c:forEach var="movie" items="${topMovies}">
                        <div class="movie-list-item">
                            <img class="movie-list-item-img" src="${movie.getMoviePath()}" alt="">
                            <a href="film?movieId=${movie.getMovieId()}" class="movie-list-item-button" > More Details</a>
                            <c:if test="${not empty sessionScope.adminUsername}" >
                            <a href="delete?movieId=${movie.getMovieId()}" class="movie-list-item-delete">Delete</a>
                            </c:if>
                        </div>
					</c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
            <div class="movie-list-container">
                <h1 class="movie-list-title">CLASSICS</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach var="movie" items="${classicMovies}">
                        <div class="movie-list-item">
                            <img class="movie-list-item-img" src="${movie.getMoviePath()}" alt="">
                            <a href="film?movieId=${movie.getMovieId()}" class="movie-list-item-button" > More Details</a>
                            <c:if test="${not empty sessionScope.adminUsername}" >
                            <a href="delete?movieId=${movie.getMovieId()}" class="movie-list-item-delete">Delete</a>
                            </c:if>
                        </div>
						</c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
            <div class="movie-list-container">
                <h1 class="movie-list-title">NEW RELEASES</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
						<c:forEach var="movie" items="${newMovies}">
	                        <div class="movie-list-item">
	                            <img class="movie-list-item-img" src="${movie.getMoviePath()}" alt="">
	                            <a href="film?movieId=${movie.getMovieId()}" class="movie-list-item-button" > More Details</a>
	                            <c:if test="${not empty sessionScope.adminUsername}" >
                            	<a href="delete?movieId=${movie.getMovieId()}" class="movie-list-item-delete">Delete</a>
                            	</c:if>
	                        </div>
						</c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
            <div class="movie-list-container">
                <h1 class="movie-list-title">ALL MOVIES</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
						<c:forEach var="movie" items="${movieList}">
	                        <div class="movie-list-item">
	                            <img class="movie-list-item-img" src="${movie.getMoviePath()}" alt="">
	                            <a href="film?movieId=${movie.getMovieId()}" class="movie-list-item-button" > More Details</a>
	                            <c:if test="${not empty sessionScope.adminUsername}" >
                            	<a href="delete?movieId=${movie.getMovieId()}" class="movie-list-item-delete">Delete</a>
                            	</c:if>
	                        </div>
						</c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
        </div>
    </div>
    <script src="app.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(document).ready(function () {
    	$(document).ready(function () {
    	    var currentIndex = 0;
    	    var slides = $(".featured-content");
    	    var slideInterval;

    	    function showSlide(index) {
    	        var offset = -index * $(".featured-container").width();
    	        $(".featured-content").css("transform", "translateX(" + offset + "px)");
    	    }

    	    function startSlideInterval() {
    	        slideInterval = setInterval(function () {
    	            currentIndex++;
    	            if (currentIndex >= slides.length) {
    	                currentIndex = 0;
    	            }
    	            showSlide(currentIndex);
    	        }, 6000);
    	    }

    	    function stopSlideInterval() {
    	        clearInterval(slideInterval);
    	    }

    	    $("#nextButton").click(function () {
    	        currentIndex++;
    	        if (currentIndex >= slides.length) {
    	            currentIndex = 0;
    	        }
    	        showSlide(currentIndex);
    	        stopSlideInterval();
    	        startSlideInterval(); 
    	    });

    	    $("#prevButton").click(function () {
    	        currentIndex--;
    	        if (currentIndex < 0) {
    	            currentIndex = slides.length - 1;
    	        }
    	        showSlide(currentIndex);
    	        stopSlideInterval();
    	        startSlideInterval();
    	    });

    	    startSlideInterval();

    	    $(".featured-container").mouseenter(function () {
    	        stopSlideInterval();
    	    });

    	    $(".featured-container").mouseleave(function () {
    	        startSlideInterval();
    	    });
    	});    
    	});
    </script>
</body>

</html>