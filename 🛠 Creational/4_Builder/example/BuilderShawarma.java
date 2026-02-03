public class BuilderShawarma {
    private final Size size;
    private final Bread bread;
    private final Protein protein;

    private final Sauce sauce;
    private final boolean addCheese;
    private final boolean addFries;
    private final boolean addPickles;
    private final int spicyLevel; // 0..5
    private final String notes;

    private BuilderShawarma(Builder builder) {
        this.size = builder.size;
        this.bread = builder.bread;
        this.protein = builder.protein;

        this.sauce = builder.sauce;
        this.addCheese = builder.addCheese;
        this.addFries = builder.addFries;
        this.addPickles = builder.addPickles;
        this.spicyLevel = builder.spicyLevel;
        this.notes = builder.notes;
    }

    public void serve() {
        System.out.println("=== Shawarma (Builder) ===");
        System.out.println("Size: " + size);
        System.out.println("Bread: " + bread);
        System.out.println("Protein: " + protein);
        System.out.println("Sauce: " + (sauce == null ? "None" : sauce));
        System.out.println("Extras: "
                + (addCheese ? "cheese " : "")
                + (addFries ? "fries " : "")
                + (addPickles ? "pickles " : "")
        );
        System.out.println("Spicy level: " + spicyLevel + "/5");
        if (notes != null && !notes.isBlank()) {
            System.out.println("Notes: " + notes);
        }
        System.out.println("==========================\n");
    }

    public enum Size { SMALL, MEDIUM, LARGE }
    public enum Bread { LAVASH, PITA }
    public enum Protein { CHICKEN, BEEF, VEGGIE }
    public enum Sauce { GARLIC, CHILI, BBQ, TAHINI }

    public static class Builder {

        private final Size size;
        private final Bread bread;
        private final Protein protein;

        private Sauce sauce = null;
        private boolean addCheese = false;
        private boolean addFries = false;
        private boolean addPickles = false;
        private int spicyLevel = 0;
        private String notes = "";

        public Builder(Size size, Bread bread, Protein protein) {
            if (size == null || bread == null || protein == null) {
                throw new IllegalArgumentException("size, bread, protein are required");
            }
            this.size = size;
            this.bread = bread;
            this.protein = protein;
        }

        public Builder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder cheese(boolean value) {
            this.addCheese = value;
            return this;
        }

        public Builder fries(boolean value) {
            this.addFries = value;
            return this;
        }

        public Builder pickles(boolean value) {
            this.addPickles = value;
            return this;
        }

        public Builder spicyLevel(int level) {
            if (level < 0 || level > 5) {
                throw new IllegalArgumentException("spicyLevel must be between 0 and 5");
            }
            this.spicyLevel = level;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes == null ? "" : notes;
            return this;
        }

        public BuilderShawarma build() {
            return new BuilderShawarma(this);
        }
    }
}
