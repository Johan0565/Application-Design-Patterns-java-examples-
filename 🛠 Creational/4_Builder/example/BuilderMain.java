public class BuilderMain {
    public static void main(String[] args) {
        BuilderShawarma custom = new BuilderShawarma.Builder(
                BuilderShawarma.Size.LARGE,
                BuilderShawarma.Bread.LAVASH,
                BuilderShawarma.Protein.CHICKEN
        )
                .sauce(BuilderShawarma.Sauce.BBQ)
                .cheese(true)
                .fries(true)
                .pickles(false)
                .spicyLevel(3)
                .notes("Extra fries, BBQ sauce")
                .build();

        custom.serve();

        BuilderShawarmaChef chef = new BuilderShawarmaChef();
        chef.makeClassicChicken().serve();
        chef.makeSpicyBeef().serve();
        chef.makeVeggieLight().serve();
    }
}
