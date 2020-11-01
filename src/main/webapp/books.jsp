<%@page import="java.util.ArrayList,java.util.List"%>
<%@page import="servletdeneme.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Books</title>

</head>
<body>

	<%
	List<Book> books = (List<Book>)request.getAttribute("books");

	%>


	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card text-center">
					<div class="card-header">
						<ul class="nav nav-pills card-header-pills">
							<li class="nav-item"><a class="btn btn-outline-primary"
								href="<%=request.getContextPath()%>/new">Kitap Ekle</a></li>
						</ul>
					</div>
					<div class="card-body">

						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Book Title</th>
									<th scope="col">Author</th>
									<th scope="col">Pages</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Book book : books) {
								%>
								<tr>
									<th scope="row"><%=book.getID()%></th>
									<td><%=book.getTitle()%></td>
									<td><%=book.getAuthor()%></td>
									<td><%=book.getPages()%></td>
									<td>
										<a type="button" class="btn btn-outline-secondary" name= "buton" value="aa" href="<%=request.getContextPath()%>/edit?id=<%=book.getID()%>">
										 Düzenle
										</a>
										<a type="button" class="btn btn-outline-danger" name= "buton" value="aa" href="<%=request.getContextPath()%>/delete?id=<%=book.getID()%>">
										Sil
										</a>
										</button>
									</td>
								</tr>

								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>