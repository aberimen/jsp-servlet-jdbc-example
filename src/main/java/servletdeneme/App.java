package servletdeneme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class App extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDataAccess bookData;

	public void init() {
		bookData = new BookDataAccess();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getServletPath();
		try {
			switch (path) {
			case "/books":
				getBooks(request, response);
				break;
			case "/insert":
				insertData(request, response);
				break;
			case "/new":
				newBookForm(request, response);
				break;
			case "/edit":
				editForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		BookDataAccess bookData = new BookDataAccess();
		List<Book> books = bookData.getBooks();
		request.setAttribute("books", books); // veritabanýndan çektiðimiz kitap verilerini request attribute olarak ekliyoruz 
		RequestDispatcher dispatcher = request.getRequestDispatcher("books.jsp");
		dispatcher.forward(request, response);

	}

	private void insertData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int pages = Integer.parseInt(request.getParameter("pages"));
		Book book = new Book(title, author, pages);
		bookData.insertBook(book);

		response.sendRedirect("books");
	}

	private void newBookForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("new.jsp");
		dispatcher.forward(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException {
		
		Book book = bookData.findByID(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);

	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Book book = new Book(Integer.parseInt(request.getParameter("id")), 
				request.getParameter("title"),
				request.getParameter("author"), 
				Integer.parseInt(request.getParameter("pages")));
		bookData.updateBook(book);

		response.sendRedirect("books");

	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookData.deleteBook(id);
		response.sendRedirect("books");
	}

}
