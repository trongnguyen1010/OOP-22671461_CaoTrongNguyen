package tuan3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainHTP {
	public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            // Tạo đối tượng hàng thực phẩm với các giá trị hợp lệ
            Date ngaySanXuat1 = sdf.parse("01/01/2023");
            Date ngayHetHan1 = sdf.parse("01/01/2024");
            HangThucPham htp1 = new HangThucPham("H001", "Sữa tươi", 20000, ngaySanXuat1, ngayHetHan1);
            System.out.println(htp1);

            // Tạo đối tượng hàng thực phẩm với ngày hết hạn không hợp lệ
            Date ngaySanXuat2 = sdf.parse("10/08/2023");
            Date ngayHetHan2 = sdf.parse("05/08/2023");
            HangThucPham htp2 = new HangThucPham("H002", "Bánh mì", 15000, ngaySanXuat2, ngayHetHan2);
            System.out.println(htp2);

            // Tạo đối tượng hàng thực phẩm chỉ với mã hàng
            Date ngaySanXuat3 = sdf.parse("10/08/2023");
            Date ngayHetHan3 = sdf.parse("05/10/2024");
            HangThucPham htp3 = new HangThucPham("H003", "Bánh quy", 15000, ngaySanXuat3, ngayHetHan3);
            System.out.println(htp3);

        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày: " + e.getMessage());
        }
    }
}
