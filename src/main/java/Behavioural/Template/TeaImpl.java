/*
 * (c) Midland Software Limited 2025
 * Name     : TeaImpl.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Template;

public class TeaImpl extends HotDrinkTemplate{
    @Override
    void brew() {
        System.out.println("Put teabag in kettle...");
        System.out.println("Pour hot water into kettle...");
        System.out.println("Sit for 5 minutes...");
    }

    @Override
    void addCondiments() {
        System.out.println("Pour milk into cup");
    }
}
