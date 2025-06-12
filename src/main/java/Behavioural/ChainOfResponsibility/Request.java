/*
 * (c) Midland Software Limited 2025
 * Name     : Request.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Request {
    private final double amount;

    public Request(final double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
