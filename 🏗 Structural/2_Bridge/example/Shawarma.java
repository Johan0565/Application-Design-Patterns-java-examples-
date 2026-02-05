abstract class Shawarma {
    protected CookingDevice device;

    protected Shawarma(CookingDevice device) {
        this.device = device;
    }

    // Абстрактный метод, который уточняется в подклассах
    public abstract void prepare();
}
