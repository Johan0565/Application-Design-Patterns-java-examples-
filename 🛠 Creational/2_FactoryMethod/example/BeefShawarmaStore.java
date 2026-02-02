public class BeefShawarmaStore extends ShawarmaStore {
    @Override
    protected Shawarma createShawarma() {
        return new BeefShawarma();
    }
}
