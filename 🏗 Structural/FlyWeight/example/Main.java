public class Main {
    public static void main(String[] args) {
        String[] names = {"Chicken", "Beef", "Chicken", "Chicken", "Beef"};
        String[] colors = {"Yellow", "Brown", "Yellow", "Yellow", "Brown"};
        double[] prices = {5.0, 6.0, 5.0, 5.0, 6.0};

        System.out.println("Начинаем отрисовку карты...\n");

        for (int i = 0; i < names.length; i++) {
            // 1. Просим фабрику дать нам тип.
            // Фабрика вернет ССЫЛКУ на уже существующий объект, если он был создан.
            ShawarmaType type = ShawarmaFactory.getShawarmaType(names[i], colors[i], prices[i]);

            // 2. Создаем легкий контекст (координаты случайны для примера)
            OrderOnMap order = new OrderOnMap(i * 10, i * 20, type);

            // 3. Рисуем
            order.render();

            // Для проверки выведем хэш-код объекта type, чтобы доказать, что это один и тот же объект
            System.out.println("Hash объекта типа: " + System.identityHashCode(type));
            System.out.println("-------------------------");
        }
    }
}
