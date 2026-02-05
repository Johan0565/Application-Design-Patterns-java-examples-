public class MakeBurgerOrder implements Order{
    private chef chef;

    public MakeBurgerOrder(chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookBurger();
    }

    @Override
    public void undo() {
        chef.stopCooking();
    }
}
