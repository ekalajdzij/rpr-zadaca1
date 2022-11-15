package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpressionEvaluatorTest {
    public ExpressionEvaluator testiranje = new ExpressionEvaluator(); // kom

    @Test
    public void testEvaluatorPrvi() {
        assertEquals(101, testiranje.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

    @Test
    public void testEvaluatorDrugi() {assertEquals(9, testiranje.evaluate("( 3 * ( sqrt 9 ) )"));}

    @Test
    public void testEvaluatorTreci() {assertEquals(101, testiranje.evaluate("( ( 101 ) )"));}

    @Test
    public void testEvaluatorCetvrti() {assertEquals(8, testiranje.evaluate("( ( 3 + ( 4 - 2 ) + ( 1 * 3 ) ) )"));}

    @Test
    public void testEvaluatorPeti() {assertEquals(0, testiranje.evaluate("( ( 3 * 3 * 3 ) ) - 27 )"));}

    @Test
    public void testEvaluatorSesti() {assertEquals(3.6502815398728847, testiranje.evaluate("( ( ( sqrt 2 ) + ( sqrt 5 ) ) )"));}

    @Test
    public void testEvaluatorPosljendji() {assertEquals(0.6502815398728847, testiranje.evaluate("( ( ( sqrt 2 ) + ( sqrt 5 )  ) - 3 )"));}

    @Test
    public void testIzuzetak() {
        assertThrows(RuntimeException.class,()->testiranje.evaluate("( (((((188)"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("( slovo +  2 ) +/"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("( -2+  2 )"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("sqrt256 )"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("  7+1*3*5/3 "));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("(1+(2*3)/6)"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("(1 + ( 2 * 3) /6)"));
        assertThrows(RuntimeException.class,()->testiranje.evaluate("(1 + ( 2 * 3)  2sqrt 2)"));


    }
}

  