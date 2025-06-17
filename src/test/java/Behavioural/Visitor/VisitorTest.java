package Behavioural.Visitor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisitorTest {
    private PartsOrder partsOrder;
    private PartVisitor visitor;

    @BeforeEach
    void setUp() {
        partsOrder = new PartsOrder();
        visitor = new PartsShippingVisitor();

    }

    @Test
    void delicatePartsOrder() {
        partsOrder.addPart(new Engine());
        partsOrder.accept(visitor);
        assertEquals(1, partsOrder.getParts().size());
        assertEquals(125, visitor.visit(partsOrder));
    }

    @Test
    void stackablePartsOrder() {
        partsOrder.addPart(new Wheel());
        partsOrder.accept(visitor);
        assertEquals(1, partsOrder.getParts().size());
        assertEquals(55, visitor.visit(partsOrder));
    }

    @Test
    void normalPartsOrder() {
        partsOrder.addPart(new Nut());
        partsOrder.accept(visitor);
        assertEquals(1, partsOrder.getParts().size());
        assertEquals(15, visitor.visit(partsOrder));
    }

    @Test
    void freeShippingPartsOrder() {
        partsOrder.addPart(new Engine());
        partsOrder.addPart(new Engine());
        partsOrder.addPart(new Engine());
        partsOrder.accept(visitor);
        assertEquals(3, partsOrder.getParts().size());
        assertEquals(300, visitor.visit(partsOrder));
    }

}