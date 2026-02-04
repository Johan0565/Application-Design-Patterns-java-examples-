public class KitchenSystem {
    public void turnOnGrill() {
        System.out.println("1. [Kitchen] Гриль включен. Разогрев...");
    }
    public void cookOrder(String dish) {
        System.out.println("2. [Kitchen] Готовим: " + dish + ". Шинкуем капусту, жарим мясо.");
    }
    public void packOrder() {
        System.out.println("3. [Kitchen] Заказ упакован в термосумку.");
    }
}
