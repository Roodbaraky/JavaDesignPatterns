/*
 * (c) Midland Software Limited 2025
 * Name     : VisaStrategy.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Strategy;

public class VisaStrategy implements PaymentStrategy {

    @Override
    public boolean isValid(final String input) {
        return luhnCheck(input)
                && input.startsWith("4")
                && (input.length() == 13 || input.length() == 16);
    }
}
