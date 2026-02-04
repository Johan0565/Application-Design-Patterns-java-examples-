# Chain of Responsibility (Цепочка обязанностей) — поддержка в шаурмечной

Паттерн **Chain of Responsibility (Цепочка обязанностей)** позволяет отправлять запрос по цепочке обработчиков, пока один из них не сможет его обработать.  
Клиент **не знает**, кто именно обработает запрос — он обращается к первому звену, а дальше ответственность «перекидывается» вверх по цепи.

В этом примере жалобы/вопросы клиентов идут по цепочке:
**RobotBot → ShiftManager → Owner**

---

## Участники паттерна в коде

### 1) Handler (абстрактный обработчик)

`SupportHandler` задаёт общий механизм:
- хранит ссылку на следующего (`nextHandler`)
- реализует `handleRequest(...)` — либо обрабатывает, либо передаёт дальше
- оставляет конкретику в абстрактных методах `canHandle()` и `process()`

```java
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String issue, int severity) {
        if (canHandle(severity)) {
            process(issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Никто не может решить эту проблему: " + issue);
        }
    }

    protected abstract boolean canHandle(int severity);
    protected abstract void process(String issue);
}
```

---

### 2) Concrete Handlers (звенья цепи)

#### Уровень 1 — RobotBot
Обрабатывает только `severity == 1` (простые вопросы):

```java
protected boolean canHandle(int severity) { return severity == 1; }
```

#### Уровень 2 — ShiftManager
Обрабатывает `severity == 2` (жалобы/возвраты):

```java
protected boolean canHandle(int severity) { return severity == 2; }
```

#### Уровень 3 — Owner
Обрабатывает `severity == 3` (критические случаи):

```java
protected boolean canHandle(int severity) { return severity == 3; }
```

---

## Как собирается цепочка

В `Main` создаются обработчики и связываются:

```java
SupportHandler bot = new RobotBot();
SupportHandler manager = new ShiftManager();
SupportHandler owner = new Owner();

bot.setNext(manager);
manager.setNext(owner);
```

Клиент всегда обращается к первому:

```java
bot.handleRequest("Холодная еда", 2);
```

Если бот не может — передаст менеджеру, если менеджер не может — владельцу.

---

## Что происходит в примерах

- `severity = 1` → отвечает `RobotBot`
- `severity = 2` → бот передаёт менеджеру → отвечает `ShiftManager`
- `severity = 3` → бот → менеджер → отвечает `Owner`
- `severity = 4` → никто не может → сообщение: «Никто не может решить…»

---

## Зачем нужен Chain of Responsibility

- убрать жёсткие `if/else` в клиентском коде («если 1 — бот, если 2 — менеджер...»)
- легко менять порядок и состав цепочки (добавлять/убирать звенья)
- разделить ответственность между обработчиками

---

## Отличие от похожих паттернов

- **Strategy** выбирает один алгоритм заранее (обычно напрямую), а тут запрос может пройти через несколько звеньев.
- **Decorator** оборачивает объект и добавляет поведение; здесь звенья не «украшают», а пытаются обработать запрос или передают дальше.
