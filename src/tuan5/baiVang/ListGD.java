package tuan5.baiVang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static TransactionManagement transactionManagement = new TransactionManagement();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getChoice();
            handleChoice(choice);
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("===== QUẢN LÝ DANH SÁCH GIAO DỊCH =====");
        System.out.println("1. Thêm Giao Dịch Vàng");
        System.out.println("2. Thêm Giao Dịch Tiền Tệ");
        System.out.println("3. Xuất Danh Sách Giao Dịch");
        System.out.println("4. Tính Tổng Số Lượng Cho Từng Loại Giao Dịch");
        System.out.println("5. Tính Trung Bình Thành Tiền Của Giao Dịch Tiền Tệ");
        System.out.println("6. Xuất Các Giao Dịch Có Đơn Giá > 1 Tỷ");
        System.out.println("0. Thoát");
        System.out.println("========================================");
        System.out.print("Chọn chức năng: ");
    }

    private static int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Không làm gì, giá trị mặc định là -1
        }
        return choice;
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addGoldTransaction();
                break;
            case 2:
                addCurrencyTransaction();
                break;
            case 3:
                transactionManagement.displayAllTransactions();
                break;
            case 4:
                transactionManagement.calculateTotalQuantityByType();
                break;
            case 5:
                transactionManagement.calculateAverageTotalAmountCurrency();
                break;
            case 6:
                transactionManagement.displayTransactionsWithUnitPriceOverOneBillion();
                break;
            case 0:
                System.out.println("Kết thúc chương trình. Chào tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
        }
    }

    private static void addGoldTransaction() {
        try {
            System.out.println("=== Thêm Giao Dịch Vàng ===");
            String transactionCode = inputTransactionCode();
            LocalDate transactionDate = inputTransactionDate();
            double unitPrice = inputUnitPrice();
            int quantity = inputQuantity();
            String goldType = inputGoldType();

            GoldTransaction goldTransaction = new GoldTransaction(transactionCode, transactionDate, unitPrice, quantity, goldType);
            transactionManagement.addTransaction(goldTransaction);
            System.out.println("Thêm giao dịch vàng thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void addCurrencyTransaction() {
        try {
            System.out.println("=== Thêm Giao Dịch Tiền Tệ ===");
            String transactionCode = inputTransactionCode();
            LocalDate transactionDate = inputTransactionDate();
            double unitPrice = inputUnitPrice();
            int quantity = inputQuantity();
            double exchangeRate = inputExchangeRate();
            String currencyType = inputCurrencyType();

            CurrencyTransaction currencyTransaction = new CurrencyTransaction(transactionCode, transactionDate, unitPrice, quantity, exchangeRate, currencyType);
            transactionManagement.addTransaction(currencyTransaction);
            System.out.println("Thêm giao dịch tiền tệ thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Các phương thức nhập dữ liệu
    private static String inputTransactionCode() {
        String code;
        while (true) {
            System.out.print("Mã Giao Dịch: ");
            code = scanner.nextLine().trim();
            if (code.isEmpty()) {
                System.out.println("Mã giao dịch không được để trống.");
            } else {
                break;
            }
        }
        return code;
    }

    private static LocalDate inputTransactionDate() {
        LocalDate date = null;
        while (date == null) {
            try {
                System.out.print("Ngày Giao Dịch (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                date = LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập ngày đúng định dạng (dd/MM/yyyy).");
            }
        }
        return date;
    }

    private static double inputUnitPrice() {
        double price = -1;
        while (price <= 0) {
            try {
                System.out.print("Đơn Giá: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Đơn giá phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực.");
            }
        }
        return price;
    }

    private static int inputQuantity() {
        int quantity = -1;
        while (quantity <= 0) {
            try {
                System.out.print("Số Lượng: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("Số lượng phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
        return quantity;
    }

    private static String inputGoldType() {
        String type;
        while (true) {
            System.out.print("Loại Vàng: ");
            type = scanner.nextLine().trim();
            if (type.isEmpty()) {
                System.out.println("Loại vàng không được để trống.");
            } else {
                break;
            }
        }
        return type;
    }

    private static double inputExchangeRate() {
        double rate = -1;
        while (rate <= 0) {
            try {
                System.out.print("Tỉ Giá: ");
                rate = Double.parseDouble(scanner.nextLine());
                if (rate <= 0) {
                    System.out.println("Tỉ giá phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực.");
            }
        }
        return rate;
    }

    private static String inputCurrencyType() {
        String type;
        while (true) {
            System.out.print("Loại Tiền Tệ (Tiền Việt Nam / Tiền USD / Tiền Euro): ");
            type = scanner.nextLine().trim();
            if (type.equalsIgnoreCase("Tiền Việt Nam") ||
                type.equalsIgnoreCase("Tiền USD") ||
                type.equalsIgnoreCase("Tiền Euro")) {
                break;
            } else {
                System.out.println("Loại tiền tệ không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return type;
    }
}

