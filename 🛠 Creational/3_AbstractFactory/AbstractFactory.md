# Abstract Factory — пример из этого кода

Паттерн **Abstract Factory (Абстрактная фабрика)** предоставляет интерфейс для создания **целых семейств связанных объектов** (наборов), не привязывая клиентский код к конкретным классам.

В этом примере создаётся **комбо-набор**: `Shawarma` + `Drink` + `Sauce`.  
Есть два семейства продуктов: **Classic** и **Spicy**.

---

## Как это устроено в коде

### 1) Abstract Products (интерфейсы компонентов)

```java
interface Shawarma { void eat(); }
interface Drink { void sip(); }
interface Sauce { void dip(); }
```

Клиент работает **только** с этими интерфейсами.

---

### 2) Concrete Products (конкретные реализации семейств)

**Семейство 1: Classic**
- `ChickenShawarma implements Shawarma`
- `Ayran implements Drink`
- `GarlicSauce implements Sauce`

**Семейство 2: Spicy**
- `BeefShawarma implements Shawarma`
- `Cola implements Drink`
- `ChiliSauce implements Sauce`

Каждый класс реализует свой метод (`eat/sip/dip`) и печатает соответствующее сообщение.

---

### 3) Abstract Factory (интерфейс фабрики набора)

```java
interface ComboFactory {
    Shawarma createShawarma();
    Drink createDrink();
    Sauce createSauce();
}
```

Фабрика **знает**, что должно входить в набор (шаурма+напиток+соус), но не знает конкретные реализации.

---

### 4) Concrete Factories (конкретные фабрики семейств)

**ClassicComboFactory** создаёт классический набор:

```java
class ClassicComboFactory implements ComboFactory {
    public Shawarma createShawarma() { return new ChickenShawarma(); }
    public Drink createDrink() { return new Ayran(); }
    public Sauce createSauce() { return new GarlicSauce(); }
}
```

**SpicyComboFactory** создаёт острый набор:

```java
class SpicyComboFactory implements ComboFactory {
    public Shawarma createShawarma() { return new BeefShawarma(); }
    public Drink createDrink() { return new Cola(); }
    public Sauce createSauce() { return new ChiliSauce(); }
}
```

---

### 5) Client (клиентский код)

`ComboOrder` принимает **любую** фабрику `ComboFactory`, создаёт компоненты через неё и ничего не знает о конкретных классах:

```java
class ComboOrder {
    public ComboOrder(ComboFactory factory) {
        this.shawarma = factory.createShawarma();
        this.drink = factory.createDrink();
        this.sauce = factory.createSauce();
    }
}
```

`serve()` использует только интерфейсы:

```java
shawarma.eat();
sauce.dip();
drink.sip();
```

---

### 6) Использование в `main`

```java
ComboFactory classicFactory = new ClassicComboFactory();
ComboOrder order1 = new ComboOrder(classicFactory);
order1.serve();

ComboFactory spicyFactory = new SpicyComboFactory();
ComboOrder order2 = new ComboOrder(spicyFactory);
order2.serve();
```

Чтобы переключить семейство (Classic → Spicy), достаточно **подставить другую фабрику**.

---

## Зачем нужен Abstract Factory

- Гарантирует совместимость компонентов внутри семейства (например, «острое» всё острое).
- Убирает `new` из клиентского кода — клиент зависит от **абстракций**, а не конкретных классов.
- Легко добавлять новые семейства (например, `VeganComboFactory`), не меняя `ComboOrder`.

---

## Отличие от Factory Method

- **Factory Method** обычно создаёт **один продукт** (один тип объекта) через метод в иерархии создателей.
- **Abstract Factory** создаёт **набор связанных продуктов** (семейство объектов) через интерфейс фабрики.
