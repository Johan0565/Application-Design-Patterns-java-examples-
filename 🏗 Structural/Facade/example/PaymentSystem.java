public class PaymentSystem {
    public boolean makePayment(String cardNo, double amount) {
        System.out.println("4. [Payment] Связь с банком... Списание $" + amount + " с карты " + cardNo);
        return true;
    }
}
