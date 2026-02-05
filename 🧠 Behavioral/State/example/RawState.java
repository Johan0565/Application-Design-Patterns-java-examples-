// Состояние 1: СЫРАЯ
class RawState implements State {
    @Override
    public void nextStep(ShawarmaOrder order) {
        System.out.println("   [Raw] Ставим мясо на гриль...");
        order.setState(new CookingState());
    }

    @Override
    public void eat() {
        System.out.println("   [Ошибка] Вы пытаетесь укусить сырое мясо. Фу! Сначала приготовьте.");
    }
}
