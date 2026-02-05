import java.util.HashMap;
import java.util.Map;

public class ShawarmaFactory {
    private static final Map<String, ShawarmaType> cache = new HashMap<>();

    public static ShawarmaType getShawarmaType (String name, String color, double price) {
        ShawarmaType result = cache.get(name);

        if (result == null) {
            result = new ShawarmaType(name, color, price);
            cache.put(name,result);
            System.out.println("--- СОЗДАН НОВЫЙ ТИП: " + name + " ---");
        }

        return result;
    }
}
