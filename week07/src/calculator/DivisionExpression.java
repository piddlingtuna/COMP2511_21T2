package calculator;

/**
 * Recursive case of composite pattern
 */
public class DivisionExpression implements Expression {
    
    private Expression e1;
    private Expression e2;

    public DivisionExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    /**
     * @preconditions - e2 != 0 and e1, e2 != null
     * @postconditins - e1 / e2
     */
    public double compute() {
        // Example of defensive programming
        assert(e1 != null && e2 != null);
        // Example of defensive programming
        if (e2.compute() == 0) {
            // throw new CalculatorException("does not meet precondition");
        }
        return e1.compute() / e2.compute();
    }

}
