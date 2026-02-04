public class Main {
    public static void main(String[] args) {
        // 1. Создаем сотрудников (звенья)
        SupportHandler bot = new RobotBot();
        SupportHandler manager = new ShiftManager();
        SupportHandler owner = new Owner();

        // 2. Выстраиваем цепочку: Бот -> Менеджер -> Владелец
        bot.setNext(manager);
        manager.setNext(owner);

        System.out.println("--- Клиент 1: 'До скольки работаете?' (Простой вопрос) ---");
        bot.handleRequest("Часы работы", 1);

        System.out.println("\n--- Клиент 2: 'Шаурма холодная, верните деньги!' (Средний вопрос) ---");
        bot.handleRequest("Холодная еда", 2);

        System.out.println("\n--- Клиент 3: 'Я отравился и подаю в суд!' (Критический вопрос) ---");
        bot.handleRequest("Судебный иск", 3);

        System.out.println("\n--- Клиент 4: 'На нас летит метеорит!' (Неизвестная проблема) ---");
        bot.handleRequest("Метеорит", 4);
    }
}