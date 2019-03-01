package dijkstras_interpreter;

import java.util.Stack;

public class DijkstraAlg {
    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public DijkstraAlg() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpreterExpression(String expression) {
        String[] expressionArray = expression.split(" "); // split the expression with white spaces

        for(String s : expressionArray) {
            if(s.equals("(")) {
                // do nothing
            } else if(s.equals("+")) {
                operationStack.push(s);
            } else if(s.equals("*")) {
                operationStack.push(s);
            } else if(s.equals((")"))) {
                String operation = operationStack.pop();

                if(operation.equals("+"))
                    this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
                else if(operation.equals("*"))
                    this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
            } else {
                this.valueStack.push((Double.parseDouble(s)));
            }
        }
    }

    public void result() {
        System.out.println(this.valueStack.pop());
    }
}
