import java.util.ArrayList;
import java.util.List;

public class ShawarmaOrder implements Cloneable{
    private String name;
    private List<String> ingredients;
    private double price;

    public ShawarmaOrder(String name, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Order: " + name + " | Price: $" + price + " | Ingredients: " + ingredients;
    }

    @Override
    public ShawarmaOrder clone() {
        try {
            // 1. Поверхностное копирование (Shallow Copy).
            // Копирует примитивы (цена, имя) и ССЫЛКИ на объекты.
            ShawarmaOrder cloned = (ShawarmaOrder) super.clone();

            // 2. Глубокое копирование (Deep Copy).
            // КРИТИЧЕСКИ ВАЖНО: Мы должны создать НОВЫЙ список ингредиентов.
            // Иначе оригинал и клон будут ссылаться на один и тот же список в памяти.
            // Если мы изменим клон, испортится и оригинал.
            cloned.ingredients = new ArrayList<>(this.ingredients);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
