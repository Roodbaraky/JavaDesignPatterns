/*
 * (c) Midland Software Limited 2025
 * Name     : AndExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

public class AndExpression implements Expression {
    Expression left, right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(final String context) {
        return left.interpret(context) && right.interpret(context);
    }
}
