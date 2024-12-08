<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List" %>

<!DOCTYPE html>

<html>
<head>

<link rel="stylesheet" href="DetailsStyle.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" type="text/css" href="navbar.css">

</head>
    <title>Admin Page</title>
    <style>
    

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	overflow-x:hidden;
	font-family: Arial, sans-serif;
	background-color: #151515;
	color: white;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 50px
}

form {
	max-width: 500px;
	width: 100%;
	
}

.form-group {
	margin-bottom: 15px;
	position: relative;
}

.form-group input{
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: none;
	border-bottom: 2px solid red;
	background: transparent;
	color: white;
	text-align: center;
}

     
.form-group textarea {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: none;
	border-bottom: 2px solid red;
	background: transparent;
	color: white;
	text-align: center;
}

.form-group input[type="submit"] {
	background-color: transparent;
	color: white;
	border-bottom: none;
	cursor: pointer;
	border-radius: 12px;
	position: relative;
    right: -1px;
    transition: background-color 0.3s ease-in-out;s
	}
	
.form-group input[type="submit"]:hover {
	background-color: red;
}

.form-group input,
.form-group textarea:focus{
	text-align: center;
	outline: none;
}
    </style>
<body>

<%@ include file="navbar.jsp" %>

    <form action="addNewMovie" method="post">
        <div class="form-group">
            <input type="text" id="title" name="title" placeholder="Title" required>
        </div>
        <div class="form-group">
            <input type="number" id="year" name="year" placeholder="Release Year" required>
        </div>
        <div class="form-group">
            <input type="text" id="genre" name="genre" placeholder="Genre" required>
        </div>
        <div class="form-group">
            <input type="text" id="director" name="director" placeholder="Director" required>
        </div>
        <div class="form-group">
            <textarea id="description" name="description" rows="4" placeholder="Description" required></textarea>
        </div>
        <div class="form-group">
            <input type="number" id="rating" name="rating" step="0.1" min="0" max="10" placeholder="Rating" required>
        </div>
        <div class="form-group">
            <input type="text" id="poster" name="poster" placeholder="Movie Poster url" required>
        </div>
        <div class="form-group">
            <input type="text" id="widescreen" name="widescreen" placeholder="Widescreen Movie Image url" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Add Movie">
        </div>
    </form>
</body>
</html>