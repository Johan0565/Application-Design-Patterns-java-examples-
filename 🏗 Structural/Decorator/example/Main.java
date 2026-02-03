public class Main {
    public static void main(String[] args) {
        Shawarma myLunch = new SimpleShawarma();
        System.out.println("Cost: $" + myLunch.getCost() + " | " + myLunch.getDescription());

        myLunch = new CheeseDecorator(myLunch);
        System.out.println("Cost: $" + myLunch.getCost() + " | " + myLunch.getDescription());

        myLunch = new PepperDecorator(myLunch);
        System.out.println("Cost: $" + myLunch.getCost() + " | " + myLunch.getDescription());

        myLunch = new CheeseDecorator(myLunch);
        System.out.println("Cost: $" + myLunch.getCost() + " | " + myLunch.getDescription());
    }
}
