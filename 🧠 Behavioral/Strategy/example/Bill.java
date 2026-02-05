class Bill {
    private PricingStrategy strategy;

    public Bill(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void printBill(double rawPrice) {
        double finalPrice = strategy.calculatePrice(rawPrice);
        System.out.println("Итого к оплате: " + finalPrice + " руб. (Базовая: " + rawPrice + ")");
    }
}
