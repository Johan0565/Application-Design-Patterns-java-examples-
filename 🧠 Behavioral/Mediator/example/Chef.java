class Chef extends Component {

    public Chef(Mediator mediator) {
        super(mediator, "Chef");
    }

    public void cook() {
        System.out.println(name + ": Начинаю жарить мясо...");
        System.out.println(name + ": Еда готова!");
        mediator.notify(this, "FOOD_READY");
    }
}
