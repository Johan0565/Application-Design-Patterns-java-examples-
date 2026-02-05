// === 2. CONTEXT (Контекст) ===
class ShawarmaOrder {
    private State currentState;

    public ShawarmaOrder() {
        this.currentState = new RawState();
    }

    public void setState(State newState) {
        this.currentState = newState;
    }


    public void next() {
        currentState.nextStep(this);
    }

    public void eat() {
        currentState.eat();
    }
}
