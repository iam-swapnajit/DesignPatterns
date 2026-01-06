package designpatterens.behavioral.strategy;

public class PaymentContext {
    private final PaymentStategy paymentStategy;
    public PaymentContext(PaymentStategy paymentStategy){
        this.paymentStategy = paymentStategy;
    }

    public void processPayment(int amount ){
        paymentStategy.pay(amount);
    }
}
