package calculator;

// Base case
public class Number implements Expression {

    private double number; // like 5

    public Number(double number) {
        this.number = number;
    }

    /**
     * @preconditions - none
     * @postconditions - returns number 
     */
    public double compute() {
        return number;
    }
    
}