package tuan4.quanlysach;

import java.util.ArrayList;
import java.util.Scanner;

public class KiemThu {
    
    public static void main(String[] args) {
        ArrayList<SachGiaoKhoa> arrSachGiaoKhoa = new ArrayList<>();
        ArrayList<SachThamKhao> arrSachThamKhao = new ArrayList<>();
        int soSachGiaoKhoa, soSachThamKhao;
        double tongTienSachGiaoKhoa = 0, tongTienSachThamKhao = 0, tongDonGiaSachThamKhao = 0, 
            trungBinhCongDonGia = 0;
        Scanner scanner = new Scanner(System.in);
         
        System.out.print("Nhập số sách giáo khoa: ");
        soSachGiaoKhoa = scanner.nextInt();
        System.out.print("Nhập số sách tham khảo: ");
        soSachThamKhao = scanner.nextInt();
         
        System.out.println("Nhập thông tin sách giáo khoa:");
        for (int i = 0; i < soSachGiaoKhoa; i++) {
            System.out.println("Nhập thông tin quyển sách thứ " + (i + 1) + ":");
            SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa();
            sachGiaoKhoa.nhapSach();
            arrSachGiaoKhoa.add(sachGiaoKhoa);
        }
         
        System.out.println("Nhập thông tin sách tham khảo:");
        for (int i = 0; i < soSachThamKhao; i++) {
            System.out.println("Nhập thông tin quyển sách thứ " + (i + 1) + ":");
            SachThamKhao sachThamKhao = new SachThamKhao();
            sachThamKhao.nhapSach();
            arrSachThamKhao.add(sachThamKhao);
        }
         
        for (int i = 0; i < arrSachGiaoKhoa.size(); i++) {
            if (arrSachGiaoKhoa.get(i).getNumber() == 0) {
                tongTienSachGiaoKhoa += arrSachGiaoKhoa.get(i).getSoLuong() * 
                    arrSachGiaoKhoa.get(i).getDonGia() * 50 / 100;
            } else if (arrSachGiaoKhoa.get(i).getNumber() == 1) {
                tongTienSachGiaoKhoa += arrSachGiaoKhoa.get(i).getSoLuong() * 
                    arrSachGiaoKhoa.get(i).getDonGia();
            }
        }
        System.out.println("Tổng tiền sách giáo khoa = " + tongTienSachGiaoKhoa);
         
        for (int i = 0; i < arrSachThamKhao.size(); i++) {
            tongTienSachThamKhao += arrSachThamKhao.get(i).getSoLuong() * 
                arrSachThamKhao.get(i).getDonGia() + arrSachThamKhao.get(i).getThue();
        }
        System.out.println("Tổng tiền sách tham khảo = " + tongTienSachThamKhao);
         
        System.out.println("-----Thông tin sách giáo khoa-----");
        for (int i = 0; i < arrSachGiaoKhoa.size(); i++) {
            System.out.println(arrSachGiaoKhoa.get(i).toString());
        }
         
        System.out.println("-----Thông tin sách tham khảo-----");
        for (int i = 0; i < arrSachThamKhao.size(); i++) {
            System.out.println(arrSachThamKhao.get(i).toString());
        }
         
        System.out.println("---Trung bình cộng đơn giá các sách tham khảo---");
        for (int i = 0; i < arrSachThamKhao.size(); i++) {
            tongDonGiaSachThamKhao += arrSachThamKhao.get(i).getDonGia();
            trungBinhCongDonGia = tongDonGiaSachThamKhao / arrSachThamKhao.size();
        }
        System.out.println("Trung bình cộng đơn giá các sách tham khảo = " + trungBinhCongDonGia);
         
        System.out.println("---Các sách giáo khoa của nhà xuất bản X---");
        for (int i = 0; i < arrSachGiaoKhoa.size(); i++) {
            if (arrSachGiaoKhoa.get(i).getNhaXuatBan().equalsIgnoreCase("X")) {
                System.out.println(arrSachGiaoKhoa.get(i).toString());
            }
        }
    }
 
}
