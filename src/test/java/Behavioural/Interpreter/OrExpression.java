/*
 * (c) Midland Software Limited 2025
 * Name     : OrExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

public class OrExpression implements Expression {
    private Expression left;
    private Expression right;

    public OrExpression(final Expression capitalExpression, final Expression lengthExpression) {
        this.left = capitalExpression;
        this.right = lengthExpression;
    }

    @Override
    public boolean interpret(final String context) {
        return left.interpret(context) || right.interpret(context);
    }
}
