<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buffet Added</title>
</head>
<body>
<div>

		<h5>${buffet.name}(${buffet.address})</h5>
		<p>Phone: ${buffet.phone}</p>
		<p>Lunch Price: ${buffet.lunchPrice}</p>
		<p>Dinner Price: ${buffet.dinnerPrice}</p>
		<p>${buffet.type}</p>
	</div>

</body>
</html>