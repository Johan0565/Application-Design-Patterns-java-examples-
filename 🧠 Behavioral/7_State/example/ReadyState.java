// Состояние 3: ГОТОВА
class ReadyState implements State {
    @Override
    public void nextStep(ShawarmaOrder order) {
        System.out.println("   [Info] Заказ уже готов и выдан. Куда дальше-то?");
    }

    @Override
    public void eat() {
        System.out.println("   [Успех] Ням-ням! Очень вкусно.");
    }
}
