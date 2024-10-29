package tuan7.baiHangHoa;

import java.util.ArrayList;

public class QuanLyHangHoa implements Methods{
    private ArrayList<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        danhSachHangHoa = new ArrayList<>();
    }

    // Kiểm tra xem mã hàng đã tồn tại chưa
    public boolean maHangTonTai(String maHang) {
        for (HangHoa HangHoa : danhSachHangHoa) {
            if (HangHoa.getMaHang().equalsIgnoreCase(maHang)) {
                return true;
            }
        }
        return false;
    }

    // Thêm hàng hóa vào danh sách nếu mã hàng không trùng
    public boolean themHangHoa(HangHoa hangHoa) {
        if (maHangTonTai(hangHoa.getMaHang())) {
            return false; // Mã hàng đã tồn tại
        }
        danhSachHangHoa.add(hangHoa);
        return true;
    }

    // In danh sách hàng hóa
    public void inDanhSachHangHoa() {
        if (danhSachHangHoa.isEmpty()) {
            System.out.println("Danh sách hàng hóa trống.");
            return;
        }
        for (HangHoa HangHoa : danhSachHangHoa) {
            System.out.println(HangHoa);
            System.out.println("Đánh Giá: " + HangHoa.danhGiaBanBuon());
            System.out.println("--------------------------------------------");
        }
    }

    // Tính tổng VAT của tất cả hàng hóa
    public double tinhTongVAT() {
        double tongVAT = 0;
        for (HangHoa HangHoa : danhSachHangHoa) {
            tongVAT += HangHoa.getDonGia() * HangHoa.tinhVAT();
        }
        return tongVAT;
    }

    // Đánh giá mức độ bán buôn của từng loại hàng hóa
    public void danhGiaMucDoBanBuon() {
        if (danhSachHangHoa.isEmpty()) {
            System.out.println("Danh sách hàng hóa trống.");
            return;
        }
        for (HangHoa HangHoa : danhSachHangHoa) {
            System.out.println("Mã Hàng: " + HangHoa.getMaHang() + " - Đánh Giá: " + HangHoa.danhGiaBanBuon());
        }
    }


	@Override
	public HangHoa timKiemHangHoa(String maHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void xoa(HangHoa hangHoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sua(HangHoa hangHoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortHangHoa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDSHangHoa(ArrayList<HangHoa> dsHangHoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HangHoa> getDSHangHoa() {
		// TODO Auto-generated method stub
		return null;
	}
}

