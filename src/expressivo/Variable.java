package expressivo;

/**
 * Represents a variable in an expression.
 * This class implements the Expression interface for representing 
 * variable names as part of an abstract syntax tree (AST).
 */
public class Variable implements Expression {
    private final String name;

    /**
     * Constructs a Variable expression.
     * 
     * @param name the name of the variable
     */
    public Variable(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Variable name cannot be null or empty");
        }
        this.name = name;
        checkRep();
    }

    /**
     * Checks the representation invariant to ensure validity.
     */
    public void checkRep() {
        assert name != null && !name.isEmpty() : "Variable name must not be null or empty";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object thatObject) {
        if (this == thatObject) {
            return true;
        }
        if (thatObject == null || getClass() != thatObject.getClass()) {
            return false;
        }
        Variable that = (Variable) thatObject;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
