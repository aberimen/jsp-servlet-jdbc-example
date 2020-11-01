<%@page import="servletdeneme.BookDataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servletdeneme.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Edit Book</title>
</head>

<body>
<%

Book book = (Book)request.getAttribute("book");

%>

	<div class="container">
		<div class="row">
			<div class="col-6">
			<form action="update">
				<div class="form-group">
					<input type="hidden" class="form-control" name="id" value ="<%=book.getID()%>" >
					<label>Book Title</label> 
					<input type="text" class="form-control" name="title" value ="<%=book.getTitle()%>" >
				</div>
				<div class="form-group">
					<label>Author</label> 
					<input type="text" class="form-control" name="author" value="<%=book.getAuthor()%>">
				</div>
				<div class="form-group">
					<label>Pages</label> 
					<input type="number" class="form-control" name="pages" value="<%=book.getPages() %>" >
				</div>
			

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			</div>
		</div>
	</div>

</body>
</html>