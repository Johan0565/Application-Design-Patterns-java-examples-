public class Main {
    public static void main(String[] args) {
        // Open a Chicken Store
        ShawarmaStore chickenShop = new ChickenShawarmaStore();
        chickenShop.orderShawarma();

        System.out.println();

        // Open a Beef Store
        ShawarmaStore beefShop = new BeefShawarmaStore();
        beefShop.orderShawarma();
    }
}