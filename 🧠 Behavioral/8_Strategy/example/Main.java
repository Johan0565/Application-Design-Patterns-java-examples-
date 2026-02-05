public class Main {
    public static void main(String[] args) {
        double orderAmount = 1000.0;

        System.out.println("--- Клиент 1 (Обычный) ---");
        Bill bill = new Bill(new RegularPriceStrategy());
        bill.printBill(orderAmount);

        System.out.println("\n--- Клиент 2 (Студент) ---");

        bill.setStrategy(new StudentDiscountStrategy());
        bill.printBill(orderAmount);

        System.out.println("\n--- Клиент 3 (VIP) ---");
        bill.setStrategy(new VipDiscountStrategy());
        bill.printBill(orderAmount);

        System.out.println("\n--- Время 18:00 (Happy Hour) ---");
        bill.setStrategy(new HappyHourStrategy());
        bill.printBill(orderAmount);
    }
}