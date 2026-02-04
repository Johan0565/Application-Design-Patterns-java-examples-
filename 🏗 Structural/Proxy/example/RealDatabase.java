class RealDatabase implements SecretDatabase {

    public RealDatabase() {
        // Симуляция тяжелой инициализации
        System.out.println("   [System] Загрузка секретной базы данных...");
    }

    @Override
    public void getSecretRecipe(String userRole) {
        System.out.println("   === СЕКРЕТНЫЙ РЕЦЕПТ: Майонез + Кефир + Чеснок + Слезы конкурентов ===");
    }
}