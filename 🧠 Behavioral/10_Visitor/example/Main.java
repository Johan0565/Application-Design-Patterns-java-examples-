import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<ItemElement> order = new ArrayList<>();
        order.add(new Shawarma("Chicken Classic", 600));
        order.add(new Drink("Cola Zero", 500, 1)); // Почти 0 калорий
        order.add(new Shawarma("Mega Beef", 950));

        System.out.println("--- Запуск счетчика калорий ---");
        CalorieCounterVisitor fitApp = new CalorieCounterVisitor();

        for (ItemElement item : order) {
            item.accept(fitApp);
        }
        fitApp.printTotal();

        System.out.println("--- Запуск экспорта в XML ---");
        XmlExportVisitor xmlExporter = new XmlExportVisitor();

        for (ItemElement item : order) {
            item.accept(xmlExporter);
        }
    }
}