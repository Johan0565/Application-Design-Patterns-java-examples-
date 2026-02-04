# Proxy (Прокси / Заместитель) — доступ к секретному рецепту

Паттерн **Proxy (Прокси, Заместитель)** — это объект-обёртка, который имеет **тот же интерфейс**, что и реальный объект, но **контролирует доступ** к нему.

Прокси часто используют для:
- **контроля доступа** (security / permissions)
- **ленивой инициализации** (lazy loading) тяжёлых объектов
- **логирования**, кэширования, удалённого доступа и т.п.

В этом примере прокси защищает «секретную базу рецептов» и не даёт доступ кому попало.

---

## Участники паттерна в коде

### 1) Subject (общий интерфейс)

И реальная база, и прокси выглядят одинаково для клиента:

```java
interface SecretDatabase {
    void getSecretRecipe(String userRole);
}
```

---

### 2) Real Subject (реальный объект)

`RealDatabase` — «тяжёлый»/защищённый объект (симулируется долгой инициализацией):

```java
class RealDatabase implements SecretDatabase {
    public RealDatabase() {
        System.out.println("[System] Загрузка секретной базы данных... (Heavy Init)");
    }

    public void getSecretRecipe(String userRole) {
        System.out.println("=== СЕКРЕТНЫЙ РЕЦЕПТ: ... ===");
    }
}
```

---

### 3) Proxy (заместитель)

`DatabaseProxy` реализует тот же интерфейс `SecretDatabase`, но:
- проверяет права (**Access Control**)
- создаёт реальную базу только при необходимости (**Lazy Loading**)
- логирует действия (**Logging**)

```java
class DatabaseProxy implements SecretDatabase {
    private RealDatabase realDatabase;

    public void getSecretRecipe(String userRole) {
        if (!"CHEF".equalsIgnoreCase(userRole)) {
            System.out.println("ОТКАЗАНО");
            return;
        }

        if (realDatabase == null) {
            realDatabase = new RealDatabase(); // Heavy Init только здесь
        }

        realDatabase.getSecretRecipe(userRole);
        System.out.println("Операция залогирована.");
    }
}
```

---

## Как это работает в Main

Клиент работает через интерфейс и не знает, что внутри прокси:

```java
SecretDatabase secureDB = new DatabaseProxy();
```

### Сценарий 1: Intern

```java
secureDB.getSecretRecipe("Intern");
```

Прокси откажет, и `RealDatabase` даже **не создастся**.

### Сценарий 2: Chef

```java
secureDB.getSecretRecipe("Chef");
```

Прокси разрешит доступ, создаст `RealDatabase` (произойдёт **Heavy Init**) и выдаст рецепт.

### Сценарий 3: Chef снова

```java
secureDB.getSecretRecipe("Chef");
```

`RealDatabase` уже создана, поэтому повторной «тяжёлой загрузки» не будет.

---

## Зачем нужен Proxy

- защищать доступ к важным ресурсам (роль/права)
- откладывать создание тяжёлых объектов до первого реального использования
- добавлять логирование/кэш/метрики без изменения реального класса

---

## Отличие от похожих паттернов

- **Decorator** добавляет поведение, но обычно не про контроль доступа/ленивую загрузку.
- **Facade** упрощает интерфейс системы, а прокси сохраняет **тот же интерфейс**, что и реальный объект.
- **Adapter** меняет интерфейс, чтобы совместить разные API, прокси интерфейс не меняет.
