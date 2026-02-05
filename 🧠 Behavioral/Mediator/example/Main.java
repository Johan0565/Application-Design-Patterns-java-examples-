public class Main {
    public static void main(String[] args) {
        RestaurantDispatcher dispatcher = new RestaurantDispatcher();

        Cashier cashier = new Cashier(dispatcher);
        Chef chef = new Chef(dispatcher);
        Waiter waiter = new Waiter(dispatcher);

        dispatcher.setCashier(cashier);
        dispatcher.setChef(chef);
        dispatcher.setWaiter(waiter);

        System.out.println("--- Начало работы ---");

        cashier.sendOrder();
    }
}