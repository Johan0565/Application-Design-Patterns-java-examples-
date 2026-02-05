class CardPayment implements PaymentProcessor {
    @Override
    public void pay(double rubles) {
        System.out.println("Оплата картой прошла успешно: " + rubles + " руб.");
    }
}