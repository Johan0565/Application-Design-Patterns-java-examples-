class BeefShawarma extends Shawarma {
    public BeefShawarma(CookingDevice device) {
        super(device);
    }

    @Override
    public void prepare() {
        System.out.println("--- Order: Beef Shawarma ---");
        device.heatUp();
        System.out.println("Marinating spices into beef...");
        device.cookProcess("Beef Steak");
        System.out.println("Done at temp: " + device.getTemperature() + "C\n");
    }
}