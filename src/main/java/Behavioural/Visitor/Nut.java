/*
 * (c) Midland Software Limited 2025
 * Name     : Nut.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

public class Nut implements Part {
    int price = 5;

    @Override
    public void accept(final PartVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
