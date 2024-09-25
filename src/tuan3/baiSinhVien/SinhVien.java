
													//Cao Trọng Nguyễn - MSSV:22671461
package tuan3.baiSinhVien;

public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    // Constructor mặc định
    public SinhVien() {
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    // Constructor có tham số
    public SinhVien(int maSinhVien, String hoTen, String diaChi, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return  "Ma Sinh Vien :" + maSinhVien +
                ", Ho Ten : '" + hoTen + '\'' +
                ", Dia Chi: '" + diaChi + '\'' +
                ", So Dien Thoai:" + soDienThoai;
    }
}
