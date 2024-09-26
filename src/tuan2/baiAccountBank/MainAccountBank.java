package tuan2.baiAccountBank;

import java.util.Scanner;


public class MainAccountBank {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(AccountBank tk) {
        System.out.println("Nhập sô�? tài khoản: ");
        tk.setSoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập tên tài khoản: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTienTrongTK(50000);
    }
    public static void main(String[] args) {
        AccountBank a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Ch�?n chức năng: ");
            System.out.println("1.Nhập thông tin của ca�?c kha�?ch hàng\n" + 
            "2.Xuâ�?t danh sa�?ch thông tin của ca�?c kha�?ch hàng\n" + 
            "3.Nạp tiền\n" + 
            "4.Ru�?t tiền\n" + 
            "5.�?a�?o hạn\n" + 
            "6.Chuyển khoản\n" + 
            "Sô�? kha�?c để thoa�?t");
            b = sc.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Nhập sô�? lượng kha�?ch hàng bạn muô�?n nhập: ");
                    n = sc.nextInt();
                    a = new AccountBank[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Kha�?ch hàng sô�?: " + (i+1));
                        a[i] = new AccountBank();
                        nhapTK(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "Sô�? TK", "Tên TK", "Sô�? tiền trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    break;
                case 3:
                    System.out.println("Nhập sô�? tài khoản kha�?ch hàng cần nạp tiền: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập sô�? tài khoản kha�?ch hàng cần rút tiền: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].rutTien();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhập sô�? tài khoản kha�?ch hàng cần đáo hạn: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhập sô�? tài khoản kha�?ch hàng chuyển tiền: ");
                    s = sc.nextLong();
                    System.out.print("Nhập sô�? tài khoản kha�?ch hàng nhận tiền: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            chuyen = a[i].getSoTienTrongTK();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTK();
                                if (c == f) {
                                    nhan = a[j].getSoTienTrongTK();
                                    System.out.println("Nhập sô�? tiền cần chuyển");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTienTrongTK(chuyen);
                                        a[j].setSoTienTrongTK(nhan);
                                        System.out.println("Tài khoản sô�? " + d + " vừa chuyển: " + tienChuyen);
                                        System.out.println("Tài khoản sô�? " + f + " vừa nhận: " + tienChuyen);
                                    } else {
                                        System.out.println("Sô�? tiền nhập không hợp lệ!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    System.out.println("Bye!!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
