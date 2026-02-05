public class ElectricOven implements CookingDevice {
    @Override
    public void heatUp() {
        System.out.println("  [Oven] Warming up electric coils...");
    }

    @Override
    public void cookProcess(String foodName) {
        System.out.println("  [Oven] Baking " + foodName + " evenly on all sides.");
    }

    @Override
    public double getTemperature() {
        return 200;
    }
}
