<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Showroom</title>
</head>
<body>
 <pre>
<form action="readValues">

 			<label><b>Name</b></label>
 			<input type="text" name="name"> <p style="color:red">${errorName}</p>

 			<label><b>Colour</b></label>
 			<input type="text" name="colour"><p style="color:red">${errorColour}</p>

 			<label><b>Speed</b></label>
 			<input type="text" name="speed"> ${errorSpeed}

 			<label><b>Seats</b></label>
 			<input type="text" name="seats"> ${errorSeats} 

 			<label><b>Price</b></label>
 			<input type="text" name="price"> ${errorPrice}

 		    <input type="submit">

	</pre>
</body>
</html>