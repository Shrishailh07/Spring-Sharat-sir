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
 .formDelete{
 	margin-bottom:350px;
 }
 

body {
	background-color: yellow;
}
</style>
</head>
<body>

	<form class="form1" action="readValues.car" method="post">

		<h1 class="fonth1">Car Showroom</h1>
		<p style="color: purple">${ErrorMessage}</p>

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
	
	
	
	<h1 class="fonth2">
		Find The CAR
	</h1>
	<form action="searchCarByName.car" method="post">
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
	
	<form class="form4" action="updateCarByName.car" method="post">

		<h1 class="fonth4">Update Car</h1>
		<p style="color: green;">${ErrorCarName}</p>

		<label><b>Name</b></label> <input type="text" name="name"
			placeholder="Enter Name" value="${CarName}">
		<p style="color: red">${errorName}</p>

		<label><b>Colour</b></label> <input type="text" name="colour"
			placeholder="Enter Colour" value="${CarColour}">
		<p style="color: red">${errorColour}</p>

		<label><b>Speed</b></label> <input type="text" name="speed"
			placeholder="Enter Speed" value="${CarSpeed}">
		<p style="color: red">${errorSpeed}</p>

		<label><b>Seats</b></label> <input type="text" name="seats"
			placeholder="Enter Seats" value="${CarSeats}">
		<p style="color: red">${errorSeats}</p>

		<label><b>Price</b></label> <input type="text" name="price"
			placeholder="Enter price" value="${CarPrice}">
		<p style="color: red">${errorPrice}</p>

		<input type="submit" value="update" button
			style="background-color: white ; border-color: black">
		</button>
	</form>
	
	<br><br><br><br>
	
	<a href="getAllCarInformation.car">getAllCarInformation</a>
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
	
	<br><br><br><br>
	
	<h1 class="fonth3">
		Delete The Car
	</h1>
	<form class="formDelete" action="deleteCarByName.car" method="post">
		<label><b>Car Name</b></label>
		<p style="color: blue">${DELETE_NAME}</p>
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="delete">
			
	</form>
</body>
</html>