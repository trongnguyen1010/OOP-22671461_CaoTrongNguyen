package tuan3.baiHangThucPham;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HangThucPham {
	private final String maHang;       
    private String tenHang;            
    private double donGia;            
    private Date ngaySanXuat;          
    private Date ngayHetHan;           

    // Constructor có đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    // Constructor có tham số là mã hàng
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
    }

    // Setters và Getters
    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "Không xác định";
        } else {
            this.tenHang = tenHang;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 1000.0; // Giá trị mặc định
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            this.ngaySanXuat = new Date(); // Ngày hiện tại
        } else {
            this.ngaySanXuat = ngaySanXuat;
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null || ngayHetHan.before(this.ngaySanXuat)) {
            this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + (1000L * 60 * 60 * 24)); // Một ngày sau ngày sản xuất
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }

    public String getMaHang() {
        return maHang;
    }

    // Phương thức kiểm tra hàng thực phẩm đã hết hạn chưa
    public boolean isExpired() {
        return new Date().after(ngayHetHan);
    }

    // Phương thức toString để in thông tin hàng thực phẩm
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        
        return "Mã hàng: " + maHang +
               ", Tên hàng: " + tenHang +
               ", Đơn giá: " + currencyFormat.format(donGia) +
               ", Ngày sản xuất: " + dateFormat.format(ngaySanXuat) +
               ", Ngày hết hạn: " + dateFormat.format(ngayHetHan) +
               ", Trạng thái: " + (isExpired() ? "Hết hạn" : "Còn hạn");
    }
}
