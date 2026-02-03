public class BuilderShawarmaChef {

    public BuilderShawarma makeClassicChicken() {
        return new BuilderShawarma.Builder(
                BuilderShawarma.Size.MEDIUM,
                BuilderShawarma.Bread.LAVASH,
                BuilderShawarma.Protein.CHICKEN
        )
                .sauce(BuilderShawarma.Sauce.GARLIC)
                .pickles(true)
                .spicyLevel(1)
                .notes("Classic chicken, not too spicy")
                .build();
    }

    public BuilderShawarma makeSpicyBeef() {
        return new BuilderShawarma.Builder(
                BuilderShawarma.Size.LARGE,
                BuilderShawarma.Bread.PITA,
                BuilderShawarma.Protein.BEEF
        )
                .sauce(BuilderShawarma.Sauce.CHILI)
                .cheese(true)
                .pickles(true)
                .spicyLevel(5)
                .notes("Maximum heat!")
                .build();
    }

    public BuilderShawarma makeVeggieLight() {
        return new BuilderShawarma.Builder(
                BuilderShawarma.Size.SMALL,
                BuilderShawarma.Bread.LAVASH,
                BuilderShawarma.Protein.VEGGIE
        )
                .sauce(BuilderShawarma.Sauce.TAHINI)
                .pickles(true)
                .spicyLevel(0)
                .notes("No meat, easy")
                .build();
    }
}
