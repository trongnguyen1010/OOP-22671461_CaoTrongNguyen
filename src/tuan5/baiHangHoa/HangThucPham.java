package tuan5.baiHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                    LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngaySanXuat == null || ngayHetHan == null) {
            throw new IllegalArgumentException("Ngày sản xuất và ngày hết hạn không được để trống.");
        }
        if (ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất.");
        }
        if (nhaCungCap == null || nhaCungCap.trim().isEmpty()) {
            throw new IllegalArgumentException("Nhà cung cấp không được để trống.");
        }
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat == null) {
            throw new IllegalArgumentException("Ngày sản xuất không được để trống.");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isBefore(this.ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất.");
        }
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        if (nhaCungCap == null || nhaCungCap.trim().isEmpty()) {
            throw new IllegalArgumentException("Nhà cung cấp không được để trống.");
        }
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return 0.05;
    }

    @Override
    public String danhGiaBanBuon() {
        if (getSoLuongTon() > 0 && LocalDate.now().isAfter(ngayHetHan)) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() +
               ", Ngày Sản Xuất: " + ngaySanXuat.format(formatter) +
               ", Ngày Hết Hạn: " + ngayHetHan.format(formatter) +
               ", Nhà Cung Cấp: " + nhaCungCap;
    }
}
