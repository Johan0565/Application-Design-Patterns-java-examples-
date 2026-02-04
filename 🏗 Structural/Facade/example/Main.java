public class Main {
    public static void main(String[] args) {
        ShawarmaBotFacade bot = new ShawarmaBotFacade();

        bot.orderShawarmaCombo(
                "Meat GIGANT Shawarma",
                "Lenina st, 42",
                "4400-1234-5678-9000",
                7.50
        );
    }
}