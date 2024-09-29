package tuan5.baiVang;
public class CurrencyTransaction extends Transaction {
    private double exchangeRate;
    private String currencyType; // Tiền Việt Nam, Tiền USD, Tiền Euro

    public CurrencyTransaction(String transactionCode, LocalDate transactionDate, double unitPrice, int quantity,
                               double exchangeRate, String currencyType) {
        super(transactionCode, transactionDate, unitPrice, quantity);
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Tỉ giá phải > 0.");
        }
        if (currencyType == null || currencyType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại tiền tệ không được để trống.");
        }
        currencyType = currencyType.trim();
        if (!currencyType.equalsIgnoreCase("Tiền Việt Nam") &&
            !currencyType.equalsIgnoreCase("Tiền USD") &&
            !currencyType.equalsIgnoreCase("Tiền Euro")) {
            throw new IllegalArgumentException("Loại tiền tệ phải là: Tiền Việt Nam, Tiền USD, hoặc Tiền Euro.");
        }
        this.exchangeRate = exchangeRate;
        this.currencyType = currencyType;
    }

    // Getters và Setters
    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Tỉ giá phải > 0.");
        }
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        if (currencyType == null || currencyType.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại tiền tệ không được để trống.");
        }
        currencyType = currencyType.trim();
        if (!currencyType.equalsIgnoreCase("Tiền Việt Nam") &&
            !currencyType.equalsIgnoreCase("Tiền USD") &&
            !currencyType.equalsIgnoreCase("Tiền Euro")) {
            throw new IllegalArgumentException("Loại tiền tệ phải là: Tiền Việt Nam, Tiền USD, hoặc Tiền Euro.");
        }
        this.currencyType = currencyType;
    }

    @Override
    public double calculateTotalAmount() {
        if (currencyType.equalsIgnoreCase("Tiền USD") || currencyType.equalsIgnoreCase("Tiền Euro")) {
            return getQuantity() * getUnitPrice() * exchangeRate;
        } else { // Tiền Việt Nam
            return getQuantity() * getUnitPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Tỉ Giá: " + exchangeRate +
               ", Loại Tiền Tệ: " + currencyType +
               ", Thành Tiền: " + calculateTotalAmount();
    }
}

