class Owner extends SupportHandler {
    @Override
    protected boolean canHandle(int severity) {
        return severity == 3;
    }

    @Override
    protected void process(String issue) {
        System.out.println("[OWNER]: Слушаю. Кто посмел обидеть клиента? Решаю вопрос лично: '" + issue + "'.");
    }
}