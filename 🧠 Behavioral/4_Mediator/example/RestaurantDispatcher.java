public class RestaurantDispatcher implements Mediator{
    private Cashier cashier;
    private Chef chef;
    private Waiter waiter;

    public void setCashier(Cashier cashier) { this.cashier = cashier; }
    public void setChef(Chef chef) { this.chef = chef; }
    public void setWaiter(Waiter waiter) { this.waiter = waiter; }

    @Override
    public void notify(Component sender, String event) {
        if (event.equals("ORDER_PLACED")) {
            System.out.println("[Dispatcher]: Вижу новый заказ. Передаю Повару.");
            chef.cook();
        }
        else if (event.equals("FOOD_READY")) {
            System.out.println("[Dispatcher]: Еда готова. Зову Официанта.");
            waiter.serve();
        }
    }
}
