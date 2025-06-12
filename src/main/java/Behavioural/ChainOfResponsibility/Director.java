/*
 * (c) Midland Software Limited 2025
 * Name     : Director.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Director extends Handler {
    @Override
    public void handleRequest(final Request request) {
        System.out.println("Director handled the request of: " + request.getAmount() + ".");
    }
}
