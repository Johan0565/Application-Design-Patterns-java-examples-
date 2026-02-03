public class ShawarmaShop {
    private PaymentProcessor paymentProcessor;

    public  ShawarmaShop(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void buyShawarma(double price) {
        paymentProcessor.pay(price);
    }
}
