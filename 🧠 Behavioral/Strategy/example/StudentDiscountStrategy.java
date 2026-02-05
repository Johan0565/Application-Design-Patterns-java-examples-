class StudentDiscountStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double rawPrice) {
        System.out.println("   [Применена скидка студента 15%]");
        return rawPrice * 0.85;
    }
}
