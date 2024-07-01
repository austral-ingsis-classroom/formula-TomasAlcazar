package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;
import edu.austral.ingsis.math.visitor.solve.Resolve;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    final Visitor<Double> visitor = new Resolve(null);

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function function1 = new Valor(1);
        final Function function2 = new Valor(6);
        final double result = visitor.visit(new Suma(function1, function2));

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function dividend = new Valor(12);
        final Function divisor = new Valor(2);
        final double result = visitor.visit(new Division(dividend, divisor));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function dividend = new Valor(9);
        final Function divisor = new Valor(2);
        final double result = visitor.visit(new Multiplication(new Division(dividend, divisor), new Valor(3)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function dividend = new Valor(27);
        final Function divisor = new Valor(6);
        final double result = visitor.visit(new Power(new Division(dividend, divisor), new Valor(2)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function base = new Valor(36);
        final Function exponent = new Division(new Valor(1), new Valor(2));
        final double result = visitor.visit(new Power(base, exponent));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function value = new Valor(136);
        final double result = visitor.visit(new Absolute(value));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function value = new Valor(-136);
        final double result = visitor.visit(new Absolute(value));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function leftOperand = new Valor(5);
        final Function rightOperand = new Valor(5);
        final Function subtraction = new Resta(leftOperand, rightOperand);
        final double result = visitor.visit(new Multiplication(subtraction, new Valor(8)));

        assertThat(result, equalTo(0d));
    }
}
