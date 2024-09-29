package tuan5.baiVang;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
    private List<Transaction> transactionList;

    public TransactionManagement() {
        transactionList = new ArrayList<>();
    }

    // Thêm giao dịch vào danh sách
    public void addTransaction(Transaction transaction) {
        // Kiểm tra trùng mã giao dịch
        for (Transaction t : transactionList) {
            if (t.getTransactionCode().equalsIgnoreCase(transaction.getTransactionCode())) {
                throw new IllegalArgumentException("Mã giao dịch đã tồn tại.");
            }
        }
        transactionList.add(transaction);
    }

    // In toàn bộ danh sách giao dịch
    public void displayAllTransactions() {
        if (transactionList.isEmpty()) {
            System.out.println("Danh sách giao dịch trống.");
            return;
        }
        for (Transaction t : transactionList) {
            System.out.println(t);
            System.out.println("---------------------------");
        }
    }

    // Tính tổng số lượng cho từng loại giao dịch
    public void calculateTotalQuantityByType() {
        int totalGoldQuantity = 0;
        int totalCurrencyQuantity = 0;

        for (Transaction t : transactionList) {
            if (t instanceof GoldTransaction) {
                totalGoldQuantity += t.getQuantity();
            } else if (t instanceof CurrencyTransaction) {
                totalCurrencyQuantity += t.getQuantity();
            }
        }

        System.out.println("Tổng số lượng giao dịch vàng: " + totalGoldQuantity);
        System.out.println("Tổng số lượng giao dịch tiền tệ: " + totalCurrencyQuantity);
    }

    // Tính trung bình thành tiền của giao dịch tiền tệ
    public void calculateAverageTotalAmountCurrency() {
        double totalAmount = 0;
        int count = 0;

        for (Transaction t : transactionList) {
            if (t instanceof CurrencyTransaction) {
                totalAmount += t.calculateTotalAmount();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có giao dịch tiền tệ nào để tính trung bình.");
            return;
        }

        double average = totalAmount / count;
        System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + average);
    }

    // Xuất các giao dịch có đơn giá > 1 tỷ
    public void displayTransactionsWithUnitPriceOverOneBillion() {
        boolean found = false;
        for (Transaction t : transactionList) {
            if (t.getUnitPrice() > 1_000_000_000) {
                System.out.println(t);
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có giao dịch nào có đơn giá > 1 tỷ.");
        }
    }
}

