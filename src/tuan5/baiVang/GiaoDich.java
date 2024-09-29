package tuan5.baiVang;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Transaction {
    private String transactionCode;
    private LocalDate transactionDate;
    private double unitPrice;
    private int quantity;

    public Transaction(String transactionCode, LocalDate transactionDate, double unitPrice, int quantity) {
        if (transactionCode == null || transactionCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã giao dịch không được để trống.");
        }
        if (transactionDate == null) {
            throw new IllegalArgumentException("Ngày giao dịch không được để trống.");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng phải > 0.");
        }
        this.transactionCode = transactionCode.trim();
        this.transactionDate = transactionDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getters và Setters
    public String getTransactionCode() {
        return transactionCode;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        if (transactionDate == null) {
            throw new IllegalArgumentException("Ngày giao dịch không được để trống.");
        }
        this.transactionDate = transactionDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0.");
        }
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng phải > 0.");
        }
        this.quantity = quantity;
    }

    // Phương thức trừu tượng để tính thành tiền
    public abstract double calculateTotalAmount();

    @Override
    public String toString() {
        return "Mã Giao Dịch: " + transactionCode +
               ", Ngày Giao Dịch: " + transactionDate +
               ", Đơn Giá: " + unitPrice +
               ", Số Lượng: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return Objects.equals(transactionCode, that.transactionCode);
    }

    @Override
    public int hashCode() {
        return transactionCode != null ? transactionCode.hashCode() : 0;
    }
}

