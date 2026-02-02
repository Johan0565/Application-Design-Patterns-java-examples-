abstract class Shawarma {
    String name;
    String sauce;
    String meat;

    void prepare() {
        System.out.println("PREPARING: " + name + " ---");
        System.out.println("Slicing " + meat + "...");
        System.out.println("Adding special sauce: " + sauce + "...");
    }

    void cook() {
        System.out.println("Grilling the meat at high temperature...");
    }

    void wrap() {
        System.out.println("Wrapping in fresh lavash bread...");
    }

    public String getName() {
        return name;
    }
}
