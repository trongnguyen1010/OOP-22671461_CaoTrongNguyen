package tuan4.quanlysach;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang; // 'mới' hoặc 'cũ'

    public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equals("mới")) {
            return soLuong * donGia;
        } else if (tinhTrang.equals("cũ")) {
            return soLuong * donGia * 0.5;
        } else {
            throw new IllegalArgumentException("Tình trạng sách không hợp lệ.");
        }
    }

    // Getter và Setter nếu cần
}
