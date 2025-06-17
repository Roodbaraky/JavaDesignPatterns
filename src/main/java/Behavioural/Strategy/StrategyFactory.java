/*
 * (c) Midland Software Limited 2025
 * Name     : StrategyFactory.java
 * Author   : RoodbarakyK
 * Date     : 17 Jun 2025
 */
package Behavioural.Strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StrategyFactory {
    //Linked hashmap for ordering, in case multiple predicates are satisfied - moot in this usage
    private Map<Predicate<String>, PaymentStrategy> strategies = new LinkedHashMap<>();

    public StrategyFactory() {
        strategies.put(card -> card.startsWith("4"), new VisaStrategy());
        strategies.put(card -> card.startsWith("34") || card.startsWith("37"), new AmexStrategy());

    }

    //Instead of traditional map lookup, iterate through map checking if predicate returns true for the value -> use strategy stored as value
    public PaymentStrategy resolve(String input){
        return strategies.entrySet().stream()
                .filter(e -> e.getKey().test(input))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow();
    }
}
