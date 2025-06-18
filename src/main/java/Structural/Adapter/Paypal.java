/*
 * (c) Midland Software Limited 2025
 * Name     : Paypal.java
 * Author   : RoodbarakyK
 * Date     : 18 Jun 2025
 */
package Structural.Adapter;

public class Paypal {
    void sendPayment(Currency currency, double amount) {
        System.out.println("Paypal: Sending " + amount + " " + currency + " to vendor");
    }
}
