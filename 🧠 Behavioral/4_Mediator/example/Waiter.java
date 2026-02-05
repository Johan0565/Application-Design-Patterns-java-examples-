class  Waiter extends  Component {
    public Waiter(Mediator mediator) {
        super(mediator, "Waiter");
    }
    public void serve() {
        System.out.println(name + ": Забираю заказ и несу клиенту.");
    }
}