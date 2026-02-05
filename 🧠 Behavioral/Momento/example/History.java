import java.util.Stack;

public class History {
    private Stack<ShawarmaMemento> historyStack = new Stack<>();

    public void push(ShawarmaMemento memento) {
        historyStack.push(memento);
    }

    public ShawarmaMemento pop() {
        if (!historyStack.isEmpty()) {
            return historyStack.pop();
        }
        return null;
    }

}
