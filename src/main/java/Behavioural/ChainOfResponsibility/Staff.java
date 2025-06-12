/*
 * (c) Midland Software Limited 2025
 * Name     : Staff.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Staff extends Handler {

    @Override
    public void handleRequest(final Request request) {
        if (request.getAmount() < 100) {
            System.out.println(request.getAmount() + " is less than 100. " + "Staff can handle request");
        } else {
            next.handleRequest(request);
        }
    }
}
