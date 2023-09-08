package DesignPatterns.ChainOfResponsibility;

public interface PaymentProvider {
    PaymentProvider setNext(PaymentProvider nextProvider);
    PaymentProvider next();
    String executePayment(Integer amount);
}
