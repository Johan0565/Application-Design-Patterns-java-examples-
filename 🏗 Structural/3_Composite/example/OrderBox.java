import java.util.ArrayList;
import java.util.List;

class OrderBox implements OrderComponent {
    private String name;
    private List<OrderComponent> items = new ArrayList<>();

    public OrderBox(String name) {
        this.name = name;
    }

    public void add(OrderComponent item) {
        items.add(item);
    }

    public void remove(OrderComponent item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (OrderComponent item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void printOrder(String indent) {
        System.out.println(indent + "[" + name + "]");

        for (OrderComponent item : items) {
            item.printOrder(indent + "   ");
        }
    }
}
