									//=====Cao Trọng Nguyễn - 22671461====	
package tuan5.baiHangHoa;     

import java.util.Objects;

public abstract class HangHoa {
    private final String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống.");
        }
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0.");
        }
        if (donGia <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0.");
        }
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống.");
        }
        this.tenHang = tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0.");
        }
        this.soLuongTon = soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0.");
        }
        this.donGia = donGia;
    }

    public abstract double tinhVAT();

    public abstract String danhGiaBanBuon();

    @Override
    public String toString() {
        return "Mã Hàng: " + maHang +
               ", Tên Hàng: " + tenHang +
               ", Số Lượng Tồn: " + soLuongTon +
               ", Đơn Giá: " + donGia +
               ", VAT: " + (tinhVAT() * 100) + "%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HangHoa HangHoa = (HangHoa) o;

        return Objects.equals(maHang, HangHoa.maHang);
    }

    @Override
    public int hashCode() {
        return maHang != null ? maHang.hashCode() : 0;
    }
}
