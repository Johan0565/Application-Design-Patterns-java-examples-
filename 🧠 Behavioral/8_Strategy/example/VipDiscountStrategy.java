class VipDiscountStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double rawPrice) {
        System.out.println("   [Применена VIP скидка 50%]");
        return rawPrice * 0.50;
    }
}
