package tuan9.baiPhongHoc;

public class PhongThiNghiem extends PhongHoc{
	private boolean bonRuaTay;

	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String dayNha, String maPhong, int soBongDen, double dienTich, boolean bonRuaTay) {
		super(dayNha, maPhong, soBongDen, dienTich);
		this.bonRuaTay = bonRuaTay;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isBonRuaTay() {
		return bonRuaTay ? true : false;
	}

	public void setBonRuaTay(boolean bonRuaTay) {
		this.bonRuaTay = bonRuaTay;
	}

	@Override
	boolean datChuan() {
		// TODO Auto-generated method stub
		return isBonRuaTay() && duSang() ? true : false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String brt = isBonRuaTay() ? "Co bon rua tay(PTN)" : "Khong bon rua tay(PTN)";
		return super.toString() + String.format("%-20s", brt);
	}
}
