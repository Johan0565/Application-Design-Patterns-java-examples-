class RobotBot extends SupportHandler {
    @Override
    protected boolean canHandle(int severity) {
        return severity == 1;
    }

    @Override
    protected void process(String issue) {
        System.out.println("[Robot]: Привет! Я нашел ответ в базе знаний на вопрос: '" + issue + "'.");
    }
}
