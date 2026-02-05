public class CheeseDecorator extends ShawarmaDecorator {
    public CheeseDecorator(Shawarma newShawarma) {
        super(newShawarma);
    }

    @Override
    public double getCost() {
        return tempShawarma.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return tempShawarma.getDescription() + " + Cheese";
    }
}
