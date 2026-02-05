public class ShawarmaType {
    private String name;
    private String color;
    private double price;

    public ShawarmaType(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public void draw(int x, int y) {
        System.out.println(
                "Отрисовка [" + name + " | " + color + "] " + "в координатах (" + x + ", " + y + ")"
        );
    }
}
