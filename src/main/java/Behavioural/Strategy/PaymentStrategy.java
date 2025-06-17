/*
 * (c) Midland Software Limited 2025
 * Name     : PaymentStrategy.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Strategy;

public interface PaymentStrategy {
    public boolean isValid(String input);

    default boolean luhnCheck(String input) {
        int sum = 0;
        boolean alt = false;
        for (int i = input.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(input.charAt(i));
            if (alt) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alt = !alt;
        }
        return sum % 10 == 0;
    }
}
