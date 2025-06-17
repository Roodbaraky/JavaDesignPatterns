/*
 * (c) Midland Software Limited 2025
 * Name     : Wheel.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

public class Wheel implements StackablePart {
    int price = 50;

    @Override
    public void accept(final PartVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
