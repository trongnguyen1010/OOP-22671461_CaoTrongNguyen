package tuan9.baiPhongHoc;

import java.util.Objects;

abstract class PhongHoc {
	//Thuoc tinh
	protected String dayNha;
	protected String maPhong;
	protected int soBongDen;
	protected double dienTich;
	
	//ctr mac dinh
	public PhongHoc() {
		
	}
	//ctr full tham so
	public PhongHoc(String dayNha, String maPhong, int soBongDen, double dienTich) {
		super();
		this.dayNha = dayNha;
		this.maPhong = maPhong;
		this.soBongDen = soBongDen;
		this.dienTich = dienTich;
	}
	//abstract dat chuan kieu boolean
	abstract boolean datChuan();
	
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	
	
	//Check den du sang hay khong
	protected boolean duSang() {
		return (getDienTich() / getSoBongDen()<=10) ? true : false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-10s%-15s%-15d%-15.2f", getDayNha(),getMaPhong(),getSoBongDen(),getDienTich());
	}
}
