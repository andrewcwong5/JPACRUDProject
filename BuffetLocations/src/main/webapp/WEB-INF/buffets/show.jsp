<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
	<!--  ctrl space, jps, core, prefix c-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buffet search result</title>
</head>
<body>
<h3>Show buffet by ID</h3>
	<form action= "getBuffet.do" method="GET"
	Buffet ID: <input> type="text"</form> name="bid"
	
	<div>
		<h5>${buffet.name}(${film.address})</h5>
		<p>${buffet.type}</p>
	</div>
</body>
</html>