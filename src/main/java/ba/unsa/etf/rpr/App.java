package ba.unsa.etf.rpr;

public class App
{
    public static void main( String[] args ) {
        String inputString = new String();
        for (int i = 0; i < args.length; i++)
                inputString += args[i];
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try {
            System.out.println(evaluator.evaluate((inputString)));
        } catch (RuntimeException e) {
            System.out.println("Doslo je do izuzetka pogresan unos!");
        }
    }
    }

