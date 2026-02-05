public class ChickenShawarma extends Shawarma {
    public ChickenShawarma(CookingDevice device) {
        super(device);
    }

    @Override
    public void prepare() {
        System.out.println("--- Order: Chicken Shawarma ---");
        // Логика высокого уровня
        device.heatUp();
        System.out.println("Preparing tender chicken breast...");
        // Делегирование низкоуровневой работы устройству
        device.cookProcess("Chicken Meat");
        System.out.println("Done at temp: " + device.getTemperature() + "C\n");
    }
}
