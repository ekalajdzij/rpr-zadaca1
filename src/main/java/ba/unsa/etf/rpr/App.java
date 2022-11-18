package ba.unsa.etf.rpr;

public class App
{
    public static void main( String[] args ) {
        String input = new String();
        String iq = new String();
        for (int i = 0; i < args.length; i++)
                input += args[i];
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try {
            System.out.println(evaluator.evaluate(("( ( 2 / 1 ) )")));
        } catch (RuntimeException e) {
            System.out.println("Doslo je do izuzetka pogresan unos!");
        }
    }
    }

