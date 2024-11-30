package expressivo;

/**
 * Represents a multiplication operation between two expressions.
 * This class implements the Expression interface for representing 
 * a multiplication operation as part of an abstract syntax tree (AST).
 */
import java.util.Objects;

public class Multiply implements Expression {
    private final Expression left;
    private final Expression right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Multiply multiply = (Multiply) obj;
        return (left.equals(multiply.left) && right.equals(multiply.right)) ||
               (left.equals(multiply.right) && right.equals(multiply.left)); // Commutative check
    }

    @Override
    public int hashCode() {
        // Ensure that hashCode respects commutative property by sorting operands
        int hashLeft = left.hashCode();
        int hashRight = right.hashCode();
        return Objects.hash(Math.min(hashLeft, hashRight), Math.max(hashLeft, hashRight)); // Commutative handling
    }

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}
