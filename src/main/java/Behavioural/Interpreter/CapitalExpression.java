/*
 * (c) Midland Software Limited 2025
 * Name     : CapitalExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

import java.util.StringTokenizer;

public class CapitalExpression implements Expression {

    @Override
    public boolean interpret(final String context) {
        StringTokenizer st = new StringTokenizer(context);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.matches("^[A-Z].*")) {
                return true;
            }
        }
        return false;
    }
}
