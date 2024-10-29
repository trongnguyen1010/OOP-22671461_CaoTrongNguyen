package onTapGK;

public class Book {
	protected String bookName;
	protected double price;
	protected int quantity;
	protected Author[] authorList = null;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book(String bookName, double price, Author[] authorList) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.authorList = authorList;
	}
	public Book(String bookName, double price, int quantity, Author[] authorList) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.quantity = quantity;
		this.authorList = authorList;
	}
	
	public Author[] getAuthorList() {
		return authorList;
	}
	public String getAuthorNames() {
		String nameAuthor = "";
		for (Author au : getAuthorList()) {
			nameAuthor += au.getName() +", ";
		}
		return nameAuthor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="";
		str+= String.format("%-35s%-20.2f%-20d", getBookName(), getPrice(), getQuantity());
		return str;
	}
}
 