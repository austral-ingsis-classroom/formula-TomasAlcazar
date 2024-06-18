package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Subtraction implements Function {

    private final Function a;
    private final Function b;

    public Subtraction(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    public Function getLeft() {
        return a;
    }

    public Function getRight() {
        return b;
    }

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
