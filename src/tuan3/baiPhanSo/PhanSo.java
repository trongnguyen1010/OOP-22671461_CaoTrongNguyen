package tuan3.baiPhanSo;

public class PhanSo {
	private int numerator;   // Tử số
    private int denominator; // Mẫu số

    // Constructor
    public PhanSo(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Tối giản phân số khi khởi tạo
    }

    // Tối giản phân số
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { // Đảm bảo mẫu số luôn dương
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Tính GCD (ước số chung lớn nhất) bằng thuật toán Euclid
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Nghịch đảo phân số
    public PhanSo reciprocal() {
        return new PhanSo(denominator, numerator);
    }

    // Cộng hai phân số
    public PhanSo add(PhanSo other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new PhanSo(newNumerator, newDenominator);
    }

    // Trừ hai phân số
    public PhanSo subtract(PhanSo other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new PhanSo(newNumerator, newDenominator);
    }

    // Nhân hai phân số
    public PhanSo multiply(PhanSo other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new PhanSo(newNumerator, newDenominator);
    }

    // Chia hai phân số
    public PhanSo divide(PhanSo other) {
        return this.multiply(other.reciprocal());
    }

    // So sánh hai phân số với tolerance
    public boolean equals(PhanSo other, double tolerance) {
        double difference = Math.abs(this.toDouble() - other.toDouble());
        return difference < tolerance;
    }

    // Chuyển đổi phân số thành số thực
    public double toDouble() {
        return (double) numerator / denominator;
    }

    // Phương thức toString để hiển thị phân số
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
