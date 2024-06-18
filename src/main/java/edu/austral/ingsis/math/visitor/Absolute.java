package edu.austral.ingsis.math.visitor;

public class Absolute implements Function {

    public Function function;

    public Absolute(Function function) {
        this.function = function;
    }

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
