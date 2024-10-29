package tuan7.baiHangHoa;

public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh; // Tháng
    private double congSuat; // KW

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                            int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0.");
        }
        if (congSuat <= 0) {
            throw new IllegalArgumentException("Công suất phải > 0.");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0.");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if (congSuat <= 0) {
            throw new IllegalArgumentException("Công suất phải > 0.");
        }
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return 0.10;
    }

    @Override
    public String danhGiaBanBuon() {
        if (getSoLuongTon() < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Thời Gian Bảo Hành: " + thoiGianBaoHanh + " tháng" +
               ", Công Suất: " + congSuat + " KW";
    }
}
