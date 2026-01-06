package designpatterens.behavioral.observer.pullmodel;

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

