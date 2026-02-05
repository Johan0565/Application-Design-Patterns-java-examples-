public class ShiftManager extends SupportHandler{
    @Override
    protected boolean canHandle(int severity) {
        return severity == 2;
    }

    @Override
    protected void process(String issue) {
        System.out.println("[Manager]: Здравствуйте. Приношу извинения. Мы оформим возврат за: '" + issue + "'.");
    }
}
