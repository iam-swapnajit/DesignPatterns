# Strategy Design Pattern

This module demonstrates the **Strategy Design Pattern** using a simple and extensible Java implementation.
The purpose of this module is to explain **the problem that leads to this pattern**, **the design approach**, and **how the solution is structured** at a low-level design (LLD) perspective.

---

## Overview

In software systems, it is very common to encounter scenarios where **the same operation can be performed in multiple ways**.
The Strategy Design Pattern provides a clean and maintainable way to handle such scenarios without tightly coupling the logic to a single class.

This module focuses on:
- Understanding the problem
- Understanding why a straightforward approach becomes difficult to maintain
- Applying the Strategy Pattern to solve it in a scalable way

---

## Problem Statement

Consider a system where a particular task can be executed using different algorithms or behaviors.
The exact behavior to be used is determined at runtime based on input, configuration, or business rules.

Typical examples include:
- Selecting different payment mechanisms
- Applying different pricing or discount calculations
- Executing different processing or routing strategies

A simple implementation often places all the logic inside a single class and chooses the behavior using conditional statements.

---

## Initial Design Approach

In the initial approach, a single class is responsible for:
- Identifying which behavior is required
- Executing the corresponding logic

This usually results in code where multiple conditions decide which logic block should run.
While this works for a small number of cases, it becomes harder to manage as new behaviors are added.

Over time, the class grows in size, becomes difficult to read, and requires modification whenever a new behavior is introduced.

---

## Design Goal

The primary goals of the design are:
- To keep each behavior independent and isolated
- To allow new behaviors to be added with minimal impact on existing code
- To make the system easier to extend, test, and maintain
- To allow behavior to be selected dynamically at runtime

---

## Strategy Pattern Solution

The Strategy Design Pattern addresses these goals by separating the **behavior definition** from the **behavior usage**.

The solution is structured as follows:
- A common **Strategy interface** defines the operation
- Each variation of the behavior is implemented in its own **Concrete Strategy class**
- A **Context class** uses a strategy to perform the operation
- The client decides which strategy should be used

This approach removes the need for conditional logic inside the context and keeps each behavior self-contained.

---

## Project Structure
src/lld/behavioral/strategy/
├── Strategy.java
├── ConcreteStrategyA.java
├── ConcreteStrategyB.java
├── StrategyContext.java
└── Main.java


---

## Class Design

### Strategy Interface

The `Strategy` interface defines a common contract that all concrete strategies must follow.
It represents the operation whose behavior can vary.

The context and client interact only with this interface, ensuring loose coupling.

---

### Concrete Strategy Classes

Each concrete strategy class:
- Implements the `Strategy` interface
- Contains one specific algorithm or behavior
- Is completely independent of other strategies

Adding a new behavior only requires creating a new strategy class.

---

### StrategyContext

The context class:
- Maintains a reference to a `Strategy`
- Delegates the execution of the operation to the selected strategy
- Allows the strategy to be changed at runtime

The context itself does not contain any business-specific logic.

---

### Client (Main Class)

The client:
- Chooses the appropriate strategy
- Supplies the strategy to the context
- Triggers execution through the context

The client does not need to know how the strategy is implemented internally.

---

## Execution Flow

1. The client creates a concrete strategy instance
2. The strategy is provided to the context
3. The client calls the context’s execution method
4. The context delegates the call to the strategy
5. The selected strategy executes its logic

This flow allows the behavior to be changed dynamically without modifying the context.

---

## Key Design Principles

This design emphasizes:
- Separation of concerns
- Loose coupling between components
- Composition over inheritance
- Clear responsibility boundaries

These principles help keep the system flexible and easy to evolve.

---

## Benefits of This Approach

- Cleaner and more readable code
- Easy addition of new behaviors
- Improved testability of individual strategies
- Reduced risk when extending functionality
- Better alignment with real-world design requirements

---

## Considerations

- The number of classes increases as behaviors grow
- For very simple use cases, the pattern may feel unnecessary
- Best suited when behavior variations are expected to change or grow

---

## How to Run

1. Navigate to the `strategy` package
2. Run the `Main` class
3. Observe how different strategies are executed without modifying the context

---

## Summary

The Strategy Design Pattern provides a structured way to handle multiple behaviors for the same operation.
By encapsulating each behavior in its own class and delegating execution, the design remains clean, flexible, and extensible.

This pattern is commonly used in real-world systems such as pricing engines, payment systems, and rule-based decision engines.

