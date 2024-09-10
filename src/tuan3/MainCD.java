package tuan3;

import java.util.Scanner;

public class MainCD {
	public static void main(String[] args) {
        CDList cdList = new CDList(10); // Khởi tạo danh sách CD với kích thước tối đa 10
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- QUẢN LÝ CD ---");
            System.out.println("1. Thêm CD");
            System.out.println("2. Hiển thị số lượng CD");
            System.out.println("3. Tính tổng giá thành của các CD");
            System.out.println("4. Sắp xếp giảm dần theo giá thành");
            System.out.println("5. Sắp xếp tăng dần theo tựa CD");
            System.out.println("6. Xuất toàn bộ danh sách CD");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã CD: ");
                    int maCD = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập tựa CD: ");
                    String tuaCD = scanner.nextLine();

                    System.out.print("Nhập ca sĩ: ");
                    String caSy = scanner.nextLine();

                    System.out.print("Nhập số bài hát: ");
                    int soBaiHat = scanner.nextInt();

                    System.out.print("Nhập giá thành: ");
                    double giaThanh = scanner.nextDouble();

                    CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
                    if (cdList.themCD(cd)) {
                        System.out.println("Thêm CD thành công.");
                    } else {
                        System.out.println("Thêm CD thất bại.");
                    }
                    break;

                case 2:
                    System.out.println("Số lượng CD hiện tại: " + cdList.tinhSoLuongCD());
                    break;

                case 3:
                    System.out.println("Tổng giá thành của các CD: " + cdList.tinhTongGiaThanh());
                    break;

                case 4:
                    cdList.sapXepGiamDanTheoGiaThanh();
                    System.out.println("Danh sách CD đã được sắp xếp giảm dần theo giá thành.");
                    break;

                case 5:
                    cdList.sapXepTangDanTheoTuaCD();
                    System.out.println("Danh sách CD đã được sắp xếp tăng dần theo tựa CD.");
                    break;

                case 6:
                    System.out.println("Danh sách CD:");
                    cdList.xuatDanhSach();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
