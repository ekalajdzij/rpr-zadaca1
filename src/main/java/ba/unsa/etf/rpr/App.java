package ba.unsa.etf.rpr;

public class App
{
    public static void main( String[] args )
    {
        //evaluateAndPrintResult("( 1 + 2 ) * 3");
        try {
            Double d = ExpressionEvaluator.evaluate("( 1 + ( 5 * 20 ) ) ");
            System.out.println(d);
        } catch (RuntimeException e) {
            System.out.println("Doslo je do izuzetka pogresan unos!");
        }
    }
    }

