/*
 * (c) Midland Software Limited 2025
 * Name     : CoffeeImpl.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Template;

public class CoffeeImpl extends HotDrinkTemplate{
    private boolean condiment = false;
    public CoffeeImpl() {

    }
    public CoffeeImpl(boolean condiment) {
        this.condiment = condiment;
    }


    @Override
    void brew() {
        System.out.println("Place coffee in cafetiere...");
        System.out.println("Pour over hot water...");
        System.out.println("Sit for 5 minutes...");
        System.out.println("Plunge cafetiere...");
    }

    @Override
    void addCondiments() {
        System.out.println("Add coffee condiments...");
    }

    @Override
    boolean customerWantsCondiments(){
        return condiment;
    }
}
