package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Multiplication implements Function {

    Function left;

    Function right;

    public Multiplication(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
