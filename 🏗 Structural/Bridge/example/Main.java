public class Main {
    public static void main(String[] args) {
        // Создаем устройства (инструменты)
        CookingDevice oven = new ElectricOven();
        CookingDevice grill = new FireGrill();

        // Теперь мы можем комбинировать Мясо и Инструменты как угодно!

        // 1. Курица в печи
        Shawarma meal1 = new ChickenShawarma(oven);
        meal1.prepare();

        // 2. Курица на гриле (То же мясо, другой девайс)
        Shawarma meal2 = new ChickenShawarma(grill);
        meal2.prepare();

        // 3. Говядина на гриле
        Shawarma meal3 = new BeefShawarma(grill);
        meal3.prepare();
    }
}