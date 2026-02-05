import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        System.out.println("[Waiter] Заказ принят и записан в блокнот.");
        orderList.add(order);
    }

    public void sendOrdersToKitchen() {
        System.out.println("\n[Waiter] Передаю все заказы на кухню:");
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

    public void cancelLastOrder(Order order) {
        System.out.println("\n[Waiter] Клиент передумал! Отменяем.");
        order.undo();
    }
}
