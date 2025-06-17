/*
 * (c) Midland Software Limited 2025
 * Name     : PartsOrder.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

import java.util.ArrayList;
import java.util.List;

public class PartsOrder implements Part {
    private final List<Part> parts = new ArrayList<>();
    private int subtotal;


    public PartsOrder() {

    }

    public void addPart(Part part) {
        parts.add(part);
        subtotal+=part.getPrice();
    }


    @Override
    public void accept(final PartVisitor visitor) {
        for (Part part : parts) {
            part.accept(visitor);
        }


    }

    @Override
    public int getPrice() {
        System.out.println("Subtotal: " + subtotal);
        return subtotal;
    }

    public List<Part> getParts() {
        return parts;
    }
}
