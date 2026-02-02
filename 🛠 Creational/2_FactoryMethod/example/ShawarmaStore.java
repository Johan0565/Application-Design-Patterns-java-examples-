abstract class ShawarmaStore {
   public Shawarma orderShawarma() {
        Shawarma shawarma = createShawarma();

        shawarma.prepare();
        shawarma.cook();
        shawarma.wrap();

        System.out.println("Order ready: " + shawarma.getName() + "\n");
        return shawarma;
    }
    protected abstract Shawarma createShawarma();
}
