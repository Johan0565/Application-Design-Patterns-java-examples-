abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String issue, int severity) {
        if (canHandle(severity)) {
            process(issue);
        } else if (nextHandler != null) {
            System.out.println("   >> [Перевод звонка выше...]");
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Никто не может решить эту проблему: " + issue);
        }
    }

    protected abstract boolean canHandle(int severity);
    protected abstract void process(String issue);
}
