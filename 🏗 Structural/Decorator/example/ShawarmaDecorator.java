public abstract class ShawarmaDecorator implements Shawarma {
    protected Shawarma tempShawarma;

    public ShawarmaDecorator(Shawarma newShawarma) {
        this.tempShawarma = newShawarma;
    }

    @Override
    public double getCost() {
        return tempShawarma.getCost();
    }

    @Override
    public String getDescription() {
        return tempShawarma.getDescription();
    }
}
