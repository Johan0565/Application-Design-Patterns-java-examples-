import java.util.Iterator;

public class ShawarmaMenu implements Iterable<MenuItem>{
    private MenuItem[] menuItems;
    private int position = 0;

    public ShawarmaMenu(int size) {
        menuItems = new MenuItem[size];
    }

    public void addItem(String name, double price){
        if (position >= menuItems.length) {
            System.err.println("Меню переполнено! Нельзя добавить: " + name);
        } else {
            menuItems[position] = new MenuItem(name,price);
            position++;
        }
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new ShawarmaMenuIterator(menuItems);
    }
}
