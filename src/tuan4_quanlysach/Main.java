package tuan4_quanlysach;

public class Main {
    public static void main(String[] args) {
        ListSach thuVien = new ListSach();

        SachGiaoKhoa sach1 = new SachGiaoKhoa("SGK001", "01/09/2024", 100000, 5, "NXB A", "mới");
        SachGiaoKhoa sach2 = new SachGiaoKhoa("SGK002", "02/09/2024", 80000, 3, "NXB B", "cũ");
        SachThamKhao sach3 = new SachThamKhao("STK001", "03/09/2024", 150000, 2, "NXB C", 20000);

        thuVien.nhapSach(sach1);
        thuVien.nhapSach(sach2);
        thuVien.nhapSach(sach3);

        System.out.println("Danh sách các sách trong thư viện:");
        thuVien.xuatDanhSach();

        System.out.println("\nTổng thành tiền của sách giáo khoa: " + thuVien.tinhTongThanhTienSachGiaoKhoa());

        double trungBinhDonGia = thuVien.tinhTrungBinhDonGiaSachThamKhao();
        System.out.println("Trung bình đơn giá của sách tham khảo: " + trungBinhDonGia);

        String tenNXB = "NXB A";
        System.out.println("\nCác sách giáo khoa của nhà xuất bản " + tenNXB + ":");
        thuVien.xuatSachGiaoKhoaCuaNhaXuatBan(tenNXB);
    }
}

