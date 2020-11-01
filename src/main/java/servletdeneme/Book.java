package servletdeneme;

public class Book {
	private int ID;
	private String title;
	private String author;
	private int pages;

	public Book() {
		
	}

	public Book(String title, String author, int pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
	}

	public Book(int ID, String title, String author, int pages) {
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
