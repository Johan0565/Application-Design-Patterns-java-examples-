public class MakeShawarmaOrder implements Order{
    private final chef chef;

    public MakeShawarmaOrder(chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookShawarma();
    }

    @Override
    public void undo() {
        chef.stopCooking();
    }
}
