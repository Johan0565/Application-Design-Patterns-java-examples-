abstract class Component {
    protected Mediator mediator;
    protected String name;

    public Component(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
}
