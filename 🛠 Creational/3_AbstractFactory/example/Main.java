public class Main {
    public static void main(String[] args) {
        // Клиент хочет классический набор
        // Мы просто подставляем нужную фабрику
        ComboFactory classicFactory = new ClassicComboFactory();
        ComboOrder order1 = new ComboOrder(classicFactory);
        order1.serve();

        System.out.println();

        // Клиент хочет острый набор
        ComboFactory spicyFactory = new SpicyComboFactory();
        ComboOrder order2 = new ComboOrder(spicyFactory);
        order2.serve();
    }
}