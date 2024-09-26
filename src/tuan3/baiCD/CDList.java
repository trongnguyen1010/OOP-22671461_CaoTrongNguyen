package tuan3.baiCD;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
    private CD[] danhSachCD;
    private int soLuongCD;

    // Constructor với kích thước tối đa của danh sách
    public CDList(int kichThuoc) {
        danhSachCD = new CD[kichThuoc];
        soLuongCD = 0;
    }

    //thêm 1 CD vào danh sách
    public boolean themCD(CD cd) {
        if (soLuongCD >= danhSachCD.length) {
            System.out.println("Danh sách đã đầy, không thể thêm CD mới.");
            return false;
        }
        for (int i = 0; i < soLuongCD; i++) {
            if (danhSachCD[i].getMaCD() == cd.getMaCD()) {
                System.out.println("Mã CD đã tồn tại, không thể thêm CD mới.");
                return false;
            }
        }
        danhSachCD[soLuongCD++] = cd;
        return true;
    }

    // Tính số lượng CD trong ds
    public int tinhSoLuongCD() {
        return soLuongCD;
    }

    // Tính tổng giá thành của các CD
    public double tinhTongGiaThanh() {
        double tongGiaThanh = 0;
        for (int i = 0; i < soLuongCD; i++) {
            tongGiaThanh += danhSachCD[i].getGiaThanh();
        }
        return tongGiaThanh;
    }

    // Sắp xếp ds giảm dần theo giá thành
    public void sapXepGiamDanTheoGiaThanh() {
        Arrays.sort(danhSachCD, 0, soLuongCD, Comparator.comparingDouble(CD::getGiaThanh).reversed());
    }

    // Sắp xếp ds tăng dần theo tựa CD
    public void sapXepTangDanTheoTuaCD() {
        Arrays.sort(danhSachCD, 0, soLuongCD, Comparator.comparing(CD::getTuaCD));
    }

    // Xuất all ds
    public void xuatDanhSach() {
        for (int i = 0; i < soLuongCD; i++) {
            System.out.println(danhSachCD[i].toString());
        }
    }
}
