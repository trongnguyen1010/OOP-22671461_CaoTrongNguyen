package tuan4_quanlysach;

import java.util.ArrayList;
import java.util.List;

public class ListSach {

    private List<Sach> danhSachSach;

    public ListSach() {
        danhSachSach = new ArrayList<>();
    }

    public void nhapSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public void xuatDanhSach() {
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                System.out.println("Sách giáo khoa: " + sach.maSach + ", " + sach.ngayNhap + ", Thành tiền: " + sach.tinhThanhTien());
            } else if (sach instanceof SachThamKhao) {
                System.out.println("Sách tham khảo: " + sach.maSach + ", " + sach.ngayNhap + ", Thành tiền: " + sach.tinhThanhTien());
            }
        }
    }

    public double tinhTongThanhTienSachGiaoKhoa() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.tinhThanhTien();
            }
        }
        return tong;
    }

    public double tinhTrungBinhDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int count = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tongDonGia += sach.donGia;
                count++;
            }
        }
        return count > 0 ? tongDonGia / count : 0;
    }

    public void xuatSachGiaoKhoaCuaNhaXuatBan(String tenNhaXuatBan) {
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.nhaXuatBan.equals(tenNhaXuatBan)) {
                System.out.println("Sách giáo khoa của nhà xuất bản " + tenNhaXuatBan + ": " + sach.maSach + ", " + sach.ngayNhap);
            }
        }
    }
}
