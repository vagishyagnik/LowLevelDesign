package DesignPatterns.ChainOfResponsibility;

public class CardProvider implements PaymentProvider {
    private PaymentProvider nextProvider;
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
        if (amount < 1000) {
            return "Card Payment for amount " + amount + " executed";
        } else if (next() != null) {
            return next().executePayment(amount);
        }
        return "No provider available for the amount";
    }
}