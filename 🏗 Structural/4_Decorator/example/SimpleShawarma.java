public class SimpleShawarma implements Shawarma {
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Base Shawarma";
    }
}
