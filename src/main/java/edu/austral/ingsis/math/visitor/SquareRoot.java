package edu.austral.ingsis.math.visitor;

public class SquareRoot implements Function {

    Function function;

    public SquareRoot(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
