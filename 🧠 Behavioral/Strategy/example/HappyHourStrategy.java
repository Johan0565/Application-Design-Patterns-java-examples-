class HappyHourStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double rawPrice) {
        System.out.println("   [Счастливые часы: -100 руб]");
        return Math.max(0, rawPrice - 100);
    }
}
