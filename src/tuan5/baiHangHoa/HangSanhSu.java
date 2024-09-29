package tuan5.baiHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
                        String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (nhaSanXuat == null || nhaSanXuat.trim().isEmpty()) {
            throw new IllegalArgumentException("Nhà sản xuất không được để trống.");
        }
        if (ngayNhapKho == null) {
            throw new IllegalArgumentException("Ngày nhập kho không được để trống.");
        }
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        if (nhaSanXuat == null || nhaSanXuat.trim().isEmpty()) {
            throw new IllegalArgumentException("Nhà sản xuất không được để trống.");
        }
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if (ngayNhapKho == null) {
            throw new IllegalArgumentException("Ngày nhập kho không được để trống.");
        }
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return 0.10;
    }

    @Override
    public String danhGiaBanBuon() {
        long soNgayLuuKho = LocalDate.now().toEpochDay() - ngayNhapKho.toEpochDay();
        if (getSoLuongTon() > 50 && soNgayLuuKho > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() +
               ", Nhà Sản Xuất: " + nhaSanXuat +
               ", Ngày Nhập Kho: " + ngayNhapKho.format(formatter);
    }
}
