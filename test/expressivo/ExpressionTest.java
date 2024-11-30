package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Expression classes, which test the functionality of toString(), 
 * equals(), and hashCode() methods for different types of expressions.
 * These tests ensure that the Abstract Syntax Tree (AST) representations behave as expected.
 */
public class ExpressionTest {

    // ===================== Number Class Tests =====================

    /**
     * Test to verify that toString() correctly converts a Number expression into its string representation.
     */
    @Test
    public void testNumberToString() {
        Expression expr = new Number(5);
        assertEquals("5.0", expr.toString());  // Ensure the number 5 is correctly represented as "5.0"
    }

    /**
     * Test to verify that two Number expressions with the same value are equal.
     */
    @Test
    public void testNumberEqualsSameValue() {
        Expression expr1 = new Number(5);
        Expression expr2 = new Number(5);
        assertTrue(expr1.equals(expr2));  // Should return true as both represent the same number (5)
    }

    /**
     * Test to verify that two Number expressions with different values are not equal.
     */
    @Test
    public void testNumberEqualsDifferentValue() {
        Expression expr1 = new Number(5);
        Expression expr2 = new Number(6);
        assertFalse(expr1.equals(expr2));  // Should return false as 5 and 6 are different values
    }

    /**
     * Test to verify that two Number expressions with the same value have the same hashCode.
     */
    @Test
    public void testNumberHashCodeSameValue() {
        Expression expr1 = new Number(5);
        Expression expr2 = new Number(5);
        assertEquals(expr1.hashCode(), expr2.hashCode());  // Same number value, same hashCode
    }

    /**
     * Test to verify that two Number expressions with different values have different hashCodes.
     */
    @Test
    public void testNumberHashCodeDifferentValue() {
        Expression expr1 = new Number(5);
        Expression expr2 = new Number(6);
        assertNotEquals(expr1.hashCode(), expr2.hashCode());  // Different values, different hashCodes
    }

    // ===================== Variable Class Tests =====================

    /**
     * Test to verify that toString() correctly converts a Variable expression into its string representation.
     */
    @Test
    public void testVariableToString() {
        Expression expr = new Variable("x");
        assertEquals("x", expr.toString());  // Ensure the variable "x" is correctly represented as "x"
    }

    /**
     * Test to verify that two Variable expressions with the same name are equal.
     */
    @Test
    public void testVariableEqualsSame() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("x");
        assertTrue(expr1.equals(expr2));  // Should return true as both represent the same variable "x"
    }

    /**
     * Test to verify that two Variable expressions with different names are not equal.
     */
    @Test
    public void testVariableEqualsDifferent() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("y");
        assertFalse(expr1.equals(expr2));  // Should return false as variables are different
    }

    /**
     * Test to verify that two Variable expressions with the same name have the same hashCode.
     */
    @Test
    public void testVariableHashCodeSame() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("x");
        assertEquals(expr1.hashCode(), expr2.hashCode());  // Same variable name, same hashCode
    }

    /**
     * Test to verify that two Variable expressions with different names have different hashCodes.
     */
    @Test
    public void testVariableHashCodeDifferent() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("y");
        assertNotEquals(expr1.hashCode(), expr2.hashCode());  // Different variable names, different hashCodes
    }

    // ===================== Add Class Tests =====================

    /**
     * Test to verify that toString() correctly converts an Add expression into its string representation.
     */
    @Test
    public void testAddToString() {
        Expression expr = new Add(new Variable("x"), new Number(1));
        assertEquals("x + 1.0", expr.toString());  // Ensure the addition "x + 1" is represented correctly
    }

    /**
     * Test to verify that two Add expressions with commutative operands are equal.
     */
    @Test
    public void testAddEqualsCommutative() {
        Expression expr1 = new Add(new Variable("x"), new Number(1));
        Expression expr2 = new Add(new Number(1), new Variable("x"));
        assertTrue(expr1.equals(expr2));  // Should return true as addition is commutative
    }

    /**
     * Test to verify that two Add expressions with different operands are not equal.
     */
    @Test
    public void testAddEqualsDifferentOperands() {
        Expression expr1 = new Add(new Variable("x"), new Number(1));
        Expression expr2 = new Add(new Variable("x"), new Number(2));
        assertFalse(expr1.equals(expr2));  // Should return false as operands are different
    }

    /**
     * Test to verify that two Add expressions with commutative operands have the same hashCode.
     */
    @Test
    public void testAddHashCodeCommutative() {
        Expression expr1 = new Add(new Variable("x"), new Number(1));
        Expression expr2 = new Add(new Number(1), new Variable("x"));
        assertEquals(expr1.hashCode(), expr2.hashCode());  // Same operands, same hashCode
    }

    /**
     * Test to verify that two Add expressions with different operands have different hashCodes.
     */
    @Test
    public void testAddHashCodeDifferentOperands() {
        Expression expr1 = new Add(new Variable("x"), new Number(1));
        Expression expr2 = new Add(new Variable("x"), new Number(2));
        assertNotEquals(expr1.hashCode(), expr2.hashCode());  // Different operands, different hashCodes
    }

    // ===================== Multiply Class Tests =====================

    /**
     * Test to verify that toString() correctly converts a Multiply expression into its string representation.
     */
    @Test
    public void testMultiplyToString() {
        Expression expr = new Multiply(new Variable("x"), new Number(2));
        assertEquals("x * 2.0", expr.toString());  // Ensure multiplication "x * 2" is represented correctly
    }

    /**
     * Test to verify that two Multiply expressions with commutative operands are equal.
     */
    @Test
    public void testMultiplyEqualsCommutative() {
        Expression expr1 = new Multiply(new Variable("x"), new Number(2));
        Expression expr2 = new Multiply(new Number(2), new Variable("x"));
        assertTrue(expr1.equals(expr2));  // Should return true as multiplication is commutative
    }

    /**
     * Test to verify that two Multiply expressions with different operands are not equal.
     */
    @Test
    public void testMultiplyEqualsDifferentOperands() {
        Expression expr1 = new Multiply(new Variable("x"), new Number(2));
        Expression expr2 = new Multiply(new Variable("x"), new Number(3));
        assertFalse(expr1.equals(expr2));  // Should return false as operands are different
    }

    /**
     * Test to verify that two Multiply expressions with commutative operands have the same hashCode.
     */
    @Test
    public void testMultiplyHashCodeCommutative() {
        Expression expr1 = new Multiply(new Variable("x"), new Number(2));
        Expression expr2 = new Multiply(new Number(2), new Variable("x"));
        assertEquals(expr1.hashCode(), expr2.hashCode());  // Same operands, same hashCode
    }

    /**
     * Test to verify that two Multiply expressions with different operands have different hashCodes.
     */
    @Test
    public void testMultiplyHashCodeDifferentOperands() {
        Expression expr1 = new Multiply(new Variable("x"), new Number(2));
        Expression expr2 = new Multiply(new Variable("x"), new Number(3));
        assertNotEquals(expr1.hashCode(), expr2.hashCode());  // Different operands, different hashCodes
    }
}
