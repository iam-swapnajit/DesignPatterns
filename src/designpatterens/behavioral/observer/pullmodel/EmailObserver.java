package designpatterens.behavioral.observer.pullmodel;

public class EmailObserver implements Observer{

    private final Stock stock;

    public EmailObserver(Stock stock){
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println("Email stock price updated to "+stock.getPrice());
    }
}
