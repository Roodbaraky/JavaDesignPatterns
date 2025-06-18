package Structural.Adapter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static Structural.Adapter.CurrencyConvertor.convertToDollars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdapterTest {
    private PaymentProcessor paymentProcessor;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void paypalTest() {
        Paypal paypal = new Paypal();
        Currency currency = Currency.GBP;
        double amount = 20.0;
        paymentProcessor = new PaypalAdapter(paypal);
        paymentProcessor.processPayment(currency, amount);
        assertTrue(outputStream.toString().contains("Paypal: Sending " + amount + " " + currency + " to vendor"));
    }

    @Test
    void stripeTest(){
        Stripe stripe = new Stripe();
        Currency currency = Currency.USD;
        double amount = 20.0;
        paymentProcessor = new StripeAdapter(stripe);
        paymentProcessor.processPayment(currency, amount);
        assertTrue(outputStream.toString().contains("Charging " + amount + " dollars"));
    }

    @Test
    void stripeTest_notDollars() {
        Stripe stripe = new Stripe();
        Currency currency = Currency.GBP;
        double amount = 20.0;
        paymentProcessor = new StripeAdapter(stripe);
        paymentProcessor.processPayment(currency, amount);
        assertTrue(outputStream.toString().contains("Charging " + convertToDollars(currency, amount) + " dollars"));
    }



}