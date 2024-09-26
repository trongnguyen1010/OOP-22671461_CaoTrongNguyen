package tuan4.ChuyenXe;

public class ListChuyenXe {
	private ChuyenXe[] CX = new ChuyenXe[100];
	private int countCX;
	private double sum1 = 0, sum2 = 0;

	public ListChuyenXe() {
		countCX = 0;
		for (int i = 0; i < 100; i++) {
			CX[i] = new ChuyenXe();
		}
	}

	/*
	 * Nếu loaiXe=1 thì thêm vào xe nội thành Nếu loaiXe=2 thì thêm vào xe ngoại
	 * thành
	 */
	public void them(int loaiXe) {
		if (countCX > 100)
			System.out.println("Khong the them du lieu!");
		else {
			if (loaiXe == 1) {
				CX[countCX] = new NoiThanh();
				NoiThanh noit = new NoiThanh();
				noit.nhap();
				CX[countCX] = noit;
				sum1 += noit.getDoanhThu();
			} else {
				CX[countCX] = new NgoaiThanh();
				NgoaiThanh ngoait = new NgoaiThanh();
				ngoait.nhap();
				CX[countCX] = ngoait;
				sum2 += ngoait.getDoanhThu();
			}
			countCX++;
		}
	}

	public void xuatTT() {
		for (int i = 0; i < countCX; i++) {
			System.out.println("-----------------------------------------------------");
			System.out.println(CX[i].toString());
		}

		System.out.println("----------------Doanh Thu-----------------");
		System.out.println("| Chuyen Xe Noi Thanh: " + sum1 + "|");
		System.out.println("| Chuyen Xe Ngoai Thanh: " + sum2 + "|");
		System.out.println("------------------------------------------");
	}
}