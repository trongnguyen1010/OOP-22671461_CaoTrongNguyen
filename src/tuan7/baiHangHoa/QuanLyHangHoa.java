package tuan7.baiHangHoa;

import java.util.ArrayList;

public class QuanLyHangHoa {
    private ArrayList<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        danhSachHangHoa = new ArrayList<>();
    }

    // Kiểm tra xem mã hàng đã tồn tại chưa
    private boolean maHangTonTai(String maHang) {
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

    // Các phương thức khác như tìm kiếm, xóa, cập nhật có thể được thêm ở đây
}

