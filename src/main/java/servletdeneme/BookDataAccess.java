package servletdeneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDataAccess {
	private static final String url ="jdbc:mysql://localhost:3306/servletdeneme";
	private static final String user ="root";
	private static final String password ="";
	private Connection conn;
	
	protected Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(conn == null || conn.isClosed())
			conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}
	
	protected void disConnect() throws SQLException {
		if(conn != null)
			conn.close();
	}
	
	public ArrayList<Book> getBooks() throws SQLException{
		ArrayList<Book> books = new ArrayList<Book>();
		 conn = getConnection();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from books");
		
		Book book = null;
		while(rs.next()) {
			book = new Book(rs.getInt("ID"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getInt("pages"));

			
			books.add(book);
		}//While döngü sonu 
		
		statement.close();
		disConnect();
		
		return books;
	}//getBooks() sonu
	
	
	public boolean insertBook(Book book) throws SQLException {
		boolean sonuc = false;
		conn = getConnection();
		String query = "insert into books(title, author, pages) values(?,?,?)";
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setInt(3, book.getPages());
		
		sonuc = statement.executeUpdate() > 0;
		
		if (sonuc) {
			System.out.println(book.getTitle() + ", Baþarýyla eklendi..!");
		}
		statement.close();
		disConnect();
		
		return sonuc;
	}
	
	public void updateBook(Book book) throws SQLException {
		conn = getConnection();
		String query = "update books SET title=?, author=?, pages=? where id=?";
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setInt(3, book.getPages());
		
		statement.setInt(4, book.getID());
		
		statement.executeUpdate();
		
		statement.close();
		disConnect();
	}
	
	public void deleteBook(int id) throws SQLException {
		conn = getConnection();
		String query = "delete from books where id=?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		statement.execute();
		
		statement.close();
		disConnect();
	}
	
	public Book findByID(int id) throws SQLException {
		conn = getConnection();
		String query = "select * from books where id=?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		Book book = null;
		while(resultSet.next()) {
			book = new Book(resultSet.getInt("ID"),
					resultSet.getString("title"), 
					resultSet.getString("author"), 
					resultSet.getInt("pages"));
			
		}
		
		statement.close();
		disConnect();
		
		return book;
	}
	
	
	
	

}
