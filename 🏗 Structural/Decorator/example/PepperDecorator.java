public class PepperDecorator extends ShawarmaDecorator {
    public PepperDecorator(Shawarma newShawarma) {
        super(newShawarma);
    }

    @Override
    public double getCost() {
        return tempShawarma.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return tempShawarma.getDescription() + " + Hot Pepper";
    }
}
