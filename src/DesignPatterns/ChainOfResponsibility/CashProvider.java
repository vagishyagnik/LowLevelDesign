package DesignPatterns.ChainOfResponsibility;

public class CashProvider implements PaymentProvider {
    private PaymentProvider nextProvider;

    @Override
    public PaymentProvider setNext(PaymentProvider nextProvider) {
        this.nextProvider = nextProvider;
        return this.nextProvider;
    }
    @Override
    public PaymentProvider next() {
        return nextProvider;
    }

    @Override
    public String executePayment(Integer amount) {
        if (amount < 500) {
            return "Cash Payment for amount " + amount + " executed";
        } else if (next() != null) {
            return next().executePayment(amount);
        }
        return "No provider available for the amount";
    }
}
