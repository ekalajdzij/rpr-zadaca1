package ba.unsa.etf.rpr;

public class App
{
    public static void main( String[] args )
    {
        //evaluateAndPrintResult("( 1 + 2 ) * 3");
        Double d = ExpressionEvaluator.evaluate("( 3 + 6 ) * 4");
        System.out.println(d);
    }
    }

