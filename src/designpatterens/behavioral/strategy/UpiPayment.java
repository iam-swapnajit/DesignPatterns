package designpatterens.behavioral.strategy;

public class UpiPayment implements PaymentStategy{
    @Override
    public void pay(int amount) {
        // Business logic for the upi payment
        System.out.println("Paid "+amount+ " using upi");

    }
}
