class Drink implements ItemElement {
    private String name;
    private int volumeMl; // Объем в мл
    private int caloriesPer100ml;

    public Drink(String name, int volumeMl, int caloriesPer100ml) {
        this.name = name;
        this.volumeMl = volumeMl;
        this.caloriesPer100ml = caloriesPer100ml;
    }

    public int getTotalCalories() {
        return (volumeMl / 100) * caloriesPer100ml;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
