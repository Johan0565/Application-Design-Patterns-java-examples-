public class Product implements OrderComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void printOrder(String indent) {
        System.out.println(indent + "- " + name + " ($" + price + ")");
    }
}
