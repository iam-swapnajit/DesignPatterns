package designpatterens.behavioral.observer.pushmodel;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.registerObserver(new EmailObserver());
        stock.registerObserver(new SmsObserver());

        stock.setPrice(1200.50);
        stock.setPrice(1250.75);
    }
}
