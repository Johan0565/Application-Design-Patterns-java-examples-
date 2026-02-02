# Factory Method — пример из этого проекта

Паттерн **Factory Method (Фабричный метод)** позволяет создавать объекты через общий интерфейс/абстракцию, **делегируя выбор конкретного класса подклассам**.  
Это помогает отделить *логику использования объекта* от *логики его создания*.

В этом проекте пример реализован на «шаурме»: есть общий магазин, который умеет **оформлять заказ** (одинаковый алгоритм), а **какую именно шаурму создать** — решают конкретные магазины.

---

## Как это реализовано в коде

### 1) Creator: базовый класс магазина + общий алгоритм заказа

Файл: `ShawarmaStore.java`

`orderShawarma()` — это шаблонный метод: он описывает **общий процесс** (prepare → cook → wrap), но создание продукта вынесено в фабричный метод `createShawarma()`:

```java
abstract class ShawarmaStore {
   public Shawarma orderShawarma() {
        Shawarma shawarma = createShawarma();

        shawarma.prepare();
        shawarma.cook();
        shawarma.wrap();

        System.out.println("Order ready: " + shawarma.getName() + "\n");
        return shawarma;
    }
    protected abstract Shawarma createShawarma();
}
```

Ключевое здесь:
- `orderShawarma()` не знает, **какой именно** класс шаурмы будет создан.
- `createShawarma()` — **Factory Method** (фабричный метод), который обязаны реализовать подклассы.

---

### 2) Concrete Creators: конкретные магазины решают, что создавать

Файлы: `ChickenShawarmaStore.java`, `BeefShawarmaStore.java`

Каждый подкласс переопределяет фабричный метод и возвращает нужный продукт:

```java
public class ChickenShawarmaStore extends ShawarmaStore {
    @Override
    protected Shawarma createShawarma() {
        return new ChickenShawarma();
    }
}
```

```java
public class BeefShawarmaStore extends ShawarmaStore {
    @Override
    protected Shawarma createShawarma() {
        return new BeefShawarma();
    }
}
```

---

### 3) Product: абстракция шаурмы

Файл: `Shawarma.java`

`Shawarma` — базовый продукт с общими полями и поведением:

```java
abstract class Shawarma {
    String name;
    String sauce;
    String meat;

    void prepare() { ... }
    void cook() { ... }
    void wrap() { ... }

    public String getName() {
        return name;
    }
}
```

---

### 4) Concrete Products: конкретные виды шаурмы

Файлы: `ChickenShawarma.java`, `BeefShawarma.java`

Классы задают конкретные параметры продукта:

```java
public class ChickenShawarma extends Shawarma{
    public ChickenShawarma() {
        name = "Classic Chicken Shawarma";
        meat = "Chicken Breast";
        sauce = "Garlic Mayo";
    }
}
```

```java
public class BeefShawarma extends Shawarma{
    public BeefShawarma() {
        name = "Spicy Beef Shawarma";
        meat = "Marinated Beef";
        sauce = "Hot Chili Sauce";
    }
}
```

---

## Где это используется

Файл: `Main.java`

В `Main` создаются разные магазины (Creator), но заказ оформляется одинаково через `orderShawarma()`:

```java
ShawarmaStore chickenShop = new ChickenShawarmaStore();
chickenShop.orderShawarma();

ShawarmaStore beefShop = new BeefShawarmaStore();
beefShop.orderShawarma();
```

---

## Зачем нужен Factory Method

- чтобы код, который **использует** объект, не зависел от конкретных классов (`new ...`)
- чтобы легко добавлять новые типы продуктов, не переписывая общий алгоритм работы

Например, чтобы добавить `VeganShawarma`, достаточно:
1) создать `VeganShawarma extends Shawarma`
2) создать `VeganShawarmaStore extends ShawarmaStore` и переопределить `createShawarma()`

---

## Важно

В этом примере:
- `orderShawarma()` — общий процесс (не меняется)
- `createShawarma()` — место, где меняется конкретика (что именно создаём)
