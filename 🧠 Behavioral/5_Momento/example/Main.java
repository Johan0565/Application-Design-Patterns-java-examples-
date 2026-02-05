public class Main {
    public static void main(String[] args) {
        ShawarmaOrder order = new ShawarmaOrder();
        History history = new History();

        System.out.println("--- Начало сборки ---");

        order.addIngredient("Курица");
        history.push(order.save());

        order.addIngredient("Соус Чесночный");

        history.push(order.save());

        System.out.println("\n--- Случайная ошибка ---");
        order.addIngredient("АДСКИЙ ПЕРЕЦ ЧИЛИ");

        System.out.println("\n--- Нажата кнопка ОТМЕНА ---");

        ShawarmaMemento lastSave = history.pop();

        order.restore(lastSave);

        order.addIngredient("Свежий огурчик");

        System.out.println("\n--- Еще раз ОТМЕНА ---");
        order.restore(history.pop());
    }
}