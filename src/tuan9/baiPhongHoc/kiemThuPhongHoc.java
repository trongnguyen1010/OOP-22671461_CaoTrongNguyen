package tuan9.baiPhongHoc;

import java.util.Scanner;

public class kiemThuPhongHoc {
	static DanhSachPhong DSPhong = new DanhSachPhong();
	static PhongHoc phongHoc;
	
	static Scanner sc = new Scanner(System.in);;
	
	static String XuatTieuDe() {
		return String.format("%-10s%-15s%-15s%-15s%-20s", "Day nha","Ma phong", "SLBD","Dien tich", "Ghi chu");
	}
	static void Menu() {
		System.out.println("\t****************************************");
		System.out.println("\t**   Chuong trinh quan ly phong hoc   **");
		System.out.println("\t*1.Doc du lieu                         *");
		System.out.println("\t*2.Them mot phong                      *");
		System.out.println("\t*3.Xoa                                 *");
		System.out.println("\t*4.Sua                                 *");
		System.out.println("\t*5.Xuat danh sach phong dat chuan      *");
		System.out.println("\t*6.Xuat danh sach cac phong            *");
		System.out.println("\t*7.Sap xep theo day nha                *");
		System.out.println("\t*8.Sap xep theo dien tich              *");
		System.out.println("\t*9.Sap xep theo so bong den tang dan   *");
		System.out.println("\t*10.Danh sach cac phong co 60 may      *");
		System.out.println("\t*11.Tong so cac phong                  *");
		System.out.println("\t*12.Tong so phong hoc                  *");
		System.out.println("\t*13.Sap xep theo 3 thuoc tinh          *");
		System.out.println("\t*14.Thoat chuong trinh                 *");
		System.out.println("\t****************************************");
		System.out.println("---Nhap lua chon---");
	}
	static void MenuChung() {
		System.out.println("\t****************************************");
		System.out.println("\t**     Moi nhap thong tin can sua     **");
		System.out.println("\t*1.Day nha                             *");
		System.out.println("\t*2.So bong den                         *");
		System.out.println("\t*3.Dien tich                           *");
	}
	static void menuSuaPLT() {
		MenuChung();
		System.out.println("\t*4.May chieu                           *");
		System.out.println("\t*5.Ve menu chinh                       *");
		System.out.println("\t****************************************");
		System.out.println("---Nhap lua chon---");
	}
	static void menuSuaPMT() {
		MenuChung();
		System.out.println("\t*4.So luong may tinh                   *");
		System.out.println("\t*5.Ve menu chinh                       *");
		System.out.println("\t****************************************");
		System.out.println("---Nhap lua chon---");
	}
	static void menuSuaPTN() {
		MenuChung();
		System.out.println("\t*4.Bon rua tay                           *");
		System.out.println("\t*5.Ve menu chinh                       *");
		System.out.println("\t****************************************");
		System.out.println("---Nhap lua chon---");
	}
	static void nhapCung() throws Exception {
		PhongHoc p1 = new PhongLyThuyet("V", "V14.01", 100, 100, true);
		PhongHoc p2 = new PhongLyThuyet("V", "V14.02", 80, 80, false);
		PhongHoc p3 = new PhongMayTinh("H", "H51", 61, 65, 70);
		PhongHoc p4 = new PhongMayTinh("H", "H52", 70, 40, 60);
		PhongHoc p5 = new PhongThiNghiem("X", "X10", 20, 10, false);
		PhongHoc p6 = new PhongThiNghiem("X", "X12", 30, 15, true);
		DSPhong.them(p1);
		DSPhong.them(p2);
		DSPhong.them(p3);
		DSPhong.them(p4);
		DSPhong.them(p5);
		DSPhong.them(p6);
		
			System.out.println("Da nhap du lieu thanh cong");
	}
	static PhongHoc themPhongHoc() {
		String dayNha;
		String maPhong;
		double dienTich;
		int soBongDen;
		System.out.println("Nhap ma phong: ");
		maPhong = sc.nextLine();
		if(DSPhong.timKiemViTri(maPhong)!=-1) {//tim thay
			System.out.println("Ma phong trung");
			return null;
		}else {//Khong tim thay
			System.out.println("Nhap day nha: ");
			dayNha = sc.nextLine();
			System.out.println("Nhap dien tich: ");
			dienTich = sc.nextDouble();
			System.out.println("Nhap so bong den: ");
			soBongDen = sc.nextInt();
			System.out.println("Nhap [1] neu la phong ly thuyet"
					+ "[2] neu la phong may tinh"
					+ "hoac khac de nhap phong thi nghiem");
			int luachon = sc.nextInt();
			if(luachon == 1) {//Phong ly thuyet
				boolean mayChieu;
				System.out.println("Phong nay co may chieu hay khong[Y/N]: ");
				String coMC = sc.next();
				while(!coMC.equalsIgnoreCase("y") && !coMC.equalsIgnoreCase("n")) {
					System.out.println("Vui long nhap dung yeu cau");
					System.out.println("Phong nay co may chieu hay khong[Y/N]: ");
					coMC = sc.next();
				}
				mayChieu = (coMC.equalsIgnoreCase("Y")) ? true : false;
				phongHoc = new PhongLyThuyet(dayNha, maPhong, soBongDen, dienTich, mayChieu);
			}else if(luachon == 2) {//Phong may tinh
				int soLuong;
				System.out.println("Nhap so luong may tinh: ");
				soLuong = sc.nextInt();
				phongHoc = new PhongMayTinh(dayNha, maPhong, soBongDen, dienTich, soLuong);
			}else {//Phong thi nghiem
				boolean bonRuaTay;
				System.out.println("Phong nay co bon rua tay hay khong[Y/N]:");
				String coBRT = sc.nextLine();
				while(!coBRT.equalsIgnoreCase("y") && !coBRT.equalsIgnoreCase("n")) {
					System.out.println("Vui long nhap dung yeu cau");
					System.out.println("Phong nay co bon rua tay hay khong[Y/N]:");
					coBRT = sc.nextLine();
				}
				bonRuaTay = (coBRT.equalsIgnoreCase("Y")) ? true : false;
				phongHoc = new PhongThiNghiem(dayNha, maPhong, soBongDen, dienTich, bonRuaTay);
			}
		}
		return phongHoc;
	}
	
