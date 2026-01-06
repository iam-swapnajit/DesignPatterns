package designpatterens.behavioral.observer.pullmodel;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject{
    private final List<Observer> observers = new ArrayList<>();
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
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
        for (Observer observer: observers){
            observer.update();
        }

    }
}
