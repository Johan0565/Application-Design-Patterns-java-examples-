public class Main {
    public static void main(String[] args) {
        // 1. Создаем сложный прототип (Шаблон)
        // Представь, что добавление ингредиентов - это долгая операция (запросы к БД и т.д.)
        ShawarmaOrder standardPrototype = new ShawarmaOrder("Standard Special", 5.50);
        standardPrototype.addIngredient("Chicken");
        standardPrototype.addIngredient("Garlic Sauce");
        standardPrototype.addIngredient("Tomato");
        standardPrototype.addIngredient("Onion"); // В оригинале есть лук

        System.out.println("Original Template: " + standardPrototype);
        System.out.println("--------------------------------------------------");

        // 2. Клиент 1 хочет "Точно такую же"
        // Мы не создаем new ShawarmaOrder(), мы клонируем. Это очень быстро.
        ShawarmaOrder client1Order = standardPrototype.clone();
        client1Order.setName("Client 1 Order");
        System.out.println(client1Order);

        // 3. Клиент 2 хочет такую же, но БЕЗ ЛУКА
        ShawarmaOrder client2Order = standardPrototype.clone();
        client2Order.setName("Client 2 Order (No Onion)");

        // Мы меняем список ингредиентов в клоне.
        // Благодаря Deep Copy, список в standardPrototype НЕ пострадает.
        client2Order.addIngredient("Extra Cheese"); // Добавил сыр
        // (Логику удаления опустим для краткости, просто добавим отличие)

        System.out.println(client2Order);

        System.out.println("--------------------------------------------------");
        // 4. Проверка: изменился ли оригинал?
        System.out.println("Check Original again: " + standardPrototype);
    }
}