# Prototype (Прототип) — пример на «шаурме»

Паттерн **Prototype (Прототип)** позволяет создавать новые объекты не через `new`, а через **клонирование уже готового объекта-шаблона** (prototype).  
Это полезно, когда:
- объект «дорого» создавать (много настроек, вычислений, запросов и т.п.)
- нужно быстро делать много похожих объектов с небольшими отличиями

В этом примере прототип — это стандартный заказ шаурмы (`standardPrototype`), который потом клонируется под разных клиентов.

---

## Где в коде паттерн

### 1) Прототип: класс поддерживает клонирование

Класс `ShawarmaOrder` реализует `Cloneable` и переопределяет `clone()`:

```java
class ShawarmaOrder implements Cloneable {
    ...
    @Override
    public ShawarmaOrder clone() { ... }
}
```

`Cloneable` — маркерный интерфейс: он сообщает JVM, что объект можно клонировать через `Object.clone()`.

---

## Главная часть: clone() и Deep Copy

В `clone()` делаются два шага:

### 1) Shallow Copy (поверхностная копия)

```java
ShawarmaOrder cloned = (ShawarmaOrder) super.clone();
```

Это копирует:
- примитивы (`double price`)
- ссылки на объекты (`String name`, `List<String> ingredients`)

⚠️ Проблема: список `ingredients` после такого копирования будет **общим** для оригинала и клона.

---

### 2) Deep Copy (глубокая копия списка)

Чтобы оригинал и клон не делили один и тот же список, создаётся **новый** `ArrayList`:

```java
cloned.ingredients = new ArrayList<>(this.ingredients);
```

Теперь:
- у клона свой список ингредиентов
- изменения списка в клоне **не ломают** оригинал

---

## Как используется прототип в Main

### 1) Создание «шаблона» (prototype)

```java
ShawarmaOrder standardPrototype = new ShawarmaOrder("Standard Special", 5.50);
standardPrototype.addIngredient("Chicken");
standardPrototype.addIngredient("Garlic Sauce");
standardPrototype.addIngredient("Tomato");
standardPrototype.addIngredient("Onion");
```

Это базовая «заготовка», которую удобно копировать.

---

### 2) Клонирование для клиента 1

```java
ShawarmaOrder client1Order = standardPrototype.clone();
client1Order.setName("Client 1 Order");
```

---

### 3) Клонирование для клиента 2 + изменение

```java
ShawarmaOrder client2Order = standardPrototype.clone();
client2Order.setName("Client 2 Order (No Onion)");
client2Order.addIngredient("Extra Cheese");
```

Важно: `addIngredient()` меняет **список**.  
Благодаря Deep Copy, изменение происходит только у клона, а не у `standardPrototype`.

---

### 4) Проверка, что оригинал не изменился

Код выводит оригинальный прототип в конце:

```java
System.out.println("Check Original again: " + standardPrototype);
```

Если Deep Copy сделан правильно — список ингредиентов у прототипа остаётся прежним.

---

## Плюсы и минусы подхода

✅ Плюсы:
- быстрое создание похожих объектов
- можно копировать «преднастроенные» шаблоны
- уменьшает количество повторяющегося кода и настроек

⚠️ Минусы:
- нужно внимательно делать Deep Copy для изменяемых полей (списки/объекты), иначе будет общий state
- `Cloneable`/`Object.clone()` в Java часто считают не самым удобным API (альтернатива — копирующий конструктор или статический `copyOf(...)`)

---

## Отличие от Builder

- **Builder** собирает объект пошагово.
- **Prototype** делает новый объект **копированием** существующего.
