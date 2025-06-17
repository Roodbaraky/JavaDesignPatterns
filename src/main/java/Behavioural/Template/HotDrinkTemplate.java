/*
 * (c) Midland Software Limited 2025
 * Name     : HotDrinkTemplate.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Template;

public abstract class HotDrinkTemplate {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            //Hook
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater() { System.out.println("Boiling water"); }
    void pourInCup() { System.out.println("Pouring into cup"); }
    boolean customerWantsCondiments() { return true; }
}
