/*
 * (c) Midland Software Limited 2025
 * Name     : Manager.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Manager extends Handler {
    @Override
    public void handleRequest(final Request request) {
        if (request.getAmount() < 1000) {
            System.out.println(request.getAmount() + " is less than 1000. " + "Manager can handle request");
        } else {
            next.handleRequest(request);
        }
    }

}

