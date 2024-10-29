package tuan9.baiPhongHoc;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DanhSachPhong implements MethodOfDS{
	private ArrayList<PhongHoc> DSPhong;
	
	public DanhSachPhong() {
		DSPhong = new ArrayList<PhongHoc>();
	}
	//Them
	public void them(PhongHoc phong) throws Exception {
		if(DSPhong.contains(phong)==false) {
			DSPhong.add(phong);
		}else {
			throw new Exception("Ma phong da trung!");
		}
	}
	//Tim kiem phong hoc
	public PhongHoc timKiemPhongHoc(String maPhong) {
		for(PhongHoc phong : DSPhong) {
			if(phong.getMaPhong().equalsIgnoreCase(maPhong))
				return phong;
		}
		return null;
	}
	@Override
	public int timKiemViTri(String maPhong) {
		// TODO Auto-generated method stub
		PhongHoc find = timKiemPhongHoc(maPhong);
		if(find != null)
			return DSPhong.indexOf(find);
		return -1;
	}
	@Override
	public void xoa(PhongHoc phong) {
		// TODO Auto-generated method stub
		DSPhong.remove(phong);
	}
	@Override
	public void sua(PhongHoc phong) {
		// TODO Auto-generated method stub
		int vt = DSPhong.indexOf(phong);
		if(vt>-1)
			DSPhong.set(vt, phong);
	}
	@Override
	public ArrayList<PhongHoc> getDSPhongDatChuan() {
		// TODO Auto-generated method stub
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for(PhongHoc phong : DSPhong) {
			if(phong.datChuan())
				temp.add(phong);
		}
		return temp;
	}
	@Override
	public void sortTheoDayNha() {
		// TODO Auto-generated method stub
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				String s1 = o1.getDayNha();
				String s2 = o2.getDayNha();
				return s1.compareTo(s2);
			}
			
		});
	}
	@Override
	public void sortTheoDienTich() {
		// TODO Auto-generated method stub
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				Double d1 = o1.getDienTich();
				Double d2 = o2.getDienTich();
				return d1.compareTo(d2);
			}
			
		});
	}
	@Override
	public void sortTheoBongDen() {
		// TODO Auto-generated method stub
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				Integer n1 = o1.getSoBongDen();
				Integer n2 = o2.getSoBongDen();
				return n1.compareTo(n2);
			}
		});
	}
	@Override
	public ArrayList<PhongHoc> DSPhongHocCoSoMayCo60() {
		// TODO Auto-generated method stub
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for(PhongHoc phong : DSPhong) {
			if(phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoLuongMayTinh()==60)
				temp.add(phong);
		}
		return temp;
	}
	@Override
	public void setDSPhongHoc(ArrayList<PhongHoc> dsPhong) {
		// TODO Auto-generated method stub
		DSPhong = dsPhong;
		
	}
	@Override
	public int getSoLuongPhong() {
		// TODO Auto-generated method stub
		return DSPhong.size();
	}
	@Override
	public void sortTheo3ThuocTinh() {
		// TODO Auto-generated method stub
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				int com1 = ((Integer)o1.getSoBongDen()).compareTo(o2.getSoBongDen());
				if(com1 == 0) {
					Double s1 = o1.getDienTich();
					Double s2 = o2.getDienTich();
					int com2 = s1.compareTo(s2);
					if(com2 == 0)
						return o1.getMaPhong().compareToIgnoreCase(o2.getMaPhong());
					else
						return com2;
				}else 
					return com1;		
			}
			
		});
	}
	@Override
	public int demSoDayNha() {
		// TODO Auto-generated method stub
		HashMap<String, PhongHoc> ht = new HashMap<String, PhongHoc>();
		for(PhongHoc phong : DSPhong) {
			ht.put(phong.getDayNha(), phong);
		}
		return ht.size();
	}
	@Override
	public ArrayList<PhongHoc> getDSPhong() {
		// TODO Auto-generated method stub
		return DSPhong;
	}
}
