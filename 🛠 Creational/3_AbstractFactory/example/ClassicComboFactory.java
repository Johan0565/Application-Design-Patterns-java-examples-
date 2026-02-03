class ClassicComboFactory implements ComboFactory {
    public Shawarma createShawarma() {
        return new ChickenShawarma();
    }
    public Drink createDrink() {
        return new Ayran();
    }
    public Sauce createSauce() {
        return new GarlicSauce();
    }
}