package tuan2;

import java.util.Scanner;

public class MainPhuongTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhuongTien xe1 = null;
        PhuongTien xe2 = null;
        PhuongTien xe3 = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3");
            System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
            System.out.println("3. Thoát");
            System.out.print("Chọn công việc: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm

            switch (luaChon) {
                case 1:
                    // Nhập thông tin xe 1
                    xe1 = taoXe(scanner, "xe1");
                    // Nhập thông tin xe 2
                    xe2 = taoXe(scanner, "xe2");
                    // Nhập thông tin xe 3
                    xe3 = taoXe(scanner, "xe3");
                    break;

                case 2:
                    System.out.println("\nBảng kê khai tiền thuế trước bạ:");
                    if (xe1 != null) xe1.hienThiThongTin();
                    if (xe2 != null) xe2.hienThiThongTin();
                    if (xe3 != null) xe3.hienThiThongTin();
                    break;

                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức phụ trợ để tạo đối tượng Vehicle
    private static PhuongTien taoXe(Scanner scanner, String tenXe) {
        System.out.printf("Nhập thông tin cho %s:\n", tenXe);
        System.out.print("Tên chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.print("Trị giá xe: ");
        double triGia = scanner.nextDouble();
        System.out.print("Dung tích xy-lanh: ");
        int dungTichXyLanh = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ nhớ đệm
        return new PhuongTien(chuSoHuu, triGia, dungTichXyLanh);
    }
}
