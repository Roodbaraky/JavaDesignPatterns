/*
 * (c) Midland Software Limited 2025
 * Name     : Demo.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Demo {

    public static void main(String[] args) {
        Staff john = new Staff();
        Manager jamieAnn = new Manager();
        Director dan = new Director();

        john.setNext(jamieAnn);
        jamieAnn.setNext(dan);

        Request request = new Request(9999);
        john.handleRequest(request);
    }

}
