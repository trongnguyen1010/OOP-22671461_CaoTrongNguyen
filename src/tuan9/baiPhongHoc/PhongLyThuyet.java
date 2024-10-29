package tuan9.baiPhongHoc;

public class PhongLyThuyet extends PhongHoc {
	private boolean mayChieu;
	

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuyet(String dayNha, String maPhong, int soBongDen, double dienTich, boolean mayChieu) {
		super(dayNha, maPhong, soBongDen, dienTich);
		this.mayChieu = mayChieu;
		// TODO Auto-generated constructor stub
	}

	boolean datChuan() {
		return isMayChieu() && duSang() ? true : false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String mc = mayChieu ? "Co may chieu(PLT)" : "Khong co may chieu(PLT)";
		return super.toString() + String.format("%-20s", mc);
	}
}