	static void xuat() {
		System.out.println("\n\t\t\tDANH SACH CAC PHONG\n\n");
		System.out.println(XuatTieuDe());
		System.out.println("====================================================================");
		for(PhongHoc phong : DSPhong.getDSPhong()) {
			System.out.println(phong);
		}
		System.out.println("\n\n\n");
	}
	
	static void xoaPhong() {
		System.out.println("Nhap ma phong can xoa: ");
		String maPhong = sc.nextLine();
		PhongHoc px = DSPhong.timKiemPhongHoc(maPhong);
		if(px==null) {
			System.out.println("Khong tim thay ma phong");
		}else {
			System.out.println("Ban co xac nhan muon xoa khong[Y/N]: ");
			String acp = sc.nextLine();
			if(acp.equalsIgnoreCase("Y")) {
				DSPhong.xoa(px);
			}else {
				System.out.println("Ban giu lai phong nay");
			}
		}
	}
	
	static void suaChung(int chon, PhongHoc phong) {
		switch (chon) {
		case 1: {
			System.out.println("Nhap day nha: ");
			phong.setDayNha(sc.nextLine());
			break;
		}
		case 2:{
			System.out.println("Nhap dien tich: ");
			phong.setDienTich(sc.nextDouble());
			break;
		}
		case 3:{
			System.out.println("Nhap so bong den: ");
			phong.setSoBongDen(sc.nextInt());
			break;
		}
		}
	}
	
	static void suaPhong() {
		int chon = -1 , cnt = 0;
		System.out.println("Nhap ma phong can sua: ");
		String maPhong = sc.nextLine();
		PhongHoc ps = DSPhong.timKiemPhongHoc(maPhong);
		if(ps==null) {
			System.out.println("Khong tim thay ma phong");
		}else {
			System.out.println(XuatTieuDe());
			System.out.println("===============================================================");
			System.out.println("Thong tin phong truoc khi sua: \n" + ps);
			if(ps instanceof PhongLyThuyet) {//Neu la phong ly thuyet
				PhongLyThuyet psh = (PhongLyThuyet) ps;
				do {
					menuSuaPLT();
					chon = sc.nextInt();
					cnt++;
					suaChung(chon, psh);
					if(chon==4) {
						System.out.println("Phong nay co may chieu hay khong[Y/N]: ");
						String coMC = sc.nextLine();
						while(!coMC.equalsIgnoreCase("y") && !coMC.equalsIgnoreCase("n")) {
							System.out.println("Vui long nhap dung yeu cau");
							System.out.println("Phong nay co may chieu hay khong[Y/N]: ");
							coMC = sc.nextLine();
						}
						psh.setMayChieu((coMC.equalsIgnoreCase("Y")) ? true : false);
					}
					if(chon==5) {
						if(cnt>1)
							DSPhong.sua(psh);
						System.out.println("Ve menu chinh");
						break;
					}
				} while (chon<6);
			}else if(ps instanceof PhongMayTinh){//Neu la phong may tinh 
				PhongMayTinh phs = (PhongMayTinh) ps;
				do {
					menuSuaPMT();
					chon = sc.nextInt();
					cnt++;
					suaChung(chon, phs);
					if(chon==4) {
						System.out.println("Nhap so luong may tinh: ");
						int soLuongMayTinh = sc.nextInt();
					}
					if(chon==5) {
						if(cnt>1)
							DSPhong.sua(phs);
						System.out.println("Ve menu chinh");
						break;
					}
				} while (chon<6);
			}else {//Neu phong thi nghiem
				do {
					PhongThiNghiem psh = (PhongThiNghiem) ps;
					menuSuaPTN();
					chon = sc.nextInt();
					cnt++;
					suaChung(chon, psh);
					if(chon==4) {
						System.out.println("Phong nay co bon rua tay hay khong[Y/N]: ");
						String coBRT = sc.nextLine();
						while(!coBRT.equalsIgnoreCase("y") && !coBRT.equalsIgnoreCase("n")) {
							System.out.println("Vui long nhap dung yeu cau");
							System.out.println("Phong nay co bon rua tay hay khong[Y/N]: ");
							coBRT = sc.nextLine();
						}
						psh.setBonRuaTay((coBRT.equalsIgnoreCase("y")) ? true : false);
					}
					if(chon==5) {
						if(cnt>1)
							DSPhong.sua(psh);
						System.out.println("Ve menu chinh");
						break;
					}
				} while (chon < 6);
			}
		}
	}
	
