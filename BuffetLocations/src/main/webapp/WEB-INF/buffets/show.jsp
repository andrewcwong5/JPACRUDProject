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
		<p>You are viewing buffet ID: ${buffet.id}</p>
		<h5>${buffet.name} (${buffet.address})</h5>
		<p>Phone: ${buffet.phone}</p>
		<p>Lunch Price: ${buffet.lunchPrice}</p>
		<p>Dinner Price: ${buffet.dinnerPrice}</p>
		<p>Type: ${buffet.type}</p>
	</div>
	<br>
	
	<form action="delete.do" method="POST">
	Delete by Id: <input type="hidden" name="buffetIdDelete" value="${buffet.id}"/>
	<input type="submit" value="Delete Buffet ${buffet.id}"/>
	</form>
	
	<br>
	<br>
	<br>
	<!-- UPDATE FORM -->
	<h3>Update currently viewed Buffet ${buffet.id}</h3>
	
			<form action="update.do" method="POST">
				<input type="hidden" name="BuffetId" value="${buffet.id}"> Name <input
					class="form-control" type="text" name="name" value="${buffet.name}"
					required><br> Address <input class="form-control"
					type="text" name="address" value="${buffet.address}"><br>
				Phone <input class="form-control" type="text" name="Phone"
					value="${buffet.phone}"><br> Lunch Price<input
					class="form-control" type="number" name="lunchPrice" min="0"
					max="1000" value="${buffet.lunchPrice}"><br>
				Dinner Price<input class="form-control" type="number"
					name="dinnerPrice" min="0" max="2000" value="${buffet.dinnerPrice}"
					required><br> Type<input class="form-control"
					type="text" name="type" value="${buffet.type}" ><br>
				<input class="btn btn-outline-success" type="submit" value="Submit"><br>
			</form>
	
	<h3>Add a buffet</h3>
	<form action="add.do" method="POST">
					Name: <input type="text" name ="name" required="required"/><br>
					Address: <input type="text" name ="address" required="required"/><br>
					Phone: <input type="text" name ="phone" /><br>
					Lunch Price: <input type="number" name ="lunchPrice" /><br>
					Dinner Price: <input type="number" name ="dinnerPrice" /><br>
					Type: <input type="text" name ="type" /><br>
					<input class="btn btn-submit" type="submit" value="Add Buffet" />
	</form>
	
	<br>
	<br>
	<br>
	
	
	
	<%-- <form action="list.do" method="GET">
		Show All Buffets: <input type="submit" value="Click here">
	</form>
	<br>
	
	<c:if test="${not empty buffets}">
	<ul>
			<li> Buffet ID: ${buffets.id} </li>
							
								<li>Name: ${buffets.name}</li>
								<li>Address: ${buffets.address}</li>
								<li>Phone: ${buffets.phone}</li>
								<li>Lunch Price: ${buffets.lunchPrice}</li>
								<li>Dinner Price: ${buffets.dinnerPrice}</li>
								<li>Type: ${buffets.type}</li>
							
	</ul>
	</c:if>
	<ul>
	 
	 <c:forEach items="${buffets}" var="buffets">
		<li> <a href="getBuffet.do?id=${buffet.id}"> 
		
								<li> Buffet ID: ${buffets.id} </li>
							
								Name
								${buffets.name}
							
								Address
								${buffets.address}
							
								Phone
								${buffets.phone}
							
								Lunch Price
								${buffets.lunchPrice}
							
								Dinner Price
								${buffets.dinnerPrice}
							
								Type
								${buffets.type}
							
					</a></li>
					</c:forEach>
				</ul>
 
	<!-- BOTTOM BUTTONS TO EDIT OR DELETE -->
	<div class="text-center">
		<div class="btn-group">
			<form action="delete.do" method="POST" class="bottom__buttons">
				<input type="hidden" name="filmIdDelete" value="${buffet.id }">
				<input class="btn btn-secondary" type="submit" value="Delete buffet">
			</form>
			<div>
				<button class="btn btn-secondary bottom__buttons" type="button"
					data-toggle="collapse"
					data-target="#collapseUpdateFilm${buffet.id}" aria-expanded="false"
					aria-controls="collapseExample">Update buffet</button>
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
					value="${buffet.phone}"><br> Lunch Price<input
					class="form-control" type="number" name="lunchPrice" min="0"
					max="1000" value="${buffet.lunchPrice}"><br>
				Dinner Price<input class="form-control" type="number"
					name="dinnerPrice" min="0" max="2000" value="${buffet.dinnerPrice}"
					required><br> Type<input class="form-control"
					type="text" name="type" value="${buffet.type}" ><br>
				<input class="btn btn-outline-success" type="submit" value="Submit"><br>
			</form>
		</div>
	</div>
	  --%>
	
</body>
</html>