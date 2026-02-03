public class FireGrill implements CookingDevice {
    @Override
    public void heatUp() {
        System.out.println("[Grill] Igniting charcoal fire!");
    }

    @Override
    public void cookProcess(String foodName) {
        System.out.println("  [Grill] Searing " + foodName + " with smokey flavor.");
    }

    @Override
    public double getTemperature() {
        return 350.0;
    }
}
