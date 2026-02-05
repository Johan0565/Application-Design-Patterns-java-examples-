import java.util.ArrayList;
import java.util.List;

public class OrderBoard {
    private List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    private void notifySubscribers(String orderId, String status) {
        for (Observer observer : subscribers) {
            observer.update(orderId, status);
        }
    }

    public void changeOrderStatus(String orderId, String newStatus) {
        System.out.println("\n--- [TAБЛО] Статус заказа " + orderId + " изменился на: " + newStatus + " ---");
        // Как только статус поменялся, сразу уведомляем всех
        notifySubscribers(orderId, newStatus);
    }
}
