public class Singleton {
    private Singleton(){
        System.out.println("Singleton initialized!");
    }

    private static class SingletonHolder {
        private static final Singleton INSTANSE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANSE;
    }

    public void AbyB(int a,int b){
        System.out.print("Result: " + a * b + "\n");
    }
}
