public class Main {
    public static void main(String[] args) {
        OrderBoard board = new OrderBoard();

        Observer clientIvan = new WaitingCustomer("Иван");
        Observer clientMaria = new WaitingCustomer("Мария");
        Observer app = new MobileAppNotificatoin();

        board.subscribe(clientIvan);
        board.subscribe(clientMaria);
        board.subscribe(app);



        board.changeOrderStatus("101", "COOKING");

        System.out.println("...... прошло 5 минут ......");

        board.changeOrderStatus("101", "READY");

        board.unsubscribe(clientIvan);

        System.out.println("\n...... Новый заказ ......");
        board.changeOrderStatus("102", "READY");
    }
}