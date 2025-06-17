/*
 * (c) Midland Software Limited 2025
 * Name     : PartVisitor.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

public interface PartVisitor {
     void visit(Part part);

     void visit(DelicatePart delicatePart);

     void visit(StackablePart stackablePart);

     int visit(PartsOrder partsOrder);

}
