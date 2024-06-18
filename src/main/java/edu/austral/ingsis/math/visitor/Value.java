package edu.austral.ingsis.math.visitor;

public record Value(double value) implements Function {

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
