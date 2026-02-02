public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        a.AbyB(2,2);

        if (a == b) {
            System.out.println("It's the same object!");
        } else {
            System.out.println("Different objects (Error)");
        }
    }
}