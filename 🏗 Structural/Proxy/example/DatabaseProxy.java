public class DatabaseProxy implements SecretDatabase {
    private RealDatabase realDatabase;

    @Override
    public void getSecretRecipe(String userRole) {
        System.out.println("\n[Proxy] Запрос от пользователя: " + userRole);

        // 1. ПРОВЕРКА ДОСТУПА (Access Control)
        if (!"CHEF".equalsIgnoreCase(userRole)) {
            System.out.println("[Proxy] ОТКАЗАНО: У вас недостаточно прав!");
            return;
        }

        // 2. ЛЕНИВАЯ ИНИЦИАЛИЗАЦИЯ (Lazy Loading)
        if (realDatabase == null) {
            System.out.println("[Proxy] Доступ разрешен. Подключаю базу...");
            realDatabase = new RealDatabase();
        }

        // 3. Вызов реального метода
        realDatabase.getSecretRecipe(userRole);

        // 4. Логирование (Logging)
        System.out.println("[Proxy] Операция залогирована.");
    }
}
