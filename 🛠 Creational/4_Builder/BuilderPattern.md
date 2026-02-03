# Builder (Строитель) — пример на «шаурме»

Паттерн **Builder (Строитель)** нужен, когда объект имеет много параметров (часть обязательные, часть опциональные) и хочется собирать его **пошагово**, без «телескопических» конструкторов и без кучи перегрузок.

В этой программе «шаурма» собирается через `Builder`, а также есть `Director` с готовыми пресетами.

---

## Файлы

- `BuilderShawarma.java` — **Product** + вложенный **Builder**
- `BuilderShawarmaChef.java` — **Director** (готовые варианты)
- `BuilderMain.java` — пример использования

---

## Как это реализовано в коде

### 1) Product: объект, который собираем

Файл: `BuilderShawarma.java`

Класс `BuilderShawarma` содержит:
- **обязательные** поля: `size`, `bread`, `protein`
- **опциональные** поля: `sauce`, `addCheese`, `addFries`, `addPickles`, `spicyLevel`, `notes`

Конструктор продукта приватный, чтобы нельзя было создавать объект напрямую:

```java
private BuilderShawarma(Builder builder) { ... }
```

---

### 2) Builder: пошаговая сборка

Файл: `BuilderShawarma.java`

Вложенный класс:

```java
public static class Builder {
    public Builder(Size size, Bread bread, Protein protein) { ... } // обязательные
    public Builder sauce(Sauce sauce) { ... }
    public Builder cheese(boolean value) { ... }
    public Builder fries(boolean value) { ... }
    public Builder pickles(boolean value) { ... }
    public Builder spicyLevel(int level) { ... }
    public Builder notes(String notes) { ... }
    public BuilderShawarma build() { return new BuilderShawarma(this); }
}
```

Идея:
- обязательные параметры задаются в конструкторе `Builder(...)`
- опциональные настраиваются цепочкой вызовов (`return this`)
- `build()` создаёт готовый объект

Есть валидация уровня остроты:

```java
if (level < 0 || level > 5) throw new IllegalArgumentException(...);
```

---

### 3) Director (опционально): готовые рецепты

Файл: `BuilderShawarmaChef.java`

`BuilderShawarmaChef` — это «директор», который знает **как собирать** определённые варианты, используя Builder:

```java
public BuilderShawarma makeClassicChicken() {
    return new BuilderShawarma.Builder(MEDIUM, LAVASH, CHICKEN)
            .sauce(GARLIC)
            .pickles(true)
            .spicyLevel(1)
            .build();
}
```

Он удобен, когда есть «меню» стандартных рецептов.

---

### 4) Использование

Файл: `BuilderMain.java`

**Кастомная сборка**:

```java
BuilderShawarma custom = new BuilderShawarma.Builder(LARGE, LAVASH, CHICKEN)
        .sauce(BBQ)
        .cheese(true)
        .fries(true)
        .spicyLevel(3)
        .build();
```

**Пресеты через директора**:

```java
BuilderShawarmaChef chef = new BuilderShawarmaChef();
chef.makeClassicChicken().serve();
chef.makeSpicyBeef().serve();
```

---

## Зачем нужен Builder

- много параметров у объекта (особенно опциональных)
- нужны читаемые вызовы вместо `new X(a,b,c,d,e,f...)`
- нужно гарантировать обязательные поля и валидировать значения
- удобно делать «пресеты» через Director

---

## Отличие от Factory / Abstract Factory

- **Factory Method / Factory**: выбирает *какой класс создать*.
- **Abstract Factory**: создаёт *семейства связанных объектов*.
- **Builder**: создаёт *один сложный объект*, собирая его пошагово.
