/*
 * (c) Midland Software Limited 2025
 * Name     : StripeAdapter.java
 * Author   : RoodbarakyK
 * Date     : 18 Jun 2025
 */
package Structural.Adapter;

import static Structural.Adapter.CurrencyConvertor.convertToDollars;

public class StripeAdapter implements PaymentProcessor {

    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;

    }

    @Override
    public void processPayment(final Currency currency, double amount) {
        if (!currency.equals(Currency.USD)) {
            amount = convertToDollars(currency, amount);
        }
        stripe.charge(amount);
    }
}
