public class ShawarmaBotFacade {
    private KitchenSystem kitchen;
    private PaymentSystem payment;
    private DeliverySystem delivery;

    public ShawarmaBotFacade(){
        this.kitchen = new KitchenSystem();
        this.payment = new PaymentSystem();
        this.delivery = new DeliverySystem();
    }

    public void orderShawarmaCombo(String dishName, String address, String cardNo, double price) {
        System.out.println("--- Запуск протокола 'Хочу кушать' ---");

        // 1. Сначала деньги
        boolean paid = payment.makePayment(cardNo, price);

        if (paid) {
            // 2. Потом готовка
            kitchen.turnOnGrill();
            kitchen.cookOrder(dishName);
            kitchen.packOrder();

            // 3. Потом доставка
            delivery.findCourier();
            delivery.assignCourier(address);

            System.out.println("--- Заказ успешно обработан! Ждите еду. ---");
        } else {
            System.out.println("Ошибка оплаты!");
        }
    }

}
