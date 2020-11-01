<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert new Book</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
			<form action="insert">
				<div class="form-group">
					<label>Book Title</label> 
					<input type="text" class="form-control" name="title" >
				</div>
				<div class="form-group">
					<label>Author</label> 
					<input type="text" class="form-control" name="author">
				</div>
				<div class="form-group">
					<label>Pages</label> 
					<input type="number" class="form-control" name="pages" >
				</div>
			

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			</div>
		</div>
	</div>

</body>
</html>