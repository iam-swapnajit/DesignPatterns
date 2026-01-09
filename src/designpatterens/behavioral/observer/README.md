1️⃣ Problem Statement (Why Observer Pattern?)

Imagine this real-world case:

👉 You have a Stock Price System

When the stock price changes

You want to notify:

Email service

SMS service

Dashboard UI

2️⃣ ❌ Bad Code (Tightly Coupled Design)
Problematic Implementation
public class StockService {

    private double price;

    public void updatePrice(double price) {
        this.price = price;

        // tightly coupled
        sendEmail(price);
        sendSms(price);
        updateDashboard(price);
    }

    private void sendEmail(double price) {
        System.out.println("Email sent with price: " + price);
    }

    private void sendSms(double price) {
        System.out.println("SMS sent with price: " + price);
    }

    private void updateDashboard(double price) {
        System.out.println("Dashboard updated with price: " + price);
    }
}

🚨 Problems with Bad Code

Tight Coupling

StockService knows too much about notification types.

Violates Open–Closed Principle

Adding WhatsApp notification?
❌ Modify StockService

Hard to Maintain

Removing SMS → code change

Adding logging → code change

Low Reusability

Cannot reuse notification logic easily.

👉 This is where Observer Pattern fits perfectly.

3️⃣ ✅ Observer Design Pattern (Concept)
Definition (Interview-friendly)

Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.

Roles in Observer Pattern
Role	Meaning
Subject	The object being observed
Observer	Objects that want updates
ConcreteSubject	Actual implementation
ConcreteObserver	Actual listeners
4️⃣ Observer Pattern – PULL Model

📌 Pull Model:
Observer gets notified and pulls data from subject.

Step 1: Observer Interface
public interface Observer {
void update();
}

Step 2: Subject Interface
public interface Subject {
void registerObserver(Observer observer);
void removeObserver(Observer observer);
void notifyObservers();
}

Step 3: Concrete Subject
import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private double price;

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(); // no data passed
        }
    }
}

Step 4: Concrete Observers
public class EmailObserver implements Observer {

    private final Stock stock;

    public EmailObserver(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println("Email: Stock price updated to " + stock.getPrice());
    }
}

public class SmsObserver implements Observer {

    private final Stock stock;

    public SmsObserver(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println("SMS: Stock price updated to " + stock.getPrice());
    }
}

Step 5: Test
public class Main {
public static void main(String[] args) {
Stock stock = new Stock();

        stock.registerObserver(new EmailObserver(stock));
        stock.registerObserver(new SmsObserver(stock));

        stock.setPrice(1200.50);
        stock.setPrice(1250.75);
    }
}
