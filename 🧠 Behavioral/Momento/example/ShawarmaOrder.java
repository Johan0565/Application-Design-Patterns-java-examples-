class ShawarmaOrder {
    private String ingredients; // Текущее состояние

    public ShawarmaOrder() {
        this.ingredients = "Лаваш"; // Начальное состояние
    }

    public void addIngredient(String item) {
        this.ingredients += " + " + item;
        System.out.println("Добавлено: " + item + " | Текущая шаурма: " + ingredients);
    }

    public ShawarmaMemento save() {
        System.out.println("   [System] Сохранение состояния...");

        return new ShawarmaMemento(this.ingredients);
    }

    public void restore(ShawarmaMemento memento) {
        this.ingredients = memento.getSavedIngredients();
        System.out.println("   [System] Откат изменений! Вернулись к: " + ingredients);
    }


}