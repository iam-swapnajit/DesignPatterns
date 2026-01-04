package lld.behavioral.strategy;

public class NetBankingPayment implements PaymentStategy{
    @Override
    public void pay(int amount) {
        // Business logic for Net banking payment
        System.out.println("Paid "+amount + " using net banking");
    }
}
