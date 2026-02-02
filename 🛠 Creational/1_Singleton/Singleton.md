# Singleton (Одиночка) — пример из этого проекта

Паттерн **Singleton** гарантирует, что у класса существует **ровно один экземпляр** на всё приложение, и предоставляет **глобальную точку доступа** к нему.

## Как это реализовано в коде

Файл: `Singleton.java`

1) **Запрет создания извне**  
Конструктор приватный, поэтому нельзя вызвать `new Singleton()` снаружи класса:
```java
private Singleton(){
    System.out.println("Singleton initialized!");
}
```

2) **Единственный экземпляр + ленивость**  
Экземпляр хранится во внутреннем статическом классе `SingletonHolder`:
```java
private static class SingletonHolder {
    private static final Singleton INSTANSE = new Singleton();
}
```
Это подход *Initialization-on-demand holder idiom*: объект создаётся только при первом обращении к `getInstance()` и потокобезопасен за счёт инициализации классов в JVM.

> Примечание: в коде поле названо `INSTANSE` (опечатка, обычно `INSTANCE`). На работу не влияет.

3) **Точка доступа**
```java
public static Singleton getInstance() {
    return SingletonHolder.INSTANSE;
}
```

## Где это используется

Файл: `Main.java`

```java
Singleton a = Singleton.getInstance();
Singleton b = Singleton.getInstance();
```

Проверка, что оба значения указывают на один и тот же объект:
```java
if (a == b) {
    System.out.println("It's the same object!");
}
```

## Зачем нужен Singleton

Используется, когда по дизайну нужен один общий объект (например, конфигурация, логгер, кэш).

## Важно помнить

Singleton часто создаёт глобальное состояние и может усложнять тестирование. Там, где возможно, зависимости лучше передавать явно (DI).
