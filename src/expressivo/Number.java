package expressivo;

/**
 * Represents a numerical constant in an expression.
 * This class implements the Expression interface for representing 
 * numeric values as part of an abstract syntax tree (AST).
 */
public class Number implements Expression {
    private final double value;

    /**
     * Constructs a Number expression.
     * 
     * @param value the numeric value to represent
     */
    public Number(double value) {
        this.value = value;
        checkRep();
    }

    /**
     * Checks the representation invariant to ensure validity.
     */
    public void checkRep() {
        // Since the number is just a double, no further checks are necessary
        assert Double.isFinite(value) : "Value of Number must be finite";
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object thatObject) {
        if (this == thatObject) {
            return true;
        }
        if (thatObject == null || getClass() != thatObject.getClass()) {
            return false;
        }
        Number that = (Number) thatObject;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
