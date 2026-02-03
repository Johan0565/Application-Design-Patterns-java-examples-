# Decorator (Декоратор) — добавки к шаурме

Паттерн **Decorator (Декоратор)** позволяет **динамически добавлять объекту новое поведение** (или изменять существующее), не создавая множество подклассов.

В этом примере:
- есть базовая шаурма `SimpleShawarma`
- есть добавки (сыр, перец), которые **оборачивают** шаурму и увеличивают цену/описание
- добавки можно комбинировать в любом порядке и количестве (например, двойной сыр)

---

## Участники паттерна в коде

### 1) Component (общий интерфейс)

Единый интерфейс для базовой шаурмы и для всех декораторов:

```java
interface Shawarma {
    double getCost();
    String getDescription();
}
```

---

### 2) Concrete Component (базовый объект)

`SimpleShawarma` — обычная «пустая» шаурма:

```java
class SimpleShawarma implements Shawarma {
    public double getCost() { return 5.0; }
    public String getDescription() { return "Base Shawarma"; }
}
```

---

### 3) Decorator (базовый декоратор)

`ShawarmaDecorator` тоже реализует `Shawarma`, но хранит **ссылку на другой объект Shawarma внутри**:

```java
abstract class ShawarmaDecorator implements Shawarma {
    protected Shawarma tempShawarma;

    public ShawarmaDecorator(Shawarma newShawarma) {
        this.tempShawarma = newShawarma;
    }

    public double getCost() { return tempShawarma.getCost(); }
    public String getDescription() { return tempShawarma.getDescription(); }
}
```

Идея: по умолчанию декоратор просто делегирует вызовы «внутренней» шаурме.

---

### 4) Concrete Decorators (конкретные добавки)

#### CheeseDecorator (сыр)

Добавляет +1.5 к цене и дописывает `" + Cheese"` к описанию:

```java
class CheeseDecorator extends ShawarmaDecorator {
    public double getCost() { return tempShawarma.getCost() + 1.5; }
    public String getDescription() { return tempShawarma.getDescription() + " + Cheese"; }
}
```

#### PepperDecorator (острый перец)

Добавляет +0.5 к цене и `" + Hot Pepper"` к описанию:

```java
class PepperDecorator extends ShawarmaDecorator {
    public double getCost() { return tempShawarma.getCost() + 0.5; }
    public String getDescription() { return tempShawarma.getDescription() + " + Hot Pepper"; }
}
```

---

## Как это работает в Main

Шаурма собирается цепочкой обёрток:

```java
Shawarma myLunch = new SimpleShawarma();          // базовая
myLunch = new CheeseDecorator(myLunch);           // + сыр
myLunch = new PepperDecorator(myLunch);           // + перец
myLunch = new CheeseDecorator(myLunch);           // + ещё сыр (двойной)
```

Каждый новый декоратор получает «предыдущий» объект и расширяет его поведение.

---

## Зачем нужен Decorator

- добавлять функциональность **без наследования** и без взрыва количества подклассов
- собирать комбинации поведения на лету (как «добавки»)
- соблюдать принцип *Open/Closed*: можно добавлять новые декораторы, не меняя существующий код

---

## Отличие от похожих паттернов

- **Composite** строит дерево «часть-целое» и обычно управляет группами объектов.
- **Decorator** оборачивает один объект другим и добавляет поведение, сохраняя тот же интерфейс.
- **Adapter** меняет интерфейс, чтобы «подружить» несовместимые классы (а не добавить поведение).
