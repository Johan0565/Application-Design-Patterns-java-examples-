class WaitingCustomer implements Observer {
    private String name;

    public WaitingCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(String orderId, String status) {
        if ("READY".equals(status)) {
            System.out.println("   [Клиент " + name + "]: О! Мой заказ " + orderId + " готов! Бегу забирать.");
        } else {
            System.out.println("   [Клиент " + name + "]: Эх, заказ " + orderId + " пока " + status + ". Жду дальше.");
        }
    }
}