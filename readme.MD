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

## ⚙️ Executors

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
        ExecutorService executor = Executors.newFixedThreadPool(3);

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

## 🧩 Lambda & Functional Interfaces

**What is a Lambda?**
A lambda is a **short, anonymous function** that can be passed around like a value. It removes boilerplate code and works with **functional interfaces** (interfaces with exactly one abstract method).

**Syntax:**
```java
(parameters) -> expression
(parameters) -> { statements; }
```

Below are the **8 most commonly used functional interfaces** in Java:

---

### 1️⃣ `Runnable`

| | |
|--|--|
| **Purpose** | Represents a task with **no input and no return value** |
| **Method** | `void run()` |
| **Use case** | Running code in a thread |

```java
Runnable task = () -> System.out.println("Running in a thread!");
new Thread(task).start();
// Output: Running in a thread!
```

---

### 2️⃣ `Supplier<T>`

| | |
|--|--|
| **Purpose** | **Supplies** a value without taking any input |
| **Method** | `T get()` |
| **Use case** | Lazy initialization, factory methods |

```java
Supplier<String> supplier = () -> "Hello, World!";
System.out.println(supplier.get());
// Output: Hello, World!
```

---

### 3️⃣ `Consumer<T>`

| | |
|--|--|
| **Purpose** | **Accepts** a value and performs an action, returns nothing |
| **Method** | `void accept(T t)` |
| **Use case** | Printing, logging, saving data |

```java
Consumer<String> printer = msg -> System.out.println("Message: " + msg);
printer.accept("Java Lambda");
// Output: Message: Java Lambda
```

---

### 4️⃣ `Function<T, R>`

| | |
|--|--|
| **Purpose** | **Transforms** input of type `T` into output of type `R` |
| **Method** | `R apply(T t)` |
| **Use case** | Data conversion, mapping |

```java
Function<String, Integer> lengthFunc = str -> str.length();
System.out.println(lengthFunc.apply("Polas"));
// Output: 5
```

---

### 5️⃣ `Predicate<T>`

| | |
|--|--|
| **Purpose** | **Tests** a condition on `T` and returns a `boolean` |
| **Method** | `boolean test(T t)` |
| **Use case** | Filtering, validation |

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(10));
// Output: true
```

---

### 6️⃣ `UnaryOperator<T>`

| | |
|--|--|
| **Purpose** | Special `Function<T, T>` — input and output are the **same type** |
| **Method** | `T apply(T t)` |
| **Use case** | Transforming a value in place (e.g., square, negate) |

```java
UnaryOperator<Integer> square = n -> n * n;
System.out.println(square.apply(5));
// Output: 25
```

---

### 7️⃣ `BinaryOperator<T>`

| | |
|--|--|
| **Purpose** | BinaryOperator<T> performs an operation on two values of the same type and returns a result of the same type |
| **Method** | `T apply(T t1, T t2)` |
| **Use case** | Aggregation, combining values (sum, max, merge) |

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;
System.out.println(sum.apply(10, 20));
// Output: 30
```

---

### 8️⃣ `BiFunction<T, U, R>`

| | |
|--|--|
| **Purpose** | Takes **two inputs** of different types `T` and `U`, returns type `R` |
| **Method** | `R apply(T t, U u)` |
| **Use case** | Combining two values of different types into a result |

```java
BiFunction<Integer, Double, String> combine = (a, b) -> "Result: " + (a + b);
System.out.println(combine.apply(5, 4.5));
// Output: Result: 9.5
```

---

## 🗺️ Quick Reference Cheat Sheet

| Interface | Input | Output | Method |
|-----------|-------|--------|--------|
| `Runnable` | None | None | `run()` |
| `Supplier<T>` | None | `T` | `get()` |
| `Consumer<T>` | `T` | None | `accept(T)` |
| `Function<T,R>` | `T` | `R` | `apply(T)` |
| `Predicate<T>` | `T` | `boolean` | `test(T)` |
| `UnaryOperator<T>` | `T` | `T` | `apply(T)` |
| `BinaryOperator<T>` | `T, T` | `T` | `apply(T, T)` |
| `BiFunction<T,U,R>` | `T, U` | `R` | `apply(T, U)` |

---

## 🛠️ Requirements

- Java 8 or higher (Java 17+ recommended)
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

---

> 📌 **More topics coming soon.** Feel free to contribute or suggest new topics via Issues or Pull Requests.