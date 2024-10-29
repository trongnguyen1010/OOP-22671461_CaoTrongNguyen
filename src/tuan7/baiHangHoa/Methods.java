package tuan7.baiHangHoa;
import java.util.ArrayList;

public interface Methods {
	
	public boolean themHangHoa(HangHoa hangHoa) throws Exception;
	
	public boolean maHangTonTai(String maHang);
	
	public HangHoa timKiemHangHoa(String maHang);
	
	public void xoa(HangHoa hangHoa);
	
	public void sua(HangHoa hangHoa);
	
	public void sortHangHoa();
	
	public void setDSHangHoa(ArrayList<HangHoa> dsHangHoa);

	public ArrayList<HangHoa> getDSHangHoa();
	
	public double tinhTongVAT();
	
	public void  danhGiaMucDoBanBuon();
}
