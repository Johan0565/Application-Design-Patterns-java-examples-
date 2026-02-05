public class MobileAppNotificatoin implements Observer{
    @Override
    public void update(String orderId, String status) {
        System.out.println("   [App Push]: Дзынь! Ваш статус заказа #" + orderId + " теперь: " + status);
    }
}
