package edu.austral.ingsis.math.visitor;

public record Variable(String name) implements Function {

    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