	static void xuatPhongDatChuan() {
		System.out.println("\t\t\tDANH SACH PHONG DAT CHUAN\n\n");
		System.out.println(XuatTieuDe());
		System.out.println("==================================================================");
		for(PhongHoc phong : DSPhong.getDSPhongDatChuan()) {
			System.out.println(phong);
		}
		System.out.println("\n\n\n");
	}
	
	static void sortTheoTenDayNha() {
		DSPhong.sortTheoDayNha();
		System.out.println("Da sap xep thanh cong");
	}
	
	static void sortTheoDienTichGiam() {
		DSPhong.sortTheoDienTich();
		System.out.println("Da sap xep thanh cong");
	}
	
	static void sortTheoSoBongDenTangDan() {
		DSPhong.sortTheoBongDen();
		System.out.println("Da sap xep thanh cong");
	}
	
	static void xuatPhongMayTinh60() {
		if(DSPhong.DSPhongHocCoSoMayCo60().size()==0) {
			System.out.println("Khong co may tinh nao");
		}else {
			System.out.println("\t\t\tDANH SACH PHONG CO 60 MAY TINH\n\n");
			System.out.println(XuatTieuDe());
			System.out.println("==============================================================");
			for(PhongHoc phong : DSPhong.DSPhongHocCoSoMayCo60()) {
				System.out.println(phong);
			}
			System.out.println("\n\n\n");
		}
	}
	
	static void themMem() throws Exception {
		PhongHoc ph = themPhongHoc();
		if(ph!=null) {
			DSPhong.them(ph);
			System.out.println("Them thanh cong");
		}
	}
	
	static void xuatTongSoPhongHoc() {
		System.out.println("Co tong cong: " + DSPhong.getSoLuongPhong() + "Phong hoc");
	}
	
	static void demSoLuongNhaHienCo() {
		System.out.println("Co tat ca: " + DSPhong.demSoDayNha() + "day nha");
	}
	
	static void sortTheo3Truong() {
		DSPhong.sortTheo3ThuocTinh();
		System.out.println("Da sap xep thanh cong");
	}
	
	public static void main(String[] args) {
		try {
			int chon = -1;
			do {
				Menu();
				chon = sc.nextInt();
				switch(chon) {
				case 1: {
					nhapCung();
					break;
				}
				case 2:{
					themMem();
					break;
				}
				case 3:{
					xoaPhong();
					break;
				}
				case 4:{
					suaPhong();
					break;
				}
				case 5:{
					xuatPhongDatChuan();
					break;
				}
				case 6:{
					xuat();
					break;
				}
				case 7:{
					sortTheoTenDayNha();
					break;
				}
				case 8:{
					sortTheoDienTichGiam();
					break;
				}
				case 9:{
					sortTheoSoBongDenTangDan();
					break;
				}
				case 10:{
					xuatPhongMayTinh60();
					break;
				}
				case 11:{
					xuatTongSoPhongHoc();
					break;
				}
				case 12:{
					demSoLuongNhaHienCo();
					break;
				}
				case 13:{
					sortTheo3Truong();
					break;
				}
				}
			} while (chon<14);
			
		} catch (ArithmeticException e1) {
			// TODO: handle exception
			System.out.println("Khong duoc chia cho 0" + e1.getMessage());
		}catch (ArrayIndexOutOfBoundsException e2) {
			// TODO: handle exception
			System.out.println("Loi mang" + e2.getMessage());
		}catch (Exception e3) {
			// TODO: handle exception
			System.out.println("Loi khong xac dinh" + e3.getMessage());
		}
	}
}
