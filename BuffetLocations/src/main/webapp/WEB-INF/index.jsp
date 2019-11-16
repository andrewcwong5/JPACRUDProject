<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buffet Locations</title>
</head>
<body>
<h1>BUFFETS BUFFETS BUFFETS</h1>

<form action="getBuffet.do" method="GET">
  Buffet ID: <input type="text" name="id" />
  <input type="submit" value="Show Buffet" />
</form>

<form action="getBuffet.do" method="GET">
  Buffet ID: <input type="text" name="id" />
  <input type="submit" value="Show Buffet" />
  </form>
  
  <div> 
  </div>
  <h2>Add a Buffet</h2>
<form action="add.do" method="POST">
		<input type="hidden" name="filmIdAdd" value="${buffet.id}">
		Name <input class="form-control" type="text" name="name" value="${buffet.name}" required><br> 
		Address <input class="form-control" type="text" name="address" value="${buffet.address}"><br>
		Phone <input class="form-control" type="text" name="Phone" value="${buffet.phone}" ><br> 
		Lunch Price<input class="form-control" type="number" name="lunchPrice" min="0" max="1000" value="${buffet.lunchPrice}"><br>	
		Dinner Price<input class="form-control" type="number" name="dinnerPrice" min="0" max="2000" value="${buffet.dinnerPrice}"><br>
		Type<input class="form-control" type="text" name="type" value="${buffet.type}"><br> 
		<input type="submit" value="Add Buffet">
		
</form>
</body>
</html>