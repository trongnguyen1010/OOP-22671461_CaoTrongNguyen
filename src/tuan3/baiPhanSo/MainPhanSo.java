package tuan3.baiPhanSo;

public class MainPhanSo {
	public static void main(String[] args) {
        PhanSo r1 = new PhanSo(3, 4); // Phân số 3/4
        PhanSo r2 = new PhanSo(2, 5); // Phân số 2/5

        System.out.println("Phân số thứ nhất: " + r1);
        System.out.println("Phân số thứ hai: " + r2);

        // Cộng hai phân số
        PhanSo sum = r1.add(r2);
        System.out.println("Tổng: " + sum);

        // Trừ hai phân số
        PhanSo difference = r1.subtract(r2);
        System.out.println("Hiệu: " + difference);

        // Nhân hai phân số
        PhanSo product = r1.multiply(r2);
        System.out.println("Tích: " + product);

        // Chia hai phân số
        PhanSo quotient = r1.divide(r2);
        System.out.println("Thương: " + quotient);

        // Nghịch đảo của phân số thứ nhất
        PhanSo reciprocal = r1.reciprocal();
        System.out.println("Nghịch đảo của phân số thứ nhất: " + reciprocal);

        // So sánh hai phân số với tolerance 0.0001
        boolean isEqual = r1.equals(r2, 0.0001);
        System.out.println("Hai phân số có bằng nhau không? " + (isEqual ? "Có" : "Không"));
    }
}
