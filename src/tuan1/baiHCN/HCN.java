package tuan1.baiHCN;

public class HCN {
	private double chieuDai;
	private double chieuRong;
	
	public double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}
	public double getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	public double tinhChuVi() {
		
		return 2 *(chieuDai + chieuRong);
	}
	public double tinhDienTich() {
		return chieuDai * chieuRong;
	}
	//phuong thuc toString 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hình chữ nhật có chi�?u dài = " + getChieuDai() + ", chi�?u rộng = " + getChieuRong() + ",\n Diện tích = "
				+ tinhDienTich() + ", Chu Vi = " + tinhChuVi();
	}	
}
