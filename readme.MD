# ☕ Advance Java

A structured reference for modern Java features including **Lambdas**, **Streams**, **Functional Interfaces**, and **Concurrency** — with clear examples and explanations.

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)
![License](https://img.shields.io/badge/license-MIT-blue?style=flat-square)
![Status](https://img.shields.io/badge/status-active-brightgreen?style=flat-square)

---

## 📖 Table of Contents

| # | Topic | Description |
|---|-------|-------------|
| 1 | [Predicate](#-predicate) | Test conditions on objects using `Predicate<T>` |
| 2 | [Executors](#-executors) | Run tasks asynchronously using `ExecutorService` |
| 3 | [Lambda & Functional Interfaces](#-lambda--functional-interfaces) | Core functional interfaces with real examples |

---

## 🔍 Predicate

**What is it?**
`Predicate<T>` is a functional interface that takes an input of type `T` and returns a `boolean`. It is commonly used for **filtering** and **condition checking**.

**Method signature:**
```java
boolean test(T t);
```

**Real-world Example — Fraction Checker:**

This example uses a list of `Predicate<Double>` rules. When a number is passed in, the first matching rule returns its message.

```java
package com.advance.learn.java.callback.synchronously.fraction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FractionChecker implements FractionCallback {

    static class Logical {
        Predicate<Double> predicate;
        String message;

        Logical(Predicate<Double> predicate, String message) {
            this.predicate = predicate;
            this.message = message;
        }
    }

    private List<Logical> logicals = Arrays.asList(
        new Logical(n -> n < 0,      "The number is Negative"),
        new Logical(n -> n == 0,     "The number is Zero"),
        new Logical(n -> n % 1 != 0, "The number is a Fraction"),
        new Logical(n -> n % 2 == 0, "The number is Even"),
        new Logical(n -> n % 2 != 0, "The number is Odd")
    );

    @Override
    public String fraction(double n) {
        return logicals.stream()
            .filter(p -> p.predicate.test(n))
            .findFirst()
            .map(p -> p.message)
            .orElse("Something went wrong");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Double> numbers = Arrays.asList(1.0, -2.0, 3.0, 5.5, 6.0);
        for (Double number : numbers) {
            System.out.println(new FractionChecker().fraction(number));
            Thread.sleep(1000);
        }
    }
}
```

**Expected Output:**
```
The number is Odd
The number is Negative
The number is Odd
The number is a Fraction
The number is Even
```

> 💡 **Tip:** `findFirst()` ensures only the first matching rule wins — making the order of your predicates important!

---

## ⚙️ Thread or Concurrency api

**What is it?**
`ExecutorService` manages a **pool of threads** so you don't have to create and destroy threads manually. It helps run tasks **asynchronously** and efficiently.

**Key Methods:**

| Method | Purpose |
|--------|---------|
| `submit(Runnable)` | Submit a task to the thread pool |
| `shutdown()` | Stop accepting new tasks; finish existing ones |
| `shutdownNow()` | Attempt to stop all running tasks immediately |

**Example — Processing Orders Asynchronously:**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutorExample {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        Executors.newFixedThreadPool(3)       // fixed number of threads
//        Executors.newCachedThreadPool()       // grows/shrinks dynamically
//        Executors.newSingleThreadExecutor()   // 1 thread, tasks queued
//        Executors.newWorkStealingPool()       // ForkJoinPool under the hood
//        Executors.newScheduledThreadPool(3)   // for delay/periodic tasks

        for (int i = 1; i <= 5; i++) {
            int orderId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " 🛒 Processing order #" + orderId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " ✅ Completed order #" + orderId);
            });
        }

        executor.shutdown(); // Gracefully shut down after all tasks finish
    }
}
```

**Expected Output (order may vary):**
```
pool-1-thread-1 🛒 Processing order #1
pool-1-thread-2 🛒 Processing order #2
pool-1-thread-3 🛒 Processing order #3
pool-1-thread-1 ✅ Completed order #1
pool-1-thread-1 🛒 Processing order #4
...
```

> 💡 **Tip:** With `newFixedThreadPool(3)`, only 3 orders run at a time. Orders 4 and 5 wait until a thread becomes free.

---

# ☕ Java Functional Interfaces Cheat Sheet

# ☕ Java Functional Interfaces Cheat Sheet (With Explanation & Methods)

A **Functional Interface** is an interface that contains **only one abstract method** and can be used with **lambda expressions**.

---

# 🔹 Core Functional Interfaces

### 1️⃣ `Runnable`

|                 |                                                                                         |
| --------------- | --------------------------------------------------------------------------------------- |
| **Purpose**     | Represents a task with **no input and no return value**                                 |
| **Method**      | `void run()`                                                                            |
| **Explanation** | Used when you just want to execute some code without passing data or returning anything |

```java
Runnable task = () -> System.out.println("Running in a thread!");
new Thread(task).start();
```

---

### 2️⃣ `Supplier<T>`

|                 |                                                                  |
| --------------- | ---------------------------------------------------------------- |
| **Purpose**     | Supplies a value without taking any input                        |
| **Method**      | `T get()`                                                        |
| **Explanation** | Used to generate or provide data (lazy loading, factory methods) |

```java
Supplier<String> supplier = () -> "Hello, World!";
System.out.println(supplier.get());
```

---

### 3️⃣ `Consumer<T>`

|                 |                                                            |
| --------------- | ---------------------------------------------------------- |
| **Purpose**     | Accepts a value and performs an action (no return)         |
| **Method**      | `void accept(T t)`                                         |
| **Explanation** | Used for operations like printing, logging, or saving data |

```java
Consumer<String> printer = msg -> System.out.println("Message: " + msg);
printer.accept("Java Lambda");
```

---

### 4️⃣ `Function<T, R>`

|                 |                                                                    |
| --------------- | ------------------------------------------------------------------ |
| **Purpose**     | Transforms input into output                                       |
| **Method**      | `R apply(T t)`                                                     |
| **Explanation** | Used when you need to convert or map data from one type to another |

```java
Function<String, Integer> lengthFunc = str -> str.length();
System.out.println(lengthFunc.apply("Polas"));
```

---

### 5️⃣ `Predicate<T>`

|                 |                                           |
| --------------- | ----------------------------------------- |
| **Purpose**     | Tests a condition and returns boolean     |
| **Method**      | `boolean test(T t)`                       |
| **Explanation** | Commonly used in filtering and validation |

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(10));
```

---

# 🔹 Operators

### 6️⃣ `UnaryOperator<T>`

|                 |                                                       |
| --------------- | ----------------------------------------------------- |
| **Purpose**     | Special Function where input and output are same type |
| **Method**      | `T apply(T t)`                                        |
| **Explanation** | Used to modify a value without changing its type      |

```java
UnaryOperator<Integer> square = n -> n * n;
System.out.println(square.apply(5));
```

---

### 7️⃣ `BinaryOperator<T>`

|                 |                                                  |
| --------------- | ------------------------------------------------ |
| **Purpose**     | Takes two same-type inputs and returns same type |
| **Method**      | `T apply(T t1, T t2)`                            |
| **Explanation** | Used for combining values like sum, max, merge   |

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;
System.out.println(sum.apply(10, 20));
```

---

# 🔹 Bi Functional Interfaces

### 8️⃣ `BiFunction<T, U, R>`

|                 |                                           |
| --------------- | ----------------------------------------- |
| **Purpose**     | Takes two inputs and returns a result     |
| **Method**      | `R apply(T t, U u)`                       |
| **Explanation** | Useful when combining two different types |

```java
BiFunction<Integer, Double, String> combine =
    (a, b) -> "Result: " + (a + b);

System.out.println(combine.apply(5, 4.5));
```

---

### 9️⃣ `BiConsumer<T, U>`

|                 |                                                                   |
| --------------- | ----------------------------------------------------------------- |
| **Purpose**     | Takes two inputs and performs action                              |
| **Method**      | `void accept(T t, U u)`                                           |
| **Explanation** | Used for operations like printing two values or storing key-value |

```java
BiConsumer<String, Integer> bc =
    (name, age) -> System.out.println(name + " " + age);

bc.accept("Polas", 25);
```

---

### 🔟 `BiPredicate<T, U>`

|                 |                                      |
| --------------- | ------------------------------------ |
| **Purpose**     | Takes two inputs and returns boolean |
| **Method**      | `boolean test(T t, U u)`             |
| **Explanation** | Used for comparing two values        |

```java
BiPredicate<Integer, Integer> bp =
    (a, b) -> a > b;

System.out.println(bp.test(5, 3));
```

---

# 🔹 Primitive Specializations (Performance)

### 1️⃣1️⃣ `IntPredicate`

|                 |                                 |
| --------------- | ------------------------------- |
| **Purpose**     | Predicate for int               |
| **Method**      | `boolean test(int value)`       |
| **Explanation** | Avoids boxing/unboxing overhead |

```java
IntPredicate p = x -> x % 2 == 0;
System.out.println(p.test(4));
```

---

### 1️⃣2️⃣ `IntFunction<R>`

|                 |                                  |
| --------------- | -------------------------------- |
| **Purpose**     | Takes int and returns object     |
| **Method**      | `R apply(int value)`             |
| **Explanation** | Used when input is primitive int |

```java
IntFunction<String> f = x -> "Value: " + x;
System.out.println(f.apply(10));
```

---

### 1️⃣3️⃣ `IntConsumer`

|                 |                                  |
| --------------- | -------------------------------- |
| **Purpose**     | Takes int and performs action    |
| **Method**      | `void accept(int value)`         |
| **Explanation** | Used for fast processing of ints |

```java
IntConsumer c = x -> System.out.println(x);
c.accept(100);
```

---

### 1️⃣4️⃣ `IntSupplier`

|                 |                                |
| --------------- | ------------------------------ |
| **Purpose**     | Supplies int value             |
| **Method**      | `int getAsInt()`               |
| **Explanation** | Generates primitive int values |

```java
IntSupplier s = () -> 42;
System.out.println(s.getAsInt());
```

---

# 🔹 Other Useful Functional Interfaces

### 1️⃣5️⃣ `Callable<V>`

|                 |                                               |
| --------------- | --------------------------------------------- |
| **Purpose**     | Returns a value and may throw exception       |
| **Method**      | `V call() throws Exception`                   |
| **Explanation** | Used in multi-threading when result is needed |

```java
Callable<String> c = () -> "Hello";
System.out.println(c.call());
```

---

### 1️⃣6️⃣ `Comparator<T>`

|                 |                              |
| --------------- | ---------------------------- |
| **Purpose**     | Compares two objects         |
| **Method**      | `int compare(T o1, T o2)`    |
| **Explanation** | Used for sorting collections |

```java
Comparator<Integer> comp = (a, b) -> a - b;
System.out.println(comp.compare(5, 3));
```

---

## 🗺️ Complete Quick Cheat Sheet (All Important Functional Interfaces)

| Interface         | Input | Output  | Method          |
| ----------------- | ----- | ------- | --------------- |
| Runnable          | None  | None    | `run()`         |
| Supplier<T>       | None  | T       | `get()`         |
| Consumer<T>       | T     | None    | `accept(T)`     |
| Function<T,R>     | T     | R       | `apply(T)`      |
| Predicate<T>      | T     | boolean | `test(T)`       |
| UnaryOperator<T>  | T     | T       | `apply(T)`      |
| BinaryOperator<T> | T, T  | T       | `apply(T, T)`   |
| BiFunction<T,U,R> | T, U  | R       | `apply(T, U)`   |
| BiConsumer<T,U>   | T, U  | None    | `accept(T, U)`  |
| BiPredicate<T,U>  | T, U  | boolean | `test(T, U)`    |
| IntPredicate      | int   | boolean | `test(int)`     |
| IntFunction<R>    | int   | R       | `apply(int)`    |
| IntConsumer       | int   | None    | `accept(int)`   |
| IntSupplier       | None  | int     | `getAsInt()`    |
| Callable<V>       | None  | V       | `call()`        |
| Comparator<T>     | T, T  | int     | `compare(T, T)` |

---


- Java 8 or higher (Java 17+ recommended)
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

---

> 📌 **More topics coming soon.** Feel free to contribute or suggest new topics via Issues or Pull Requests.