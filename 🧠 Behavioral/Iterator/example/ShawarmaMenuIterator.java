import java.util.Iterator;

public class ShawarmaMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int currentIndex = 0;

    public  ShawarmaMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public  boolean hasNext() {
        return currentIndex < items.length && items[currentIndex] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[currentIndex];
        currentIndex++;
        return  menuItem;
    }

}
