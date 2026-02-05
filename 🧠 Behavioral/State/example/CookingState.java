// Состояние 2: ГОТОВИТСЯ
class CookingState implements State {
    @Override
    public void nextStep(ShawarmaOrder order) {
        System.out.println("   [Cooking] Снимаем с огня, заворачиваем в лаваш...");
        order.setState(new ReadyState());
    }

    @Override
    public void eat() {
        System.out.println("   [Ошибка] Ой! Горячо! Подождите, пока завернут.");
    }
}
