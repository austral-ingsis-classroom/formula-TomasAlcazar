package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

public interface Visitor<T> {

    T visit(Value value);

    T visit(Variable variable);

    T visit(Addition addition);

    T visit(Subtraction subtraction);

    T visit (Multiplication multiplication);

    T visit (Division division);

    T visit (Power power);

    T visit (SquareRoot square);

    T visit (Absolute absolute);

}
