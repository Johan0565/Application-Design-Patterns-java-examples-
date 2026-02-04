public class OrderOnMap {
    private int x;
    private int y;
    private ShawarmaType type;

    public OrderOnMap(int x, int y, ShawarmaType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void render() {
        type.draw(x, y);
    }
}
