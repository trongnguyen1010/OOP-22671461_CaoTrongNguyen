package tuan1;

import java.util.Scanner;

public class KTraHCN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HCN hcn = new HCN();
		
		System.out.println("Nhập chiều dài hcn : ");
		double chieuDai = sc.nextDouble();
		hcn.setChieuDai(chieuDai);
		
		System.out.println("Nhập chiều rộng hcn : ");
		double chieuRong = sc.nextDouble();
		hcn.setChieuRong(chieuRong);
		
		System.out.println(hcn.toString());
		
		sc.close();
	}
}
