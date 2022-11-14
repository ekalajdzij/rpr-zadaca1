package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {
    public ExpressionEvaluator testiranje = new ExpressionEvaluator();

    @Test
    public void testEvaluatorPrvi() {
        assertEquals(101, testiranje.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

}

  