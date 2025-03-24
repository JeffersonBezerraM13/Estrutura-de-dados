package br.ufpb.dcx.jefferson;

/****************************
 * Compilation: java br.ufpb.dcx.Evaluate.java
 * Execution: java br.ufpb.dcx.Evaluate
 * Dependencies: br.ufpb.dcx.jefferson.Stack.java
 *
 *
 * % java br.ufpb.dcx.Evaluate
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * 101.0
 *
 * % java br.ufpb.dcx.Evaluate
 * ( ( 1 + sqrt ( 5 ) ) / 2.0 )
 * 1.618033988749895
 *
 *
 * Note: the operators, operands, and parentheses must be separated by whitespace. Also, each operation must be enclosed in parentheses. For example, you must write ( 1 + ( 2 + 3 ) ) instead of ( 1 + 2 + 3 ).
 *
 * Remarkably, Dijkstra's algorithm computes the same answer if we put each operator *after* its two operands instead of *between* them.
 *
 * % java br.ufpb.dcx.Evaluate
 * ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) +
 * 101.0
 *
 * Moreover, in such expressions, all parentheses are redundant!
 * Removing them yields an expression known as a postfix expression.
 * 1 2 3 + 4 5 * * +
 *
 *
 ************************************************************/

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {
                // do nothing
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
