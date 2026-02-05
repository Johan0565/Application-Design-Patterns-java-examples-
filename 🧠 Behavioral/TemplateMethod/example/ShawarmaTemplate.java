abstract class ShawarmaTemplate {

    public final void makeShawarma() {
        cutBun();
        addMainFilling();
        addVegetables();

        if (customerWantsSauce()) {
            addSauce();
        }

        wrap();
        System.out.println(">> Заказ готов! Приятного аппетита.\n");
    }

    private void cutBun() {
        System.out.println("1. Разрезаем свежий лаваш.");
    }

    private void wrap() {
        System.out.println("5. Аккуратно заворачиваем в рулет.");
    }

    protected abstract void addMainFilling();

    protected abstract void addVegetables();

    protected abstract void addSauce();

    protected boolean customerWantsSauce() {
        return true;
    }
}
