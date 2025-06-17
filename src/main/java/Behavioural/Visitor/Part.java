/*
 * (c) Midland Software Limited 2025
 * Name     : Part.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Visitor;

public interface Part {
    void accept(PartVisitor visitor);
    int getPrice();

}
