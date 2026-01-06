package designpatterens.behavioral.observer.pullmodel;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.registerObserver(new EmailObserver(stock));
        stock.registerObserver(new SmsObserver(stock));

        stock.setPrice(1200.50);
        stock.setPrice(1250.75);
    }
}
