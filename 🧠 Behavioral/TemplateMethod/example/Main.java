public class Main {
    public static void main(String[] args) {
        System.out.println("--- Заказ 1: Классика ---");
        ShawarmaTemplate classic = new MeatShawarma();
        classic.makeShawarma();

        System.out.println("--- Заказ 2: Веганская ---");
        ShawarmaTemplate vegan = new VeganShawarma();
        vegan.makeShawarma();

        System.out.println("--- Заказ 3: Без соуса ---");
        ShawarmaTemplate dry = new DryShawarma();
        dry.makeShawarma();
    }
}