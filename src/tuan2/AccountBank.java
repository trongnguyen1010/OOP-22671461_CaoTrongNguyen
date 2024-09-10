package tuan2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AccountBank {
    // Các thuộc tính
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
    
    // Hằng số lãi suất
    public static final double LAI_SUAT = 0.035;
    private static final double PHI_RUT_TIEN = 5000; // Phí rút tiền là 5000 VND
    
    Scanner sc = new Scanner(System.in);

    // Constructor mặc định
    public AccountBank() {
        this.soTienTrongTK = 50000; // Số tiền mặc định
    }

    // Constructor đầy đủ tham số
    public AccountBank(long soTK, String tenTK, double soTienTrongTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
    }
    
    // Constructor có 2 đối số: số tài khoản, tên tài khoản, số tiền mặc định là 50000
    public AccountBank(long soTK, String tenTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = 50000; // Số tiền mặc định
    }
    public long getSoTK() {
        return this.soTK;
    }

    public void setSoTK(long soTK) {
        this.soTK = soTK;
    }

    public String getTenTK() {
        return this.tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public double getSoTienTrongTK() {
        return this.soTienTrongTK;
    }

    public void setSoTienTrongTK(double soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }

    @Override
    public String toString() {
        // Định dạng tiền tệ theo Locale Việt Nam
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String str1 = currencyVN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1;
    }

    // Phương thức nạp tiền vào tài khoản
    public double napTien() {
        double nap;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        nap = sc.nextDouble();
        if (nap >= 0) {
            soTienTrongTK += nap;
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String str1 = currencyVN.format(nap);
            System.out.println("Bạn vừa nạp " + str1 + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
        return nap;
    }

    // Phương thức rút tiền
    public double rutTien() {
        double rut;
        System.out.print("Nhập số tiền bạn cần rút: ");
        rut = sc.nextDouble();
        if (rut > 0 && rut <= (soTienTrongTK - PHI_RUT_TIEN)) {
            soTienTrongTK -= (rut + PHI_RUT_TIEN);
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String str1 = currencyVN.format(rut);
            System.out.println("Bạn vừa rút " + str1 + " từ tài khoản. Phí là 5.000 VND.");
        } else {
            System.out.println("Số tiền muốn rút không hợp lệ!");
            return rutTien();
        }
        return rut;
    }

    // Phương thức đáo hạn
    public double daoHan() {
        soTienTrongTK += soTienTrongTK * LAI_SUAT;
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String str1 = currencyVN.format(soTienTrongTK);
        System.out.println("Bạn vừa được " + str1 + " từ đáo hạn 1 tháng");
        return soTienTrongTK;
    }

    // Phương thức chuyển khoản
    public void chuyenTien(AccountBank taiKhoanNhan) {
        System.out.print("Nhập số tiền bạn cần chuyển: ");
        double soTienChuyen = sc.nextDouble();
        if (soTienChuyen > 0 && soTienChuyen <= this.soTienTrongTK) {
            this.soTienTrongTK -= soTienChuyen;
            taiKhoanNhan.soTienTrongTK += soTienChuyen;
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String strChuyen = currencyVN.format(soTienChuyen);
            System.out.println("Bạn vừa chuyển " + strChuyen + " đến tài khoản số: " + taiKhoanNhan.getSoTK());
        } else {
            System.out.println("Số tiền chuyển không hợp lệ!");
        }
    }

    // Phương thức in thông tin tài khoản ra màn hình
    public void inTK() {
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String str1 = currencyVN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s\n", soTK, tenTK, str1);
    }
}
