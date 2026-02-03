class ComboOrder {
    private Shawarma shawarma;
    private Drink drink;
    private Sauce sauce;

    // Конструктор принимает ЛЮБУЮ фабрику
    public ComboOrder(ComboFactory factory) {
        this.shawarma = factory.createShawarma();
        this.drink = factory.createDrink();
        this.sauce = factory.createSauce();
    }

    public void serve() {
        System.out.println("--- Serving Combo ---");
        shawarma.eat();
        sauce.dip();
        drink.sip();
        System.out.println("---------------------");
    }
}