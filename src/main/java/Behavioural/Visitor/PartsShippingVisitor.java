/*
 * (c) Midland Software Limited 2025
 * Name     : PartsShippingVisitor.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

import java.util.List;

public class PartsShippingVisitor implements PartVisitor {

    private int shipping = 0;

    @Override
    public void visit(final DelicatePart delicatePart) {
        shipping += 25;
    }

    @Override
    public void visit(final StackablePart stackablePart) {
        shipping += 5;
    }

    @Override
    public void visit(final Part part) {
        shipping += 10;
    }

    @Override
    public int visit(PartsOrder partsOrder) {
        int price = partsOrder.getPrice();
        if (price > 250) {
            System.out.println("Order price is greater than 250, shipping is free!");
            shipping = 0;
        }
        List<Part> parts = partsOrder.getParts();
        System.out.println("Order parts: " + parts + " Subtotal: " + price + " Shipping: " + shipping);
        return price+shipping;
    }
}
