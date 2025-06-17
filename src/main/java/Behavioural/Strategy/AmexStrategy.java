/*
 * (c) Midland Software Limited 2025
 * Name     : AmexStrategy.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Strategy;

public class AmexStrategy implements PaymentStrategy {

    @Override
    public boolean isValid(final String input) {
        return luhnCheck(input)
                && (input.startsWith("34") || input.startsWith("37"))
                && input.length() == 15;
    }
}
