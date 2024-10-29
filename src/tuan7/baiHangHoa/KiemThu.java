package tuan7.baiHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KiemThu {
    private static QuanLyHangHoa quanLyHangHoa = new QuanLyHangHoa();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int luaChon;
        do {
            hienThiMenu();
            luaChon = nhapLuaChon();
            xuLyLuaChon(luaChon);
        } while (luaChon != 0);
    }

    private static void hienThiMenu() {
        System.out.println("===== QUẢN LÝ HÀNG HÓA SIÊU THỊ =====");
        System.out.println("1. Thêm Hàng Thực Phẩm");
        System.out.println("2. Thêm Hàng Điện Máy");
        System.out.println("3. Thêm Hàng Sành Sứ");
        System.out.println("4. In Danh Sách Hàng Hóa");
        System.out.println("5. Tính Tổng VAT");
        System.out.println("6. Đánh Giá Mức Độ Bán Buôn");
        System.out.println("0. Thoát");
        System.out.println("=======================================");
        System.out.print("Chọn chức năng: ");
    }

    private static int nhapLuaChon() {
        int luaChon = -1;
        try {
            luaChon = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Không làm gì
        }
        return luaChon;
    }

    private static void xuLyLuaChon(int luaChon) {
        switch (luaChon) {
            case 1:
                themHangThucPham();
                break;
            case 2:
                themHangDienMay();
                break;
            case 3:
                themHangSanhSu();
                break;
            case 4:
                quanLyHangHoa.inDanhSachHangHoa();
                break;
            case 5:
                System.out.println("Tổng VAT của tất cả hàng hóa: " + quanLyHangHoa.tinhTongVAT());
                break;
            case 6:
                quanLyHangHoa.danhGiaMucDoBanBuon();
                break;
            case 0:
                System.out.println("Kết thúc chương trình. Chào tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
        }
    }

    private static void themHangThucPham() {
        try {
            System.out.println("=== Thêm Hàng Thực Phẩm ===");
            String maHang = nhapMaHang();
            String tenHang = nhapTenHang();
            int soLuongTon = nhapSoLuongTon();
            double donGia = nhapDonGia();
            LocalDate ngaySanXuat = nhapNgay("Ngày Sản Xuất (dd/MM/yyyy): ");
            LocalDate ngayHetHan = nhapNgay("Ngày Hết Hạn (dd/MM/yyyy): ");
            String nhaCungCap = nhapNhaCungCap();

            HangHoa hangThucPham = new HangThucPham(maHang, tenHang, soLuongTon, donGia,
                    ngaySanXuat, ngayHetHan, nhaCungCap);

            if (quanLyHangHoa.themHangHoa(hangThucPham)) {
                System.out.println("Thêm hàng thực phẩm thành công.");
            } else {
                System.out.println("Thêm thất bại. Mã hàng đã tồn tại.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void themHangDienMay() {
        try {
            System.out.println("=== Thêm Hàng Điện Máy ===");
            String maHang = nhapMaHang();
            String tenHang = nhapTenHang();
            int soLuongTon = nhapSoLuongTon();
            double donGia = nhapDonGia();
            int thoiGianBaoHanh = nhapThoiGianBaoHanh();
            double congSuat = nhapCongSuat();

            HangHoa hangDienMay = new HangDienMay(maHang, tenHang, soLuongTon, donGia,
                    thoiGianBaoHanh, congSuat);

            if (quanLyHangHoa.themHangHoa(hangDienMay)) {
                System.out.println("Thêm hàng điện máy thành công.");
            } else {
                System.out.println("Thêm thất bại. Mã hàng đã tồn tại.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void themHangSanhSu() {
        try {
            System.out.println("=== Thêm Hàng Sành Sứ ===");
            String maHang = nhapMaHang();
            String tenHang = nhapTenHang();
            int soLuongTon = nhapSoLuongTon();
            double donGia = nhapDonGia();
            String nhaSanXuat = nhapNhaSanXuat();
            LocalDate ngayNhapKho = nhapNgay("Ngày Nhập Kho (dd/MM/yyyy): ");

            HangHoa hangSanhSu = new HangSanhSu(maHang, tenHang, soLuongTon, donGia,
                    nhaSanXuat, ngayNhapKho);

            if (quanLyHangHoa.themHangHoa(hangSanhSu)) {
                System.out.println("Thêm hàng sành sứ thành công.");
            } else {
                System.out.println("Thêm thất bại. Mã hàng đã tồn tại.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Các phương thức nhập dữ liệu
    private static String nhapMaHang() {
        System.out.print("Mã Hàng: ");
        return scanner.nextLine().trim();
    }

    private static String nhapTenHang() {
        System.out.print("Tên Hàng: ");
        return scanner.nextLine().trim();
    }

    private static int nhapSoLuongTon() {
        int soLuongTon = -1;
        while (soLuongTon < 0) {
            try {
                System.out.print("Số Lượng Tồn: ");
                soLuongTon = Integer.parseInt(scanner.nextLine());
                if (soLuongTon < 0) {
                    System.out.println("Số lượng tồn phải >= 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
        return soLuongTon;
    }

    private static double nhapDonGia() {
        double donGia = -1;
        while (donGia <= 0) {
            try {
                System.out.print("Đơn Giá: ");
                donGia = Double.parseDouble(scanner.nextLine());
                if (donGia <= 0) {
                    System.out.println("Đơn giá phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực.");
            }
        }
        return donGia;
    }

    private static LocalDate nhapNgay(String prompt) {
        LocalDate ngay = null;
        while (ngay == null) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                ngay = LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập ngày đúng định dạng (dd/MM/yyyy).");
            }
        }
        return ngay;
    }

    private static String nhapNhaCungCap() {
        System.out.print("Nhà Cung Cấp: ");
        return scanner.nextLine().trim();
    }

    private static int nhapThoiGianBaoHanh() {
        int thoiGianBaoHanh = -1;
        while (thoiGianBaoHanh < 0) {
            try {
                System.out.print("Thời Gian Bảo Hành (tháng): ");
                thoiGianBaoHanh = Integer.parseInt(scanner.nextLine());
                if (thoiGianBaoHanh < 0) {
                    System.out.println("Thời gian bảo hành phải >= 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
        return thoiGianBaoHanh;
    }

    private static double nhapCongSuat() {
        double congSuat = -1;
        while (congSuat <= 0) {
            try {
                System.out.print("Công Suất (KW): ");
                congSuat = Double.parseDouble(scanner.nextLine());
                if (congSuat <= 0) {
                    System.out.println("Công suất phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực.");
            }
        }
        return congSuat;
    }

    private static String nhapNhaSanXuat() {
        System.out.print("Nhà Sản Xuất: ");
        return scanner.nextLine().trim();
    }
}
