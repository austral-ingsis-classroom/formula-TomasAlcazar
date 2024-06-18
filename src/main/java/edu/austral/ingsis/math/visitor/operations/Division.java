package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public class Division implements Function {

    Function a;
    Function b;

    public Division(Function a, Function b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public <T> T accepts(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getLeft() {
        return a;
    }

    public Function getRight() {
        return b;
    }
}
