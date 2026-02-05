public class Main {
    public static void main(String[] args) {
        ShawarmaOrder myLunch = new ShawarmaOrder();

        System.out.println("--- Этап 1: Только заказали ---");
        myLunch.eat();
        myLunch.next();

        System.out.println("\n--- Этап 2: Процесс жарки ---");
        myLunch.eat();
        myLunch.next();

        System.out.println("\n--- Этап 3: Выдача ---");
        myLunch.eat();

        System.out.println("\n--- Попытка пойти дальше ---");
        myLunch.next();
    }
}