package ba.unsa.etf.rpr;
import java.util.*;


public class ExpressionEvaluator {
    public static Double evaluate(String s) {
        try {
            String[] str = s.split("\\s+");
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(str));
            Stack<String> operands = new Stack<>();
            Stack<Double> values = new Stack<>();
            // Double v = new Double(0);
            while (!q.isEmpty()) {
                String token = q.poll();
                switch (token) {
                    case "(":
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "sqrt":
                        operands.push(token);
                        break;
                    case ")":
                        Double v = values.pop();
                        if (!operands.isEmpty()) {
                            String op = operands.pop();
                            switch (op) {
                                case "+":
                                    v = values.pop() + v;
                                    values.push(v);
                                    break;
                                case "-":
                                    v = values.pop() - v;
                                    values.push(v);
                                    break;
                                case "*":
                                    v = values.pop() * v;
                                    values.push(v);
                                    break;
                                case "/":
                                    v = values.pop() / v;
                                    values.push(v);
                                    break;
                                case "sqrt":
                                    v = Math.sqrt(v);
                                    values.push(v);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        }
                    default:
                        values.push(Double.parseDouble(token));
                        break;
                }
            }
            Double v = values.pop();
            if (!operands.isEmpty()) {
                String op = operands.pop();
                switch (op) {
                    case "+":
                        v = values.pop() + v;
                        values.push(v);
                        break;
                    case "-":
                        v = values.pop() - v;
                        values.push(v);
                        break;
                    case "*":
                        v = values.pop() * v;
                        values.push(v);
                        break;
                    case "/":
                        v = values.pop() / v;
                        values.push(v);
                        break;
                    case "sqrt":
                        v = Math.sqrt(v);
                        values.push(v);
                        break;
                    default:
                        break;
                }
            }
            return values.firstElement();
        } catch (RuntimeException e) {
            System.out.println("Doslo je do izuzetka, unos neispravan ");
        }
        return null;
    }
}
