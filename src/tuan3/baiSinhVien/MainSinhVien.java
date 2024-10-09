package tuan3.baiSinhVien;

import java.util.Arrays;
import java.util.Scanner;

public class MainSinhVien {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng newline sau khi nhập số

        // Mảng chứa các sinh viên
        SinhVien[] danhSachSinhVien = new SinhVien[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Mã sinh viên: ");
            int maSinhVien = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();

            String soDienThoai;
            while (true) {
                System.out.print("Số điện thoại (7 chữ số): ");
                soDienThoai = scanner.nextLine();

                // Kiểm tra số điện thoại có đúng 7 chữ số và chỉ chứa ký tự số hay không
                if (soDienThoai.matches("\\d{7}")) {
                    break; // Thoát vòng lặp nếu hợp lệ
                } else {
                    System.out.println("Số điện thoại phải bao gồm đúng 7 chữ số. Vui lòng nhập lại.");
                }
            }

            // Tạo đối tượng sv và thêm vào mảng
            danhSachSinhVien[i] = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai);
        }

        // Gọi hàm sắp xếp
        sapXepSinhVienTheoTen(danhSachSinhVien);

        // Xuất danh sách
        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
        }
    }

    // Hàm sắp xếp sinh viên theo tên (phần tử cuối cùng trong họ tên)
    public static void sapXepSinhVienTheoTen(SinhVien[] danhSachSinhVien) {
        Arrays.sort(danhSachSinhVien, (sv1, sv2) -> {
            String[] parts1 = sv1.getHoTen().split(" ");
            String[] parts2 = sv2.getHoTen().split(" ");
            String lastName1 = parts1[parts1.length - 1]; // Lấy phần tử cuối
            String lastName2 = parts2[parts2.length - 1]; // Lấy phần tử cuối
            return lastName1.compareTo(lastName2);
        });
    }
}
