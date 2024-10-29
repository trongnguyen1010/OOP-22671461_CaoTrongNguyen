package onTapGK;

public class kiemThuBook {
	static String xuatTieuDeSach(){
		return String.format("-----------------------------------Sach----------------------------------------\n" +
								"%-35s%-20s%-20s","Ten sach", "Gia tien", "So luong");
	}
	static String xuatTieuDeTacGia(){
		return String.format("---------------------------Danh sach tac gia-----------------------------------\n" +
								"%-35s%-35s%-10s","Ten tac gia", "Email", "Gioi tinh");
	}
	public static void nhapCung() {
		Author[] dsAuthor1 = new Author[2];
		Author[] dsAuthor2 =  new Author[3];
		dsAuthor1[0] = new Author("Nguyen Van A", "nguyenvana@gmail.com", 'm'); 
		dsAuthor1[1] = new Author("Nguyen Van B", "nguyenvanb@gmail.com", 'm');
		dsAuthor2[0] = new Author("Nguyen Thi C", "nguyenthic@gmail.com", 'f');
		dsAuthor2[1] = new Author("Nguyen Van D", "nguyenvanD@gmail.com", 'm');
		dsAuthor2[2] = new Author("Nguyen Thi E", "nguyenthie@gmail.com", 'f');
		
		Book b1 = new Book("Lap trinh OOP1", 100, dsAuthor1);
		Book b2 = new Book("Lap Trinh OOP2", 200, dsAuthor2);
		
		System.out.println(xuatTieuDeSach());
		System.out.println(b1);
		System.out.println(xuatTieuDeTacGia());
		for(Author au : b1.getAuthorList()) {
			System.out.println(au);
		}
		
		System.out.println(xuatTieuDeSach());
		System.out.println(b2);
		System.out.println(xuatTieuDeTacGia());
		for(Author au : b2.getAuthorList()) {
			System.out.println(au);
		}
	}
	
	public static void main(String[] args) {
		nhapCung();
	}
		
}
