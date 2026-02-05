# Command (Команда) — заказы официанта

Паттерн **Command (Команда)** превращает запрос (действие) в отдельный объект.  
Это позволяет:
- отделить того, кто **просит** выполнить действие (Invoker), от того, кто **выполняет** (Receiver)
- хранить историю команд, ставить их в очередь
- делать **undo** (отмена/откат)

В этом примере официант принимает «листочки заказов» (команды) и передаёт их на кухню. Повар выполняет реальные действия.

---

## Участники паттерна в коде

### 1) Receiver (получатель)

`Chef` — тот, кто реально умеет готовить:

```java
class Chef {
    public void cookShawarma() { ... }
    public void cookBurger() { ... }
    public void stopCooking() { ... }
}
```

---

### 2) Command (интерфейс команды)

Любой заказ должен уметь:
- выполняться (`execute`)
- отменяться (`undo`)

```java
interface Order {
    void execute();
    void undo();
}
```

---

### 3) Concrete Commands (конкретные команды)

#### MakeShawarmaOrder

Хранит ссылку на `Chef` и знает, какой метод вызвать:

```java
class MakeShawarmaOrder implements Order {
    private Chef chef;

    public void execute() { chef.cookShawarma(); }
    public void undo() { chef.stopCooking(); }
}
```

#### MakeBurgerOrder

```java
class MakeBurgerOrder implements Order {
    private Chef chef;

    public void execute() { chef.cookBurger(); }
    public void undo() { chef.stopCooking(); }
}
```

---

### 4) Invoker (инициатор)

`Waiter` не знает, как готовится еда. Он работает только с интерфейсом `Order`:

- принимает заказы и кладёт в список
- отправляет список на кухню, вызывая `execute()` у каждой команды
- может отменить действие через `undo()`

```java
class Waiter {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) { orderList.add(order); }

    public void sendOrdersToKitchen() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

    public void cancelLastOrder(Order order) {
        order.undo();
    }
}
```

---

### 5) Client (клиентский код)

`Main` создаёт:
- одного повара (`Chef`)
- команды (`MakeShawarmaOrder`, `MakeBurgerOrder`)
- официанта (`Waiter`)

```java
Chef ahmed = new Chef();

Order order1 = new MakeShawarmaOrder(ahmed);
Order order2 = new MakeBurgerOrder(ahmed);

Waiter waiter = new Waiter();
waiter.takeOrder(order1);
waiter.takeOrder(order2);
waiter.sendOrdersToKitchen();
```

Также показана отмена:

```java
Order mistakeOrder = new MakeBurgerOrder(ahmed);
mistakeOrder.execute();      // начали готовить
waiter.cancelLastOrder(mistakeOrder); // undo()
```

---

## Зачем нужен Command

- **очередь команд**: можно копить и выполнять позже (как блокнот официанта)
- **undo/redo**: команда сама знает, как отменяться
- **логирование/история**: команды можно сохранять
- **слабая связанность**: Invoker не зависит от конкретных методов Receiver

---

## Отличие от Strategy

- **Strategy** выбирает алгоритм и обычно вызывается напрямую как поведение.
- **Command** представляет *действие-запрос* как объект (часто с возможностью отмены и очереди).
