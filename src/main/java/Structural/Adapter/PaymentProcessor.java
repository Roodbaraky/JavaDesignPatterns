/*
 * (c) Midland Software Limited 2025
 * Name     : PaymentProcessor.java
 * Author   : RoodbarakyK
 * Date     : 18 Jun 2025
 */
package Structural.Adapter;

public interface PaymentProcessor {
    void processPayment(Currency currency, double amount);
}
