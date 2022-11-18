package ba.unsa.etf.rpr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * The type Expression evaluator.
 */
public class ExpressionEvaluator {
    /**
     * Evaluate double.
     *
     * @param s the s
     * @return the double
     * @throws RuntimeException the runtime exception
     */
    public static Double evaluate(String s)  throws RuntimeException{
            String[] str = s.split("\\s+");
            if (str.equals("")) throw new RuntimeException();
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(str));
            Stack<String> operandi = new Stack<>();
            Stack<Double> vrijednosti = new Stack<>();
            while (!q.isEmpty()) {
                String pomocni = q.poll();
                switch (pomocni) {
                    case "(":
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "sqrt":
                        operandi.push(pomocni);
                        break;
                    case ")":
                        vrijednosti.push(evaluateOperations(operandi, vrijednosti)); break;
                    default:
                        vrijednosti.push(Double.parseDouble(pomocni));  break;
                }
            }
            return (evaluateOperations(operandi, vrijednosti));

    }

    private static Double evaluateOperations(Stack<String> operandi, Stack<Double> vrijednosti) {
        double v = vrijednosti.pop();
        if (!operandi.empty()) {
            String op = operandi.pop();
            switch (op) {
                case "+":
                    v = vrijednosti.pop() + v;  break;
                case "-":
                    v = vrijednosti.pop() - v;  break;
                case "*":
                    v = vrijednosti.pop() * v;  break;
                case "/":
                    v = vrijednosti.pop() / v;  break;
                case "sqrt":
                    v = Math.sqrt(v);   break;
                default:
                    break;
            }
        }
        return v;
    }


}
