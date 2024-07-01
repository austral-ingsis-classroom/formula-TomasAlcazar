package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Function {
    Function value;
    Function power;
    public Power(Function left, Function right) {
        this.value = left;
        this.power = right;
    }

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return null;
    }

    public Function getValue() {
        return value;
    }

    public Function getPower() {
        return power;
    }
}
