package ba.unsa.etf.rpr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionEvaluator {
    public static Double evaluate(String s)  throws RuntimeException{
            String[] str = s.split("\\s+");
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(str));
            Stack<String> operandi = new Stack<>();
            Stack<Double> values = new Stack<>();
            while (!q.isEmpty()) { // Read token, push if operator.
                String token = q.poll();
                switch (token) {
                    case "(":
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "sqrt":
                        operandi.push(token);
                        break;
                    case ")":
                        values.push(evaluateOp(operandi, values));
                        break;
                    default:
                        // Token not operator or paren: push double value.
                        values.push(Double.parseDouble(token));
                        break;
                }
            }
            return (evaluateOp(operandi, values));

    }

    private static Double evaluateOp(Stack<String> operandi, Stack<Double> values) {
        double v = values.pop();
        if (!operandi.empty()) {
            String op = operandi.pop();
            switch (op) {
                case "+":
                    v = values.pop() + v;
                    break;
                case "-":
                    v = values.pop() - v;
                    break;
                case "*":
                    v = values.pop() * v;
                    break;
                case "/":
                    v = values.pop() / v;
                    break;
                case "sqrt":
                    v = Math.sqrt(v);
                    break;
                default:
                    break;
            }
        }
        return v;
    }


}
