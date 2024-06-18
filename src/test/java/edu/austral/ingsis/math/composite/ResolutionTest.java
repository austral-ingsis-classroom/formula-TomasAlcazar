package edu.austral.ingsis.math.composite;


import edu.austral.ingsis.math.composite.operaciones.*;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function function1 = new Value(1);
        final Function function2 = new Value(6);
        final Function result = new Addition(function1, function2);
        assertThat(result.solve(null), equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function function1 = new Value(12);
        final Function function2 = new Value(2);
        final Function result = new Division(function1, function2);
        assertThat(result.solve(null), equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function function1 = new Value(9);
        final Function function2 = new Value(2);
        final Function function3 = new Value(3);
        final Function function4 = new Division(function1, function2);
        final Function result = new Multiplication(function4, function3);
        assertThat(result.solve(null), equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function function1 = new Value(27);
        final Function function2 = new Value(6);
        final Function function3 = new Division(function1, function2);
        final Function funcion4 = new Value(2);
        final Function result = new Power(function3, funcion4);
        assertThat(result.solve(null), equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function function1 = new Value(36);
        final Function function2 = new Value(0.5);
        final Function result = new Power(function1, function2);

        assertThat(result.solve(null), equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function function1 = new Value(136);
        final Function result =new Module(function1);
        assertThat(result.solve(null), equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function function1 = new Value(-136);
        final Function result =new Module(function1);
        assertThat(result.solve(null), equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function function1 = new Value(5);
        final Function function3 = new Subtraction(function1, function1);
        final Function function4 = new Value(8);
        final Function result = new Multiplication(function3, function4);
        assertThat(result.solve(null), equalTo(0d));
    }
}
