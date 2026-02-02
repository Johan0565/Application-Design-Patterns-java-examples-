public class ChickenShawarmaStore extends ShawarmaStore {
    @Override
    protected Shawarma createShawarma() {
        return new ChickenShawarma();
    }
}
