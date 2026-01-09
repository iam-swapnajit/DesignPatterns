package designpatterens.behavioral.observer.pushmodel;

public class EmailObserver implements Observer {


    @Override
    public void update(double price) {

        System.out.println("Email stock price updated to "+price);
    }
}
