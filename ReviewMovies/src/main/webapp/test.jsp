<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
</head>

<style>
input[type="radio"] {
  display: none;
}

label.fa-star {
  font-size: 24px;
  padding: 5px;
  cursor: pointer;
}

input[type="radio"]:checked ~ label.fa-star {
  color: gold;
}
</style>

<body>

<form action="submitReview" method="post">
  <div class="stars">
    <input type="radio" name="rating" id="rating1" value="1">
    <label for="rating1" class="fa fa-star"></label>
    <input type="radio" name="rating" id="rating2" value="2">
    <label for="rating2" class="fa fa-star"></label>
  </div>
  <button type="submit">Submit</button>
  </form>

</body>
</html>