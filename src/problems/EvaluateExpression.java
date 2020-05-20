package problems;

import java.util.ArrayList;
import java.util.Stack;

/**
     Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Input Format

     The only argument given is character array A.

     Output Format

     Return the value of arithmetic expression formed using reverse Polish Notation.

     For Example

     Input 1:
     A =   ["2", "1", "+", "3", "*"]
     Output 1:
     9
     Explaination 1:
     starting from backside:
     *: ( )*( )
     3: ()*(3)
     +: ( () + () )*(3)
     1: ( () + (1) )*(3)
     2: ( (2) + (1) )*(3)
     ((2)+(1))*(3) = 9

     Input 2:
     A = ["4", "13", "5", "/", "+"]
     Output 2:
     6
     Explaination 2:
     +: ()+()
     /: ()+(() / ())
     5: ()+(() / (5))
     1: ()+((13) / (5))
     4: (4)+((13) / (5))
     (4)+((13) / (5)) = 6
 */
public class EvaluateExpression {

    public int eval(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for(int i =0;  i< A.size(); i++) {
            String s = A.get(i);
            if(isOperator(s)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                int res = operate(op1, op2, s);
                stack.push(String.valueOf(res));
            } else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    private int operate(String op1, String op2, String op) {
        int val1 = Integer.parseInt(op1);
        int val2 = Integer.parseInt(op2);
        return switch (op) {
            case "+" -> val1 + val2;
            case "-" -> val1 - val2;
            case "*" -> val1 * val2;
            case "/" -> val1 / val2;
            default -> 0;
        };
    }
}