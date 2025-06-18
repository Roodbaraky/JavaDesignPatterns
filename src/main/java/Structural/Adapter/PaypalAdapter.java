/*
 * (c) Midland Software Limited 2025
 * Name     : PaypalAdapter.java
 * Author   : RoodbarakyK
 * Date     : 18 Jun 2025
 */
package Structural.Adapter;

public class PaypalAdapter implements PaymentProcessor {

    private final Paypal paypal;

    public PaypalAdapter(Paypal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(final Currency currency, final double amount) {
        paypal.sendPayment(currency, amount);
    }
}
