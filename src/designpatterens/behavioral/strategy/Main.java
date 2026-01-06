package designpatterens.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new NetBankingPayment());
        paymentContext.processPayment(100);

        PaymentContext paymentContext1 = new PaymentContext(new UpiPayment());
        paymentContext1.processPayment(200);


    }
}
