# Flyweight (Легковес) — отрисовка заказов шаурмы на карте

Паттерн **Flyweight (Легковес)** уменьшает расход памяти, когда в системе есть **очень много похожих объектов**.  
Идея: разделить состояние на:
- **внутреннее (intrinsic)** — общее, «тяжёлое», неизменяемое → хранится внутри легковеса и переиспользуется
- **внешнее (extrinsic)** — уникальное для каждого экземпляра → хранится снаружи и передаётся в методы легковеса

В этом примере на карте много заказов, но типов шаурмы мало. Поэтому мы кэшируем типы шаурмы и переиспользуем их.

---

## Участники паттерна в коде

### 1) Flyweight (легковес)

`ShawarmaType` хранит «тяжёлые» общие данные типа:
- `name`
- `color` (условная «текстура/картинка»)
- `price`

```java
class ShawarmaType {
    private String name;
    private String color;
    private double price;

    public void draw(int x, int y) { ... }
}
```

Метод `draw(x, y)` принимает **внешнее состояние** (координаты), то есть легковес сам координаты не хранит.

---

### 2) Flyweight Factory (фабрика легковесов)

`ShawarmaFactory` отвечает за **кэширование**:

```java
class ShawarmaFactory {
    private static final Map<String, ShawarmaType> cache = new HashMap<>();

    public static ShawarmaType getShawarmaType(String name, String color, double price) {
        ShawarmaType result = cache.get(name);
        if (result == null) {
            result = new ShawarmaType(name, color, price);
            cache.put(name, result);
        }
        return result;
    }
}
```

Если тип уже был создан — возвращается **тот же объект** (ссылка из `cache`), иначе создаётся новый и кладётся в кэш.

> Важно: в этом коде ключ кэша — только `name`.  
> Если у одного `name` могут быть разные `color/price`, лучше делать ключ составным (например `name+color+price`).

---

### 3) Context (контекст)

`OrderOnMap` хранит **уникальные данные** заказа:
- координаты `x`, `y` (внешнее состояние)
- ссылку на `ShawarmaType` (легковес)

```java
class OrderOnMap {
    private int x;
    private int y;
    private ShawarmaType type;

    public void render() {
        type.draw(x, y);
    }
}
```

Контекст «лёгкий»: он не дублирует тяжёлые данные типа.

---

## Как это работает в Main

В цикле:
1) получаем тип из фабрики (скорее всего — ссылку на уже существующий объект)
2) создаём контекст с координатами
3) рендерим

```java
ShawarmaType type = ShawarmaFactory.getShawarmaType(names[i], colors[i], prices[i]);
OrderOnMap order = new OrderOnMap(i * 10, i * 20, type);
order.render();
```

Для доказательства переиспользования выводится:

```java
System.out.println(System.identityHashCode(type));
```

Одинаковые `identityHashCode` для одинаковых типов → значит возвращается **тот же объект** из кэша.

---

## Зачем нужен Flyweight

- когда объектов очень много, и они отличаются только малой частью данных
- чтобы не хранить одни и те же «тяжёлые» данные тысячами копий
- типичный кейс: частицы/деревья/иконки на карте/символы текста/тайлы в игре

---

## Отличие от похожих паттернов

- **Prototype** клонирует объекты (создаёт новые экземпляры).
- **Flyweight** старается **не создавать** лишних экземпляров и переиспользует общие.
