# Composite (Компоновщик) — пример заказа в шаурмечной

Паттерн **Composite (Компоновщик)** позволяет работать с **одиночными объектами (Leaf)** и **составными объектами (Composite)** одинаково через общий интерфейс (**Component**).  
Чаще всего он используется для представления **иерархии «дерево»** (папки/файлы, меню, корзина заказа и т.п.).

В этом примере:
- **Product** — это единичный товар (лист).
- **OrderBox** — это коробка/контейнер, который может содержать товары и другие коробки (композит).
- Клиент (касса) работает с ними одинаково через интерфейс `OrderComponent`.

---

## Участники паттерна в коде

### 1) Component (общий интерфейс)

`OrderComponent` задаёт единые операции для всех элементов дерева:

```java
interface OrderComponent {
    double getPrice();
    void printOrder(String indent);
}
```

---

### 2) Leaf (лист / простой элемент)

`Product` — конечный элемент, у него **нет детей**:

```java
class Product implements OrderComponent {
    private String name;
    private double price;

    public double getPrice() { return price; }

    public void printOrder(String indent) {
        System.out.println(indent + "- " + name + " ($" + price + ")");
    }
}
```

---

### 3) Composite (составной объект)

`OrderBox` — контейнер, который хранит список `OrderComponent` (важно: интерфейс, а не конкретные классы):

```java
class OrderBox implements OrderComponent {
    private List<OrderComponent> items = new ArrayList<>();

    public void add(OrderComponent item) { items.add(item); }
    public void remove(OrderComponent item) { items.remove(item); }
}
```

**Ключевая идея — рекурсия**: композит вызывает те же методы у своих детей.

#### Рекурсивный подсчёт цены

```java
public double getPrice() {
    double total = 0;
    for (OrderComponent item : items) {
        total += item.getPrice();
    }
    return total;
}
```

#### Рекурсивная печать структуры

```java
public void printOrder(String indent) {
    System.out.println(indent + "[" + name + "]");
    for (OrderComponent item : items) {
        item.printOrder(indent + "   ");
    }
}
```

---

## Как используется в Main

### 1) Создаём листья (товары)

```java
Product classicShawarma = new Product("Classic Shawarma", 5.0);
Product cola = new Product("Cola 0.5", 1.5);
...
```

### 2) Создаём композиты (коробки) и вкладываем их друг в друга

```java
OrderBox kidsBox = new OrderBox("Kids Combo Box");
kidsBox.add(classicShawarma);
kidsBox.add(cola);

OrderBox deliveryBag = new OrderBox("BIG Delivery Bag");
deliveryBag.add(spicyShawarma);
deliveryBag.add(fries);
deliveryBag.add(kidsBox);   // коробка внутри коробки
deliveryBag.add(sauce);
```

### 3) Клиент работает с «корнем дерева»

Кассе не нужно знать структуру — она вызывает методы у `deliveryBag`:

```java
deliveryBag.printOrder("");
System.out.println("TOTAL PRICE: $" + deliveryBag.getPrice());
```

---

## Зачем нужен Composite

- удобно представлять вложенные структуры «дерево»
- единый API для простых и составных объектов
- легко добавлять новые типы компонентов без переписывания клиентского кода

---

## Отличие от похожих паттернов

- **Decorator** добавляет поведение одному объекту, не строя дерево из объектов.
- **Composite** строит дерево и позволяет одинаково работать с узлами и листьями.
