<!DOCTYPE html>
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>

<style type="text/css">
.form1 {
	text-align: center;
	margin-top: 100px;
 }

body {
	background-color: yellow;
}
</style>
</head>
<body>

	<form class="form1" action="readValues">

		<h1>Car Showroom</h1>

		<label><b>Name</b></label> <input type="text" name="name"
			placeholder="Enter Name">
		<p style="color: red">${errorName}</p>

		<label><b>Colour</b></label> <input type="text" name="colour"
			placeholder="Enter Colour">
		<p style="color: red">${errorColour}</p>

		<label><b>Speed</b></label> <input type="text" name="speed"
			placeholder="Enter Speed">
		<p style="color: red">${errorSpeed}</p>

		<label><b>Seats</b></label> <input type="text" name="seats"
			placeholder="Enter Seats">
		<p style="color: red">${errorSeats}</p>

		<label><b>Price</b></label> <input type="text" name="price"
			placeholder="Enter price">
		<p style="color: red">${errorPrice}</p>

		<input type="submit" button
			style="background-color: chartreuse; border-color: white">
		</button>
	</form>
	
	<h3>
		<center>Find The Car</center>
	</h3>
	<form action="searchCarByName">
		<label><b>Car Name</b></label>
		<p style="color: red">${ErrorCarName}</p>
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="Search">
	</form>
	<ol>
		<li>${CarName}</li>
		<li>${CarColour}</li>
		<li>${CarSpeed}</li>
		<li>${CarSeats}</li>
		<li>${CarPrice}</li>
	</ol>
	
	<a href="getAllCarInformation">getAllCarInformation</a>
	<table>
	<tr>
	<th>CarName</th>
	<th>CarColour</th>
	<th>CarSpeed</th>
	<th>CarSeats</th>
	<th>CarPrice</th>
	</tr>
	
	<m:forEach items="${getAllCars}" var="s">
	<tr>
	<td>${s.name}</td>
	<td>${s.colour}</td>
	<td>${s.speed}</td>
	<td>${s.seats}</td>
	<td>${s.price}</td>
	</tr>
	
	</m:forEach>
	
	</table>
	
	<h3>
		<center>Delete The Car</center>
	</h3>
	<form action="deleteCarByName">
		<label><b>Car Name</b></label>
		<p style="color: green">${DELETENAME}</p>
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="delete">
			
	</form>
</body>
</html>