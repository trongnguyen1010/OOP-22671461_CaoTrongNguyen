package tuan2;

class PhuongTien {

    private String chuSoHuu;
    private double triGia;
    private int dungTichXyLanh;

    public PhuongTien(String chuSoHuu, double triGia, int dungTichXyLanh) {
        this.chuSoHuu = chuSoHuu;
        this.triGia = triGia;
        this.dungTichXyLanh = dungTichXyLanh;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public double getTriGia() {
        return triGia;
    }

    public int getDungTichXyLanh() {
        return dungTichXyLanh;
    }

    // Phương thức tính thuế dựa trên dung tích xy-lanh
    public double tinhThue() {
        if (dungTichXyLanh < 100) {
            return triGia * 0.01; // Thuế 1%
        } else if (dungTichXyLanh <= 200) {
            return triGia * 0.03; // Thuế 3%
        } else {
            return triGia * 0.05; // Thuế 5%
        }
    }

    // Phương thức hiển thị thông tin xe và thuế
    public void hienThiThongTin() {
        System.out.printf("Chủ sở hữu: %s, Trị giá: %.2f, Dung tích xy-lanh: %dcc, Thuế: %.2f\n", 
                          chuSoHuu, triGia, dungTichXyLanh, tinhThue());
    }
}
