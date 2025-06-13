package Behavioural.Interpreter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

    @Test
    public void testLength() {
        String context = "Cat";
        Expression lengthExpression = new LengthExpression(3);
        assertTrue(lengthExpression.interpret(context));
    }

    @Test
    public void testStartsWithCapital() {
        String context = "Cat Dog";
        Expression capitalExpression = new CapitalExpression();
        assertTrue(capitalExpression.interpret(context));
    }

    @Test
    public void testNonTerminalAnd() {
        String context = "Cat Dog";
        Expression capitalExpression = new CapitalExpression();
        Expression lengthExpression = new LengthExpression(3);
        Expression andExpression = new AndExpression(capitalExpression, lengthExpression);
        assertTrue(andExpression.interpret(context));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Cat cat", "Cat Caat"})
    public void testNonTerminalOr(String input) {
        String context = input;
        Expression capitalExpression = new CapitalExpression();
        Expression lengthExpression = new LengthExpression(3);
        Expression orExpression = new OrExpression(capitalExpression, lengthExpression);
        assertTrue(orExpression.interpret(context));
    }
}