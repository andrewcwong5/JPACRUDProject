<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  ctrl space, jps, core, prefix c-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buffet search result</title>
</head>
<body>
	<h3>Show buffet by ID</h3>
	<form action="getBuffet.do" method="GET">
		Buffet ID: <input type="text" name="id" /> <input type="submit"
			value="Show Buffet">
	</form>

	<div>
		<h5>${buffet.name}(${buffet.address})</h5>
		<p>Phone: ${buffet.phone}</p>
		<p>Lunch Price: ${buffet.lunchPrice}</p>
		<p>Dinner Price: ${buffet.dinnerPrice}</p>
		<p>${buffet.type}</p>
	</div>
	
	 <c:forEach items="${buffets}" var="buffets" begin= "0" end= "3">
	<a href="getBuffet.do?id=${buffet.id}">
	
					<div>
	
						<table class="table">
							<tr>
								<td>Database Film ID</td>
								<td>${buffets.id}</td>
							</tr>
							<tr>
								<td> Name</td>
								<td> ${buffets.name} </td>
							</tr>
							<tr>
								<td>Address</td>
								<td>${buffets.address}</td>
							</tr>
							<tr>
								<td>Phone</td>
								<td>${result.phone}</td>
							</tr>							
							<tr>
								<td>Lunch Price</td>
								<td>${result.lunchPrice}</td>
							</tr>
							<tr>
								<td>Dinner Price</td>
								<td>${result.dinnerPrice}</td>
							</tr>
							<tr>
								<td>Type</td>
								<td>${result.type}</td>
							</tr>
							
						</table>
					</div>
					</a>
					</c:forEach>
				
 
	<!-- BOTTOM BUTTONS TO EDIT OR DELETE -->
	<div class="text-center">
		<div class="btn-group">
			<form action="delete.do" method="POST" class="bottom__buttons">
				<input type="hidden" name="filmIdDelete" value="${buffet.id }">
				<input class="btn btn-secondary" type="submit" value="Delete film">
			</form>
			<div>
				<button class="btn btn-secondary bottom__buttons" type="button"
					data-toggle="collapse"
					data-target="#collapseUpdateFilm${buffet.id}" aria-expanded="false"
					aria-controls="collapseExample">Update film</button>
			</div>
		</div>
	</div>

	<!-- UPDATE FORM -->
	<div class="collapse" id="collapseUpdateFilm${buffet.id}">
		<div class="card card-body">
			<form action="update.do" method="POST">
				<input type="hidden" name="id" value="${buffet.id}"> Name <input
					class="form-control" type="text" name="name" value="${buffet.name}"
					required><br> Address <input class="form-control"
					type="text" name="address" value="${buffet.address}"><br>
				Phone <input class="form-control" type="text" name="Phone"
					value="${buffet.phone}" required><br> Lunch Price<input
					class="form-control" type="number" name="lunchPrice" min="0"
					max="1000" value="${buffet.lunchPrice}" required><br>
				Dinner Price<input class="form-control" type="number"
					name="dinnerPrice" min="0" max="2000" value="${buffet.dinnerPrice}"
					required><br> Type<input class="form-control"
					type="text" name="type" value="${buffet.type}" required><br>
				<input class="btn btn-outline-success" type="submit" value="Submit"><br>
			</form>
		</div>
	</div>
	</div>
	 
	
</body>
</html>