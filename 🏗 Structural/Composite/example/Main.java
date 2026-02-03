public class Main {
    public static void main(String[] args) {
        // 1. Создаем отдельные продукты (Листья)
        Product classicShawarma = new Product("Classic Shawarma", 5.0);
        Product spicyShawarma = new Product("Spicy Shawarma", 6.0);
        Product cola = new Product("Cola 0.5", 1.5);
        Product fries = new Product("French Fries", 2.5);
        Product sauce = new Product("Garlic Sauce", 0.5);

        // 2. Формируем "Детский набор" (Маленькая коробка)
        OrderBox kidsBox = new OrderBox("Kids Combo Box");
        kidsBox.add(classicShawarma);
        kidsBox.add(cola);

        // 3. Формируем "Большой заказ" (Большая коробка)
        OrderBox deliveryBag = new OrderBox("BIG Delivery Bag");
        deliveryBag.add(spicyShawarma);
        deliveryBag.add(fries);
        deliveryBag.add(kidsBox);
        deliveryBag.add(sauce);

        System.out.println("--- Чек заказа ---");
        deliveryBag.printOrder("");

        System.out.println("\n------------------");

        System.out.println("TOTAL PRICE: $" + deliveryBag.getPrice());
    }
}