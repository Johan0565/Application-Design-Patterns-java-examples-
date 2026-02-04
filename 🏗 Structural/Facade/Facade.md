# Facade (Фасад) — заказ шаурмы «в один вызов»

Паттерн **Facade (Фасад)** предоставляет **упрощённый интерфейс** к сложной системе из множества подсистем.  
Клиенту не нужно знать, какие классы внутри, в каком порядке их вызывать и какие параметры передавать — он работает с одним «простым входом».

В этом примере фасад превращает набор действий:
- оплата
- готовка
- упаковка
- поиск курьера
- назначение курьера

в **один метод** `orderShawarmaCombo(...)`.

---

## Подсистемы (Subsystems)

### KitchenSystem — кухня

```java
class KitchenSystem {
    public void turnOnGrill() { ... }
    public void cookOrder(String dish) { ... }
    public void packOrder() { ... }
}
```

Отвечает за разогрев, приготовление и упаковку заказа.

---

### PaymentSystem — оплата

```java
class PaymentSystem {
    public boolean makePayment(String cardNo, double amount) { ... }
}
```

Имитирует оплату через банк и возвращает успех/неуспех.

---

### DeliverySystem — доставка

```java
class DeliverySystem {
    public void findCourier() { ... }
    public void assignCourier(String address) { ... }
}
```

Находит курьера и отправляет его по адресу.

---

## Facade (Фасад)

### ShawarmaBotFacade — единая точка входа

Фасад хранит ссылки на подсистемы и знает **правильную последовательность** действий:

```java
class ShawarmaBotFacade {
    private KitchenSystem kitchen;
    private PaymentSystem payment;
    private DeliverySystem delivery;

    public void orderShawarmaCombo(String dishName, String address, String cardNo, double price) {
        boolean paid = payment.makePayment(cardNo, price);

        if (paid) {
            kitchen.turnOnGrill();
            kitchen.cookOrder(dishName);
            kitchen.packOrder();

            delivery.findCourier();
            delivery.assignCourier(address);
        }
    }
}
```

Ключевая идея: сложная логика «сначала деньги, потом кухня, потом доставка» **спрятана в фасаде**.

---

## Client (клиентский код)

`Main` ничего не знает про `KitchenSystem`, `PaymentSystem`, `DeliverySystem` и не дергает их напрямую.

Он работает только с фасадом:

```java
ShawarmaBotFacade bot = new ShawarmaBotFacade();

bot.orderShawarmaCombo(
    "Super Mega Shawarma",
    "Lenina st, 42",
    "4400-1234-5678-9000",
    7.50
);
```

---

## Зачем нужен Facade

- упрощает использование сложной системы
- скрывает детали реализации и порядок вызовов
- уменьшает связанность: клиент зависит от одного класса вместо множества
- облегчает изменения внутри подсистем (клиентский код менять не нужно, если интерфейс фасада тот же)

---

## Отличие от похожих паттернов

- **Adapter** делает совместимыми несовместимые интерфейсы.
- **Facade** не «склеивает» интерфейсы, а **упрощает доступ** к системе.
- **Mediator** управляет коммуникацией между объектами, фасад обычно просто даёт удобный API «снаружи».
