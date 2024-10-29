package tuan9.baiPhongHoc;

public class PhongMayTinh extends PhongHoc{
	private int soLuongMayTinh;
	private final double CHUANPM = 1.5;
	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhongMayTinh(String dayNha, String maPhong, int soBongDen, double dienTich, int soLuongMayTinh) {
		super(dayNha, maPhong, soBongDen, dienTich);
		this.soLuongMayTinh = soLuongMayTinh;
		// TODO Auto-generated constructor stub
	}
	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}
	public void setSoLuongMayTinh(int soLuongMayTinh) {
		this.soLuongMayTinh = soLuongMayTinh;
	}
	public boolean phongMayDatChuan() {
		return (getDienTich() / getSoLuongMayTinh()<=CHUANPM) ? true : false;
	}
	@Override
	boolean datChuan() {
		return phongMayDatChuan() && duSang() ? true : false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString() + String.format("%-2d", getSoLuongMayTinh() + "May tinh");
		return super.toString() + String.format("Co %d may tinh", getSoLuongMayTinh());
	}
}
