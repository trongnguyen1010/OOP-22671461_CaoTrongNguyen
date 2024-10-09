package tuan5.baiVang;

import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
    private String goldType;

    public GiaoDichVang(String transactionCode, LocalDate transactionDate, double unitPrice, int quantity, String goldType) {
        super(transactionCode, transactionDate, unitPrice, quantity);
        if (goldType == null || goldType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại vàng không được để trống.");
        }
        this.goldType = goldType.trim();
    }

    // Getter và Setter
    public String getGoldType() {
        return goldType;
    }

    public void setGoldType(String goldType) {
        if (goldType == null || goldType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại vàng không được để trống.");
        }
        this.goldType = goldType.trim();
    }

    @Override
    public double calculateTotalAmount() {
        return getQuantity() * getUnitPrice();
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Loại Vàng: " + goldType +
               ", Thành Tiền: " + calculateTotalAmount();
    }
}

