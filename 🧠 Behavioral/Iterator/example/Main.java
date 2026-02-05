import java.util.Iterator;
public class Main {
    public static void main(String[] args) {

        ShawarmaMenu menu = new ShawarmaMenu(10); // Места всего на 10 блюд
        menu.addItem("Classic Chicken", 5.0);
        menu.addItem("Spicy Beef", 6.5);
        menu.addItem("Vegan Falafel", 4.0);

        System.out.println("--- Ручной перебор через Iterator ---");
        Iterator<MenuItem> iterator = menu.iterator();

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item);
        }

        System.out.println("\n--- Использование foreach (Java magic) ---");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }
}
