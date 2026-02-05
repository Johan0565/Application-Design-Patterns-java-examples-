class RegularPriceStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double rawPrice) {
        return rawPrice;
    }
}
