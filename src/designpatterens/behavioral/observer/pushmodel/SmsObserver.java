package designpatterens.behavioral.observer.pushmodel;

public class SmsObserver implements Observer {

    @Override
    public void update(double price) {
        System.out.println("SMS: Stock price updated to " + price);
    }
}

