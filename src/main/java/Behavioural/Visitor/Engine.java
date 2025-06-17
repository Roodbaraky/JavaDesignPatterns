/*
 * (c) Midland Software Limited 2025
 * Name     : Engine.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

public class Engine implements DelicatePart {
    int price = 100;

    @Override
    public void accept(final PartVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
