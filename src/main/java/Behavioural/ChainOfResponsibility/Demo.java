/*
 * (c) Midland Software Limited 2025
 * Name     : Demo.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.ChainOfResponsibility;

public class Demo {

    public static void main(String[] args) {
        Staff John = new Staff();
        Manager JamieAnn = new Manager();
        Director Dan = new Director();

        John.setNext(JamieAnn);
        JamieAnn.setNext(Dan);

        Request request = new Request(99);
        John.handleRequest(request);
    }

}
