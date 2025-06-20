/*
 * (c) Midland Software Limited 2025
 * Name     : AndExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

import java.util.List;

public class AndExpression implements Expression {
    List<Expression> expressions;

    public AndExpression(Expression... expressions) {
        this.expressions = List.of(expressions);
    }

    @Override
    public boolean interpret(final String context) {
        for (Expression expression : expressions) {
            if (!expression.interpret(context)) {
                return false;
            }
        }
        return true;
    }
}
