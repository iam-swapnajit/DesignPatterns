# 🍕 Decorator Pattern – Pizza Example

This document explains the **Decorator Design Pattern** using a Pizza example. It shows how new behaviors (toppings) can be added dynamically without modifying existing classes.

---

## 📌 UML Diagram (Text Representation)

```
                       <<interface>>
                         BasePizza
               --------------------------------
               + getDescription(): String
               + getCost(): double
               --------------------------------
                           ▲
          -----------------------------------------------
          |                                             |
  ClassicPizza                                  FarmHousePizza
  ------------------                              ------------------
  + getDescription()                              + getDescription()
  + getCost()                                     + getCost()
                           ▲
                           |
                   <<abstract>>
                    PizzaTopping
           --------------------------------
           - basePizza: BasePizza
           --------------------------------
           + PizzaTopping(BasePizza)
           --------------------------------
                           ▲
                ----------------------------
                |                          |
        CheeseTopping                PaneerTopping
        ------------------           ------------------
        + getDescription()           + getDescription()
        + getCost()                  + getCost()
```

---

## 🎯 Problem This Pattern Solves

If we try to create a separate class for every pizza-topping combination, we will end up with too many classes:

* CheesePizza
* PaneerPizza
* CheesePaneerPizza
* CheeseOlivePizza
* etc...

This leads to **class explosion** and poor maintainability.

---

## ✅ Solution: Decorator Pattern

The Decorator Pattern allows us to:

* Add new features dynamically
* Avoid modifying existing classes
* Follow Open-Closed Principle
* Combine behaviors flexibly

---

## 🧩 UML Components Explained

### 1️⃣ BasePizza (Component)

```java
interface BasePizza
```

* This is the common interface
* All pizzas and toppings implement this
* Defines:

    * `getDescription()`
    * `getCost()`

---

### 2️⃣ ClassicPizza, FarmHousePizza (Concrete Components)

```java
class ClassicPizza implements BasePizza
class FarmHousePizza implements BasePizza
```

* These are real base pizzas
* Provide the base cost and description

---

### 3️⃣ PizzaTopping (Abstract Decorator)

```java
abstract class PizzaTopping implements BasePizza
```

* Wraps a `BasePizza` object
* Has a HAS-A + IS-A relationship
* Enables stacking of toppings

---

### 4️⃣ CheeseTopping, PaneerTopping (Concrete Decorators)

```java
class CheeseTopping extends PizzaTopping
class PaneerTopping extends PizzaTopping
```

* Add extra behavior
* Modify cost and description
* Wrap another `BasePizza`

---

## 🔁 How Wrapping Works

```java
BasePizza pizza = new PaneerTopping(
                        new CheeseTopping(
                            new ClassicPizza()
                        )
                  );
```

Call flow:

```
PaneerTopping → CheeseTopping → ClassicPizza
```

Each decorator adds its own cost and description.

---

## 🧠 Key Advantages

| Benefit               | Explanation                             |
| --------------------- | --------------------------------------- |
| Open-Closed Principle | New toppings without modifying old code |
| No Class Explosion    | Avoids too many subclasses              |
| Runtime Flexibility   | Toppings can be chosen dynamically      |
| Clean Design          | Easy to extend and maintain             |

---

## 📘 One Line Definition

> The Decorator Pattern allows behavior to be added to individual objects dynamically by wrapping them, without changing their structure.

---

## 🏁 Example Output

```
Classic Pizza + Cheese + Paneer
Total Cost = Base + Cheese + Paneer
```

---

✨ This pattern is perfect for scenarios like:

* Pizza ordering systems
* Coffee customization
* Notification systems
* Logging frameworks



1️⃣ Object creation (MOST IMPORTANT PART)
BasePizza cheesePaneerFarmHousePizza =
new CheeseTopping(
new PaneerTopping(
new FarmHousePizza()
)
);


This is created inside → out.

Think of it like wrapping:

CheeseToping
└── PaneerTopping
└── FarmHousePizza


So the object structure in memory is:

Object	Wraps
CheeseTopping	PaneerTopping
PaneerTopping	FarmHousePizza
FarmHousePizza	nothing
2️⃣ Now this line executes
cheesePaneerFarmHousePizza.getCost();


Important:

cheesePaneerFarmHousePizza is a CheeseTopping object

So CheeseToppings.getCost() is called first

3️⃣ Step-by-step method call flow (COST)
🔹 Step 1: CheeseTopping.getCost()
@Override
public double getCost() {
return basePizza.getCost() + 50.0;
}


basePizza here = PaneerTopping

So Java says:

"I can’t calculate yet, let me ask PaneerTopping"

➡ Calls:

PaneerTopping.getCost()

🔹 Step 2: PaneerTopping.getCost()
@Override
public double getCost() {
return basePizza.getCost() + 100.0;
}


basePizza here = FarmHousePizza

Java says:

"I still can’t calculate, let me ask FarmHousePizza"

➡ Calls:

FarmHousePizza.getCost()

🔹 Step 3: FarmHousePizza.getCost()
@Override
public double getCost() {
return 300.0;
}


✅ Base case reached

No wrapping anymore

Returns 300

4️⃣ Now values start returning BACK (unwinding)
🔁 Return to PaneerTopping.getCost()
return 300 + 100;


➡ Returns 400

🔁 Return to CheeseTopping.getCost()
return 400 + 50;


➡ Returns 450

✅ Final Answer
System.out.println(cheesePaneerFarmHousePizza.getCost());

prints:

450.0

5️⃣ Visual Call Stack (Very Important)
CheeseTopping.getCost()
└── PaneerTopping.getCost()
└── FarmHousePizza.getCost()
└── returns 300
└── returns 400
└── returns 450

