/*
 * (c) Midland Software Limited 2025
 * Name     : OrExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

import java.util.List;

public class OrExpression implements Expression {
    private final List<Expression> expressions;

    public OrExpression(Expression... expressions) {
        this.expressions = List.of(expressions);
    }

    @Override
    public boolean interpret(final String context) {
        for (Expression expression : expressions) {
            if (expression.interpret(context)) {
                return true;
            }
        }
        return false;
    }
}
