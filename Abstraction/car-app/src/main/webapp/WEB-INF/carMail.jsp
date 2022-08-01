<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Java Email</h1>

<form action="readMailMessages.car" method="post">
<label><b>to Email</b></label>
<input type="email" name="toEmail">

<label><b>Subject</b></label>
<input type="text" name="subject">

<label><b>Body Text</b></label>
<input type="text" name="bodyText">

<input type="submit" value="send">
</form>

</body>
</html>