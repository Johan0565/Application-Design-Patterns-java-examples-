class CalorieCounterVisitor implements Visitor {
    private int totalCalories = 0;

    @Override
    public void visit(Shawarma shawarma) {
        System.out.println("   [Calories] Шаурма '" + shawarma.getName() + "': " + shawarma.getCalories() + " ккал.");
        totalCalories += shawarma.getCalories();
    }

    @Override
    public void visit(Drink drink) {
        int cal = drink.getTotalCalories();
        System.out.println("   [Calories] Напиток '" + drink.getName() + "': " + cal + " ккал.");
        totalCalories += cal;
    }

    public void printTotal() {
        System.out.println("ИТОГО калорий: " + totalCalories + "\n");
    }
}
