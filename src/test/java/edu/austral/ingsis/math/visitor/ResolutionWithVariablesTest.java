package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;
import edu.austral.ingsis.math.visitor.solve.Resolve;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {
    final Resolve visitor = new Resolve(new HashMap<>());

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        visitor.addVariable("x", 3d);
        final Double result = visitor.visit(new Suma(new Valor(1), new Variable("x")));
        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        visitor.addVariable("div", 4d);
        final Double result = visitor.visit(new Division(new Valor(12), new Variable("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        visitor.addVariable("x", 3d);
        visitor.addVariable("y", 4d);
        final Double result = visitor.visit(new Multiplication(new Division(new Valor(9), new Variable("x")), new Variable("y")));
        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        visitor.addVariable("a", 9d);
        visitor.addVariable("b", 3d);
        final Double result = visitor.visit(new Power(new Division(new Valor(27), new Variable("a")), new Variable("b")));
        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        visitor.addVariable("z", 36d);
        final Double result = visitor.visit(new Power(new Variable("z"), new Division(new Valor(1), new Valor(2))));
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        visitor.addVariable("value", 8d);
        final Double result = visitor.visit(new Resta(new Absolute(new Variable("value")), new Valor(8)));
        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        visitor.addVariable("i", 2d);
        final double result = visitor.visit(new Multiplication(new Resta(new Valor(5), new Variable("i")), new Valor(8)));

        assertThat(result, equalTo(24d));
    }
}
