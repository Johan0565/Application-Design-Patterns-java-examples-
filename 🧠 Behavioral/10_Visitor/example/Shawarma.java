class Shawarma implements ItemElement {
    private String name;
    private int calories;

    public Shawarma(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
