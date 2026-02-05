public class Main {
    public static void main(String[] args) {
        // 1. Создаем Повара (он один на всех)
        chef ahmed = new chef();

        // 2. Создаем конкретные команды (Листочки с заказами)
        Order order1 = new MakeShawarmaOrder(ahmed);
        Order order2 = new MakeBurgerOrder(ahmed);
        Order order3 = new MakeShawarmaOrder(ahmed);

        // 3. Нанимаем официанта
        Waiter waiter = new Waiter();

        // 4. Клиенты делают заказы
        waiter.takeOrder(order1);
        waiter.takeOrder(order2);
        waiter.takeOrder(order3);

        // 5. Официант несет заказы на кухню
        waiter.sendOrdersToKitchen();

        // 6. Сценарий отмены
        System.out.println("-------------------------");
        Order mistakeOrder = new MakeBurgerOrder(ahmed);
        mistakeOrder.execute(); // Случайно начали готовить
        waiter.cancelLastOrder(mistakeOrder); // Отмена!
    }
}