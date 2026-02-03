# Adapter (Адаптер) — пример оплаты в шаурмечной

Паттерн **Adapter (Адаптер)** позволяет «подружить» классы с **несовместимыми интерфейсами**.  
Клиентский код продолжает работать со знакомым интерфейсом (**Target**), а адаптер внутри вызывает методы стороннего класса (**Adaptee**) и при необходимости **преобразует данные**.

В этом примере касса принимает оплату через `PaymentProcessor.pay(rubles)`, но появляется сторонняя крипто-библиотека, которая умеет платить только методом `sendBitcoin(wallet, btc)`.

---

## Участники паттерна в коде

### 1) Target (целевой интерфейс)

То, с чем умеет работать наша система (касса):

```java
interface PaymentProcessor {
    void pay(double rubles);
}
```

---

### 2) Existing implementation (обычная реализация Target)

Оплата картой уже соответствует интерфейсу `PaymentProcessor`:

```java
class CardPayment implements PaymentProcessor {
    public void pay(double rubles) {
        System.out.println("Оплата картой прошла успешно: " + rubles + " руб.");
    }
}
```

---

### 3) Adaptee (адаптируемый класс)

Сторонняя библиотека с **другим интерфейсом**, который мы менять не можем:

```java
class CryptoLibrary {
    public void sendBitcoin(String walletAddress, double amountInBTC) { ... }
}
```

---

### 4) Adapter (адаптер)

`CryptoAdapter` реализует `PaymentProcessor`, но внутри использует `CryptoLibrary`:

```java
class CryptoAdapter implements PaymentProcessor {
    private CryptoLibrary cryptoLibrary;

    public void pay(double rubles) {
        double btcAmount = rubles * RUB_TO_BTC_RATE;
        cryptoLibrary.sendBitcoin(COMPANY_WALLET, btcAmount);
    }
}
```

Что делает адаптер:
1. Принимает данные в формате **Target** (`rubles`).
2. Конвертирует рубли в BTC (`btcAmount`).
3. Вызывает метод **Adaptee** (`sendBitcoin(wallet, btc)`).

---

### 5) Client (клиентский код)

`ShawarmaShop` вообще не знает про биткоины — он работает только с `PaymentProcessor`:

```java
class ShawarmaShop {
    private PaymentProcessor paymentProcessor;

    public void buyShawarma(double price) {
        paymentProcessor.pay(price);
    }
}
```

---

## Как используется в Main

### Сценарий 1: карта (без адаптера)

```java
PaymentProcessor cardSystem = new CardPayment();
ShawarmaShop shop1 = new ShawarmaShop(cardSystem);
shop1.buyShawarma(250);
```

---

### Сценарий 2: крипта (через адаптер)

```java
CryptoLibrary newCryptoSystem = new CryptoLibrary();
PaymentProcessor cryptoAdapter = new CryptoAdapter(newCryptoSystem);

ShawarmaShop shop2 = new ShawarmaShop(cryptoAdapter);
shop2.buyShawarma(250);
```

Магазин думает, что перед ним обычный `PaymentProcessor`, но на деле это обёртка над крипто-библиотекой.

---

## Зачем нужен Adapter

- подключать сторонние библиотеки/старые классы без переписывания клиентского кода
- постепенно мигрировать на новые системы (например, добавить новый способ оплаты)
- держать код «кассы» простым: он не знает про формат BTC, адреса кошельков и т.п.

---

## Отличие от похожих паттернов

- **Decorator** добавляет поведение, сохраняя интерфейс и смысл объекта.
- **Adapter** меняет интерфейс (подгоняет одно API под другое).
- **Facade** упрощает сложную систему, давая более простой набор методов.
