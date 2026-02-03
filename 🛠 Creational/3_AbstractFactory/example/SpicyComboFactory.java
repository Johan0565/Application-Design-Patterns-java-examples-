public class SpicyComboFactory implements ComboFactory {
    public Shawarma createShawarma() {
        return new BeefShawarma();
    }
    public Drink createDrink() {
        return new Cola();
    }
    public Sauce createSauce() {
        return new ChiliSauce();
    }
}
