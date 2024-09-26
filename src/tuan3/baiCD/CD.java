package tuan3.baiCD;

public class CD {
    private int maCD;              
    private String tuaCD;          
    private String caSy;           
    private int soBaiHat;   
    private double giaThanh;       

    // Constructor không tham số
    public CD() {
    }

    // Constructor có đầy đủ tham số
    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = (soBaiHat > 0) ? soBaiHat : 1; // Mặc định là 1 nếu <= 0
        this.giaThanh = (giaThanh > 0) ? giaThanh : 1.0; // Mặc định là 1.0 nếu <= 0
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        }
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        }
    }

    @Override
    public String toString() {
        return "Mã CD : " + maCD +
               ", Tựa CD : '" + tuaCD + '\'' +
               ", Ca sĩ : '" + caSy + '\'' +
               ", Số bài hát :" + soBaiHat +
               ", Giá thành :" + giaThanh;
    }
}

