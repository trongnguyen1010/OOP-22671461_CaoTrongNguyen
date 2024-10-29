package onTapGK;

public class Author {
	protected String name;
	protected String email;
	protected char gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Author(String name, String email, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	public Author() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="";
		str+= String.format("%-35s%-35s%-10c", getName(), getEmail(), getGender());
		return str;
	}
	
}
