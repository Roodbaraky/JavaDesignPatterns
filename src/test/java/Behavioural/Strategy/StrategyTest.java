package Behavioural.Strategy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StrategyTest {

    @ParameterizedTest
    @ValueSource(strings = {"4111111111111111", "4012888888881881", "4222222222222"})
    void testVisa(String cardNo) {
        VisaStrategy visa = new VisaStrategy();
        assertTrue(visa.isValid(cardNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"41111111111111112", "5012888888881881", "378282246310005", "3782822463105"})
    void testVisa_Invalid(String cardNo) {
        VisaStrategy visa = new VisaStrategy();
        assertFalse(visa.isValid(cardNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"378282246310005", "340000000000009"})
    void testAmex(String cardNo) {
        AmexStrategy amex = new AmexStrategy();
        assertTrue(amex.isValid(cardNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"358282246310005", "3714496353984312", "4111111111111111"})
    void testAmex_Invalid(String cardNo) {
        AmexStrategy amex = new AmexStrategy();
        assertFalse(amex.isValid(cardNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4111111111111111", "4012888888881881"})
    void testStrategyFactory_Visa(String cardNo) {
        StrategyFactory factory = new StrategyFactory();
        PaymentStrategy strategy = factory.resolve(cardNo);
        assertInstanceOf(VisaStrategy.class, strategy);
    }

    @ParameterizedTest
    @ValueSource(strings = {"378282246310005", "340000000000009"})
    void testStrategyFactory_Amex(String cardNo) {
        StrategyFactory factory = new StrategyFactory();
        PaymentStrategy strategy = factory.resolve(cardNo);
        assertInstanceOf(AmexStrategy.class, strategy);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5782822463100056", "690000000000009"})
    void testStrategyFactory_Invalid(String cardNo) {
        StrategyFactory factory = new StrategyFactory();
        assertThrows(NoSuchElementException.class, () -> factory.resolve(cardNo));

    }

}