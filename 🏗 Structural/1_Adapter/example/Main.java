public class Main {
    public static void main(String[] args) {
        // Сценарий 1: Старый добрый клиент с картой
        System.out.println("--- Клиент 1 (Карта) ---");
        PaymentProcessor cardSystem = new CardPayment();
        ShawarmaShop shop1 = new ShawarmaShop(cardSystem);
        shop1.buyShawarma(250); // Платит 250 рублей

        // Сценарий 2: МАЖОР с биткоинами
        System.out.println("\n--- Клиент 2 (Bitcoin) ---");

        // У нас есть странная библиотека
        CryptoLibrary newCryptoSystem = new CryptoLibrary();

        // Мы оборачиваем её в адаптер
        PaymentProcessor cryptoAdapter = new CryptoAdapter(newCryptoSystem);

        // Магазин принимает адаптер как родной, думая, что это обычная касса
        ShawarmaShop shop2 = new ShawarmaShop(cryptoAdapter);

        // Клиент платит в рублях (как написано в меню), а списывается крипта
        shop2.buyShawarma(250);
    }
}