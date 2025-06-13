/*
 * (c) Midland Software Limited 2025
 * Name     : TerminalExpression.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Interpreter;

import java.util.StringTokenizer;

public class LengthExpression implements Expression {
    private final int length;

    public LengthExpression(int length) {
        this.length = length;
    }

    @Override
    public boolean interpret(String string) {
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.length() == length) {
                return true;
            }
        }
        return false;
    }
}
