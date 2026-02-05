# Bridge (Мост) — пример приготовления шаурмы

Паттерн **Bridge (Мост)** разделяет **абстракцию** и **реализацию** так, чтобы они могли изменяться **независимо** друг от друга.

В этом примере:
- **Абстракция** — это *шаурма* (какой вид мяса/рецепт).
- **Реализация** — это *устройство приготовления* (печь или гриль).

Шаурма **не наследуется** от конкретного устройства, а **содержит ссылку** на `CookingDevice` и делегирует ему низкоуровневые действия. Это и есть «мост».

---

## Участники паттерна в коде

### 1) Implementor (интерфейс реализации)

`CookingDevice` — общий интерфейс для разных способов приготовления:

```java
interface CookingDevice {
    void heatUp();
    void cookProcess(String foodName);
    double getTemperature();
}
```

---

### 2) Concrete Implementors (конкретные реализации)

**ElectricOven** — электрическая печь:

```java
class ElectricOven implements CookingDevice { ... }
```

**FireGrill** — гриль на огне:

```java
class FireGrill implements CookingDevice { ... }
```

Обе реализации делают одно и то же «по смыслу» (разогреть/готовить), но по-разному внутри.

---

### 3) Abstraction (абстракция)

`Shawarma` — абстрактный класс, который **держит ссылку** на `CookingDevice`:

```java
abstract class Shawarma {
    protected CookingDevice device; // <--- Bridge

    protected Shawarma(CookingDevice device) {
        this.device = device;
    }

    public abstract void prepare();
}
```

Здесь `device` — и есть «мост» между шаурмой и устройством приготовления.

---

### 4) Refined Abstractions (уточнённые абстракции)

**ChickenShawarma** и **BeefShawarma** определяют высокоуровневую логику `prepare()`, но низкоуровневую часть делегируют `device`:

```java
device.heatUp();
device.cookProcess("Chicken Meat");
System.out.println(device.getTemperature());
```

То есть «какую шаурму готовим» задаётся классом шаурмы, а «на чём готовим» — объектом устройства.

---

## Как используется в Main

Создаются устройства (реализации):

```java
CookingDevice oven = new ElectricOven();
CookingDevice grill = new FireGrill();
```

И затем свободно комбинируются с видами шаурмы:

```java
Shawarma meal1 = new ChickenShawarma(oven);
Shawarma meal2 = new ChickenShawarma(grill);
Shawarma meal3 = new BeefShawarma(grill);
```

Важно: **не нужно** создавать отдельные классы вроде `BeefGrillShawarma` или `ChickenOvenShawarma`.  
Комбинации получаются автоматически за счёт «моста».

---

## Зачем нужен Bridge

- чтобы не раздувать количество классов при комбинациях «тип × способ»
- чтобы менять устройства приготовления независимо от рецептов
- чтобы добавлять новые варианты без переписывания существующих

Например, можно:
- добавить новый девайс `GasOven implements CookingDevice`
- добавить новый тип `VeggieShawarma extends Shawarma`
и они будут комбинироваться без новых «гибридных» классов.

---

## Отличие от Strategy

Похоже тем, что есть композиция и взаимозаменяемые реализации.  
Разница по смыслу:
- **Strategy** — обычно про смену алгоритма поведения.
- **Bridge** — про разделение двух независимых иерархий (абстракции и реализации) и предотвращение «взрыва классов».
