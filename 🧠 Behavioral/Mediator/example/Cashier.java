class Cashier extends Component {
    public Cashier(Mediator mediator) { super(mediator, "Cashier"); }

    public void sendOrder() {
        System.out.println(name + ": Заказ принят. Отправляю сигнал.");
        mediator.notify(this, "ORDER_PLACED");
    }
}